package in.ashok.config;

 

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		  basePackages = "in.ashok.repo.db3",
		  entityManagerFactoryRef = "db3EntityManagerFactory",
		  transactionManagerRef = "db3TransactionManager"
		)
public class Db3Config {

    @Bean(name = "db3DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db3")
    public HikariDataSource db2DataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "db3EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean db3EntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("db3DataSource") DataSource dataSource) {
    	Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        return builder
                .dataSource(dataSource)
                .packages("in.ashok.entity.db3")
                .properties(properties)
                .persistenceUnit("db3")
                .build();
    }

    @Bean(name = "db3TransactionManager")
    public PlatformTransactionManager db3TransactionManager(
            @Qualifier("db3EntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}


