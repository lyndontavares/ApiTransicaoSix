package py.com.datapar.transicao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "novoEntityManagerFactory", transactionManagerRef = "novoTransactionManager", basePackages = {
		"py.com.datapar.transicao.novo.repo" })
public class ConfiguracaoNovo {

	@Primary
	@Bean(name = "novoDataSource")
	@ConfigurationProperties(prefix = "spring.new")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "novoEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean novoEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		
		/*  Properties additionalProperties = new Properties();
		    additionalProperties.put(
		        "hibernate.dialect", 
		        env.getProperty("hibernate.dialect"));
		    additionalProperties.put(
		        "hibernate.show_sql", 
		        env.getProperty("hibernate.show_sql"));
		    additionalProperties.put(
		        "hibernate.hbm2ddl.auto", 
		        env.getProperty("hibernate.hbm2ddl.auto"));
		    entityManagerFactory.setJpaProperties(additionalProperties);*/
		
		return builder
				.dataSource(primaryDataSource())
				.packages("py.com.datapar.transicao.novo.model")
				.persistenceUnit("new")
				.properties(buildProperties())
				.build();
	}

	@Primary
	@Bean(name = "novoTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier(value = "novoEntityManagerFactory") EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	private Map<String, Object> buildProperties() {
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	

}
