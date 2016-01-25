package py.com.datapar.transicao.novo.repo;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import py.com.datapar.transicao.novo.model.MapeamentoTabela;
import py.com.datapar.transicao.novo.model.enums.AtualizacaoStatus;

// não remova esses comentários
// no @PersistenceContext(name="new")
// no @PersistenceContext(unitName = "new")
// no @Qualifier("novoEntityManagerFactory")
// yes @Component("tabela")
// yes @Repository("tabela")
// @CrossOrigin(origins = "http://localhost:3000")

@RepositoryRestResource(collectionResourceRel = "tabela", path = "tabela", exported = true)
public interface MapeamentoTabelaRepository extends PagingAndSortingRepository<MapeamentoTabela, Long> {
	
	Iterable<MapeamentoTabela> findByOrderByOrdemAtualizacaoAsc();
	
	Iterable<MapeamentoTabela> findById(long id);

	Iterable<MapeamentoTabela> findByTabelaOrigem(String tabela);

	Iterable<MapeamentoTabela> findByTabelaDestino(String tabela);
	
	Iterable<MapeamentoTabela> findBySincronizarIsTrue();
	
	Iterable<MapeamentoTabela> findBySincronizarIsTrueOrderByOrdemAtualizacaoAsc(); 

	Iterable<MapeamentoTabela> findFirstByOrderByIdAsc(); // sinonimo

	Iterable<MapeamentoTabela> findTopByOrderByIdAsc(); // sinonimo
	
	Iterable<MapeamentoTabela> queryFirstByOrderByIdAsc();// sinonimo

	Iterable<MapeamentoTabela> queryTopByOrderByIdAsc();// sinonimo

	@RestResource(exported = false)
	@Modifying
	@Query("update MapeamentoTabela m set m.dataUltimaAtualizacao = ?1 , m.statusUltimaAtualizacao = ?2 where m.id= ?3")
	int atualizarStatusPorId(Date data, AtualizacaoStatus status, long id);	

	@RestResource(exported = false)
	@Modifying
	@Query("update MapeamentoTabela m set m.dataUltimaAtualizacao = ?1 , m.statusUltimaAtualizacao = ?2 where m.tabelaOrigem= ?3")
	int atualizarStautsPorTabelaOrigem(Date data, AtualizacaoStatus status, String tabela);	
	
	//@Procedure("TRANSICAO_PACK.GERAR_FINANCEIRO")
	//Long gerarFinanceiro(String sql);

	//@Procedure("TRANSICAO_PACK.GERAR_CONTABILIDADE")
	//Long gerarContabilidade(String sql);
	
}
