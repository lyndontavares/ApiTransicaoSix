package py.com.datapar.transicao;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import py.com.datapar.transicao.novo.model.MapeamentoCampo;
import py.com.datapar.transicao.novo.model.MapeamentoTabela;

@Configuration
public class RepositoryConfig extends RepositoryRestMvcConfiguration {
    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(MapeamentoCampo.class);
        config.exposeIdsFor(MapeamentoTabela.class);
    }
    

}