package py.com.datapar.transicao;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	    entityManagerFactoryRef = "oldEntityManagerFactory",
	    transactionManagerRef = "oldTransactionManager",
	    basePackages = {"py.com.datapar.transicao.old.repo"})
public class ConfiguracaoOld {
    
    @Bean(name = "oldDataSource")
    @ConfigurationProperties(prefix="spring.old")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

 
    @Bean(name="oldEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean novoEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(primaryDataSource())
                .packages("py.com.datapar.transicao.old.model")
                .persistenceUnit("old")
                .build();
    }


    @Bean(name = "oldTransactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier(value = "oldEntityManagerFactory")  EntityManagerFactory oldEntityManager){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(oldEntityManager);
		return transactionManager;
	}
 
}
