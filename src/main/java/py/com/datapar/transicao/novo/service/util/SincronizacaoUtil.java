package py.com.datapar.transicao.novo.service.util;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import py.com.datapar.transicao.novo.model.MapeamentoTabela;
import py.com.datapar.transicao.novo.service.enums.old.OracleColunaSqlInfo;

public class SincronizacaoUtil {

	@SuppressWarnings("unchecked")
	public static Long atualizarSequencialTabelaDestino(MapeamentoTabela tabela, EntityManager repoNew) {
		String table = "APP_SEQ_STORE";
		String pkColumnName = "APP_SEQ_NAME";
		String pkColumnValue = tabela.getChavePrimariaDestino();
		String valueColumnName = "APP_SEQ_VALUE";
		String sqlUpdateChave = "update " + table + " set " + valueColumnName + " = " + valueColumnName + " + 1 "
				+ " where " + pkColumnName + " like :VALUE";
		String sqlSelectChave = "select " + valueColumnName + " from " + table + " where " + pkColumnName
				+ " like :VALUE";

		repoNew.createNativeQuery(sqlUpdateChave).setParameter("VALUE", pkColumnValue).executeUpdate();

		List<Object> novoId = repoNew.createNativeQuery(sqlSelectChave).setParameter("VALUE", pkColumnValue)
				.getResultList();

		return novoId.size() > 0 ? ((BigDecimal) novoId.get(0)).longValue() : 0L;
	}

	@SuppressWarnings("unchecked")
	public static Long atualizarSequencialTabelaDestinoPK(MapeamentoTabela tabela, EntityManager repoNew) {
		String table = "APP_SEQ_STORE";
		String pkColumnName = "APP_SEQ_NAME";
		String pkColumnValue = tabela.getTabelaDestino() + ".PK";
		String valueColumnName = "APP_SEQ_VALUE";
		String sqlUpdateChave = "update " + table + " set " + valueColumnName + " = " + valueColumnName + " + 1 "
				+ " where " + pkColumnName + " like :VALUE";
		String sqlSelectChave = "select " + valueColumnName + " from " + table + " where " + pkColumnName
				+ " like :VALUE";

		repoNew.createNativeQuery(sqlUpdateChave).setParameter("VALUE", pkColumnValue).executeUpdate();

		List<Object> novoId = repoNew.createNativeQuery(sqlSelectChave).setParameter("VALUE", pkColumnValue)
				.getResultList();

		return novoId.size() > 0 ? Long.valueOf(novoId.get(0).toString()) : 0L;
	}

	public static boolean dataSourceOracle(EntityManager em) {
		return em.getEntityManagerFactory().getProperties().get("javax.persistence.nonJtaDataSource").toString()
				.indexOf("oracle") > -1;
	}

	public static boolean dataSourceMySql(EntityManager em) {
		return em.getEntityManagerFactory().getProperties().get("javax.persistence.nonJtaDataSource").toString()
				.indexOf("mysql") > -1;
	}

	public long tamanhoDaColunaOracle(Object[] campo) {
		if (campo[OracleColunaSqlInfo.TAMANHO.getPosicao()] != null) {
			return Long.valueOf(campo[OracleColunaSqlInfo.TAMANHO.getPosicao()].toString());
		}
		else {
			return 0;
		}
	}

}
