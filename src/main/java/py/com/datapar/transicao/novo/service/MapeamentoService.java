package py.com.datapar.transicao.novo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import py.com.datapar.transicao.novo.model.MapeamentoCampo;
import py.com.datapar.transicao.novo.model.MapeamentoTabela;
import py.com.datapar.transicao.novo.model.enums.TipoCampo;
import py.com.datapar.transicao.novo.repo.MapeamentoTabelaRepository;
import py.com.datapar.transicao.novo.service.enums.ColunaSqlInfo;
import py.com.datapar.transicao.novo.service.enums.old.OracleColunaSqlInfo;
import py.com.datapar.transicao.novo.service.util.SincronizacaoUtil;

@Service
public class MapeamentoService {

	private final String oracleSqlColunaInfo = "select c.* from user_tables t, user_tab_columns c where c.table_name = t.table_name and c.table_name = :TABELA";
	private final String mySqlColunaInfo = "select i.table_name,i.column_name, i.data_type, i.character_maximum_length, i.numeric_precision, i.numeric_scale, i.datetime_precision, i.column_type, i.column_key from information_schema.columns i where i.table_name= :TABELA";

	@Autowired
	MapeamentoTabelaRepository tabelaRepo;

	@Autowired
	@Qualifier("novoEntityManagerFactory")
	EntityManager repoNew;

	@Autowired
	@Qualifier("oldEntityManagerFactory")
	EntityManager repoOld;

	/**
	 * <p>
	 * Adicionar campos da tabela origem para tabela destino.
	 * 
	 * @param tabela
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public void adicionarCamposDaTabelaOriemNaTabelaDestino(MapeamentoTabela tabela) {
		String sql = "";

		if (dataSourceOracle(repoOld)) {
			sql = oracleSqlColunaInfo;
		}
		else if (dataSourceMySql(repoOld)) {
			sql = mySqlColunaInfo;
		}

		List<Object[]> queryCampos = repoOld.createNativeQuery(sql).setParameter("TABELA", tabela.getTabelaOrigem())
				.getResultList();

		for (Object[] c : queryCampos) {
			MapeamentoCampo mc = new MapeamentoCampo();
			mc.setTabela(tabela);
			mc.setId(SincronizacaoUtil.atualizarSequencialTabelaDestinoPK(tabela, repoNew));
			mc.setNomeOrigem(c[ColunaSqlInfo.COLUNA.getPosicao()].toString());
			mc.setNomeDestino(c[ColunaSqlInfo.COLUNA.getPosicao()].toString());
			mc.setTipoOrigem(TipoCampo.fromString(c[ColunaSqlInfo.TIPO.getPosicao()].toString()));
			mc.setTipoDestino(TipoCampo.fromString(c[ColunaSqlInfo.TIPO.getPosicao()].toString()));
			mc.setTamanhoOrigem(tamanhoDaColuna(c));
			mc.setTamanhoDestino(tamanhoDaColuna(c));
			repoNew.merge(mc);
		}
 	}

	private long tamanhoDaColuna(Object[] campo) {
		if (campo[OracleColunaSqlInfo.TAMANHO.getPosicao()] != null) {
			return Long.valueOf(campo[ColunaSqlInfo.TAMANHO.getPosicao()].toString());
		}
		else {
			return 0;
		}
	}

	private boolean dataSourceOracle(EntityManager em) {
		return em.getEntityManagerFactory().getProperties().get("javax.persistence.nonJtaDataSource").toString()
				.indexOf("oracle") > -1;
	}

	private boolean dataSourceMySql(EntityManager em) {
		return em.getEntityManagerFactory().getProperties().get("javax.persistence.nonJtaDataSource").toString()
				.indexOf("mysql") > -1;
	}

}
