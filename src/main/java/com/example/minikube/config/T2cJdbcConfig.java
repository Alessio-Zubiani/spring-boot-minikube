package com.example.minikube.config;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import com.example.minikube.properties.T2cHibernateConfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "t2cEntityManager",
        transactionManagerRef = "t2cTransactionManager",
        basePackages = {
    		"com.example.minikube.t2c.repository"
        })
@RequiredArgsConstructor
public class T2cJdbcConfig {
	
	private final T2cHibernateConfig config;
	
	
	@Bean(name = "t2cDataSource")
	public DataSource t2cDataSource() {
		
		log.info("Connecting to schema: [{}]", this.config.getDatasource().getUsername());
		
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(this.config.getDatasource().getDriver());
        dataSourceBuilder.url(this.config.getDatasource().getUrl());
        dataSourceBuilder.username(this.config.getDatasource().getUsername());
        dataSourceBuilder.password(this.config.getDatasource().getPassword());
        
        return dataSourceBuilder.build();
	}

	@Bean(name = "t2cEntityManager")
	public LocalContainerEntityManagerFactoryBean t2cEntityManager(EntityManagerFactoryBuilder builder, @Qualifier("t2cDataSource") DataSource t2cDataSource) {
		
		Map<String, String> properties = new HashMap<>();
		properties.put("hibernate.dialect", this.config.getHibernate().getDialect());
		properties.put("hibernate.show_sql", this.config.getHibernate().getShowSql());
		properties.put("hibernate.format_sql", this.config.getHibernate().getFormatSql());
		
		return builder
				.dataSource(t2cDataSource)
				.properties(properties)
				.packages("com.example.minikube.t2c.entity")
				.persistenceUnit("t2c")
				.build();
	}
	
	@Bean(name = "t2cTransactionManager")
	public PlatformTransactionManager t2cTransactionManager(@Qualifier("t2cEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
}
