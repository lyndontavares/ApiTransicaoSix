package py.com.datapar.transicao.novo.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import py.com.datapar.transicao.novo.model.MapeamentoCampo;

// Use para qualificação
// @Repository("campo")  
// @Component("campo")

@RepositoryRestResource(collectionResourceRel = "campo", path = "campo", exported = true)
public interface MapeamentoCampoRepository extends PagingAndSortingRepository<MapeamentoCampo, Long> {

}
