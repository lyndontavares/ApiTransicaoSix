package py.com.datapar.transicao.novo.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import py.com.datapar.transicao.novo.model.MapeamentoCampo;
import py.com.datapar.transicao.novo.model.MapeamentoTabela;
import py.com.datapar.transicao.novo.model.enums.AtualizacaoStatus;
import py.com.datapar.transicao.novo.repo.MapeamentoTabelaRepository;
import py.com.datapar.transicao.novo.service.enums.SincronizacaoTipo;

@Service("sincro")
public class Sincronizar {

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
	 * Sincronizar tabela
	 * </p>
	 * <p>
	 * Estratégia de atualização de tabelas usada na API de transicao.
	 * </p>
	 * tipo de estratégias:
	 * <ul>
	 * <li>SIMPLE - copia os últimos registros novos para tabela destino.
	 * <li>UPDATE - atualiza os registro já existentes e copia os novos.
	 * <li>FULL - remove todos os registros da tabela destino antes de copiar.
	 * </ul>
	 * 
	 * @author Lyndon Tavares
	 * @param tabela
	 *            tabela
	 * @return true
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	@Qualifier("novoTransactionManager")
	public boolean sincronizarTabela(MapeamentoTabela tabela, SincronizacaoTipo tipo) {

		// validacao tabela
		if ( tabelaValidaParaSincronizacao(tabela) ) {
			tabelaRepo.atualizarStatusPorId(new Date(), AtualizacaoStatus.ERRO, tabela.getId());
			return false;
		} else {

			// origem
			String sql = getSqlSelectOrigem(tabela) + " where " + tabela.getChavePrimaria() + ">"
					+ retornaUltimoSequencialNovaTabela(tabela);
			List<Object[]> queryOld = repoOld.createNativeQuery(sql).getResultList();

			// destino
			String sqlInsert = getSqlInsertComCodigoLegado(tabela);

			for (Object[] registro : queryOld) {
				Query query = repoNew.createNativeQuery(sqlInsert);
				setParametrosSqlInsertComCodigoLegado(tabela, registro, query);
				query.executeUpdate(); // return num.entities updated/deleted
			}

			// status atualizacao
			tabelaRepo.atualizarStatusPorId(new Date(), AtualizacaoStatus.SUCESSO, tabela.getId());

		}

		return true;
	}

	private boolean tabelaValidaParaSincronizacao(MapeamentoTabela tabela) {
		return (tabela.getChavePrimaria() != null) && 
		(tabela.getChavePrimariaDestino() != null) && 
		(tabela.getOrdemAtualizacao() == 0);
	}

	@SuppressWarnings("unchecked")
	private Long retornaUltimoSequencialNovaTabela(MapeamentoTabela tabela) {
		List<Object> ultimoId = repoNew.createNativeQuery("select max(codigo_legado) from " + tabela.getTabelaDestino())
				.getResultList();
		return (ultimoId.get(0) == null) ? 0L : Long.valueOf(ultimoId.get(0).toString());
	}

	/**
	 * Sincronizar tabela
	 * <p>
	 * Teste de atualizaçãode tabela. Não use para produção.
	 * <p>
	 * 
	 * @author Lyndon Tavares
	 * @param tabela
	 * @return true
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	@Qualifier("novoTransactionManager")
	public boolean sincronizarTabela(MapeamentoTabela tabela) {

		// origem
		String sql = getSqlSelectOrigem(tabela);
		List<Object[]> queryOld = repoOld.createNativeQuery(sql).getResultList();

		// destino
		String sqlInsert = getSqlInsert(tabela);
		for (Object[] registro : queryOld) {
			Query query = repoNew.createNativeQuery(sqlInsert);
			setParametrosSqlInsert(tabela, registro, query);
			query.executeUpdate(); // return num.entities updated/deleted
		}

		return true;
	}

	/**
	 * <p>
	 * Sincronizar todas as tabelas por ordem de integride referencial
	 * </p>
	 * <p>
	 * Estratégia de atualização de tabelas usada na API de transicao.
	 * </p>
	 * tipo de estratégias:
	 * <ul>
	 * <li>SIMPLE - copia os últimos registros para tabela destino.
	 * <li>UPDATE - atualiza os registro já existentes e copia os novos.
	 * <li>FULL - remove todos os registros da tabela destino antes de copiar.
	 * </ul>
	 * 
	 * @author Lyndon Tavares
	 * @return true
	 */
	@Transactional
	@Qualifier("novoTransactionManager")
	public boolean sincronizarAll() {
		Iterable<MapeamentoTabela> tabelas = tabelaRepo.findByOrderByOrdemAtualizacaoAsc();
		for (MapeamentoTabela tabela : tabelas) {
			sincronizarTabela(tabela, SincronizacaoTipo.SIMPLE);
		}
		return true;
	}

	/**
	 * Sincronizar tabelas marcadas para sincronizar:
	 * </p>
	 * api_table.sicronizar=1
	 * </p>
	 * Estratégia de atualização de tabelas usada na API de transicao.
	 * </p>
	 * tipo de estratégias:
	 * <ul>
	 * <li>SIMPLE - copia os últimos registros para tabela destino.
	 * <li>UPDATE - atualiza os registro já existentes e copia os novos.
	 * <li>FULL - remove todos os registros da tabela destino antes de copiar.
	 * </ul>
	 * 
	 * @author Lyndon Tavares
	 * @return true
	 */
	@Transactional
	@Qualifier("novoTransactionManager")
	public boolean sincronizarMarcadasParaSincronizar() {
		Iterable<MapeamentoTabela> tabelas = tabelaRepo.findBySincronizarIsTrueOrderByOrdemAtualizacaoAsc();
		for (MapeamentoTabela tabela : tabelas) {
			sincronizarTabela(tabela, SincronizacaoTipo.SIMPLE);
		}
		return true;
	}

	/**
	 * <p>
	 * Sincronizar tabelas passadas por parâmetro
	 * </p>
	 * <p>
	 * Estratégia de atualização de tabelas usada na API de transicao.
	 * </p>
	 * tipo de estratégias:
	 * <ul>
	 * <li>SIMPLE - copia os últimos registros para tabela destino.
	 * <li>UPDATE - atualiza os registro já existentes e copia os novos.
	 * <li>FULL - remove todos os registros da tabela destino antes de copiar.
	 * </ul>
	 * 
	 * @author Lyndon Tavares
	 * @param List<tabela>
	 * @return true
	 */
	@Transactional
	@Qualifier("novoTransactionManager")
	public boolean sincronizarAll(List<MapeamentoTabela> tabelas) {
		for (MapeamentoTabela tabela : tabelas) {
			sincronizarTabela(tabela);
		}
		return true;
	}

	private void setParametrosSqlInsert(MapeamentoTabela tabela, Object[] registro, Query query) {
		for (int i = 0; i < tabela.getCampos().size(); i++) {
			String nomeParametro = tabela.getCampos().get(i).getNomeDestino();
			query.setParameter(nomeParametro, registro[i]);
		}
	}

	private void setParametrosSqlInsertComCodigoLegado(MapeamentoTabela tabela, Object[] registro, Query query) {

		// toda tabela nova tem pk = id
		query.setParameter("ID", atualizarSequencialTabelaDestino(tabela));

		// demais parametros
		for (int i = 1; i < tabela.getCampos().size(); i++) {
			String nomeParametro = tabela.getCampos().get(i).getNomeDestino();
			query.setParameter(nomeParametro, registro[i]);
		}

		// TODO refatorar para montar o codigo legado com todos os campos
		// marcados como chave primaria
		query.setParameter("CODIGO_LEGADO", registro[0] );
	}

	private String getSqlSelectOrigem(MapeamentoTabela tabela) {
		String sql = "select ";
		String listaDeCampos = "";
		for (MapeamentoCampo campo : tabela.getCampos()) {
			listaDeCampos += campo.getNomeOrigem() + ",";
		}
		listaDeCampos = removeUltimoCaractere(listaDeCampos);
		sql = sql + listaDeCampos + " from " + tabela.getTabelaOrigem();
		return sql;
	}

	/*
	 * private String getSqlSelectDestino(MapeamentoTabela tabela) { String sql
	 * = "select "; String listaDeCampos = ""; for (MapeamentoCampo campo :
	 * tabela.getCampos()) { listaDeCampos += campo.getNomeDestino() + ","; }
	 * listaDeCampos = removeUltimoCaractere(listaDeCampos); sql = sql +
	 * listaDeCampos + " from " + tabela.getTabelaDestino(); return sql; }
	 */

	private String getSqlInsert(MapeamentoTabela tabela) {
		String sql = "insert into " + tabela.getTabelaDestino() + " ";

		String listaDeCampos = "";
		String listaDeParametros = "";

		for (MapeamentoCampo campo : tabela.getCampos()) {
			listaDeCampos += campo.getNomeDestino() + ",";
			listaDeParametros += ":" + campo.getNomeDestino() + ",";
		}

		listaDeCampos = removeUltimoCaractere(listaDeCampos);
		listaDeCampos = "(" + listaDeCampos + ")";

		listaDeParametros = removeUltimoCaractere(listaDeParametros);
		listaDeParametros = "(" + listaDeParametros + ")";

		sql = sql + listaDeCampos + " values " + listaDeParametros;

		return sql;
	}

	private String getSqlInsertComCodigoLegado(MapeamentoTabela tabela) {
		String sql = "insert into " + tabela.getTabelaDestino() + " ";

		String listaDeCampos = "";
		String listaDeParametros = "";

		for (MapeamentoCampo campo : tabela.getCampos()) {
			listaDeCampos += campo.getNomeDestino() + ",";
			listaDeParametros += ":" + campo.getNomeDestino() + ",";
		}

		listaDeCampos = listaDeCampos + "CODIGO_LEGADO";
		listaDeCampos = "(" + listaDeCampos + ")";

		listaDeParametros = listaDeParametros + ":CODIGO_LEGADO";
		listaDeParametros = "(" + listaDeParametros + ")";

		sql = sql + listaDeCampos + " values " + listaDeParametros;

		return sql;
	}

	private String removeUltimoCaractere(String sql) {
		return sql.substring(0, sql.length() - 1);
	}

	@SuppressWarnings("unchecked")
	private Long atualizarSequencialTabelaDestino(MapeamentoTabela tabela) {
		String table = "APP_SEQ_STORE";
		String pkColumnName = "APP_SEQ_NAME";
		String pkColumnValue = tabela.getChavePrimariaDestino();
		String valueColumnName = "APP_SEQ_VALUE";
		String sqlUpdateChave = "update " + table + " set " + valueColumnName + " = " + valueColumnName + " + 1 "
				+ " where " + pkColumnName + " = :VALUE";
		String sqlSelectChave = "select " + valueColumnName + " from " + table + " where " + pkColumnName
				+ " = :VALUE";

		repoNew.createNativeQuery(sqlUpdateChave).setParameter("VALUE", pkColumnValue).executeUpdate();

		List<Object> novoId = repoNew.createNativeQuery(sqlSelectChave).setParameter("VALUE", pkColumnValue)
				.getResultList();

		return novoId.size() > 0 ? ((BigDecimal) novoId.get(0)).longValue() : 0L;
	}

	/*
	 * private String retornaChavePrimariaTabela(Class<?> tabela) throws
	 * Exception { return UtilAnnotation.getAnnotationValue(tabela,
	 * javax.persistence.Table.class, "name").toString(); }
	 */

}
