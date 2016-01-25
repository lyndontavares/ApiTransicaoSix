package py.com.datapar.transicao.old.repo;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import py.com.datapar.transicao.old.model.Localidade;

@Repository("oldLocalidadeResource")
@RepositoryRestResource(collectionResourceRel = "oldlocalidade", path = "oldlocalidade", exported = true)
public interface LocalidadeResource extends JpaRepository<Localidade, Long>{

}
