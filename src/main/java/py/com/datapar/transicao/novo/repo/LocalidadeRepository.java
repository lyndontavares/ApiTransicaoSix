package py.com.datapar.transicao.novo.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import py.com.datapar.transicao.novo.model.dolphinx.endereco.Localidade;

@RepositoryRestResource(collectionResourceRel = "loca", path = "loca", exported = true)
public interface LocalidadeRepository extends PagingAndSortingRepository<Localidade, Long> {

}
