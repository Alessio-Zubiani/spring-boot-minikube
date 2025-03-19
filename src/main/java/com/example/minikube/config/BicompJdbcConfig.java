package com.example.minikube.config;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import com.example.minikube.properties.BicompConfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
		entityManagerFactoryRef = "bicompEntityManager",
        transactionManagerRef = "bicompTransactionManager", 
        basePackages = {
                "com.example.minikube.repository"
        })
@RequiredArgsConstructor
public class BicompJdbcConfig {
	
	private final BicompConfig config;
	
	
	@Bean(name = "bicompDataSource")
	@Primary
	public DataSource bicompDataSource() {
		
		log.info("Connecting to schema: [{}]", this.config.getDatasource().getUsername());
		
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(this.config.getHibernate().getDialect());
        dataSourceBuilder.url(this.config.getDatasource().getUrl());
        dataSourceBuilder.username(this.config.getDatasource().getUsername());
        dataSourceBuilder.password(this.config.getDatasource().getPassword());
        
        return dataSourceBuilder.build();
	}

	@Bean(name = "bicompEntityManager")
	@Primary
	public LocalContainerEntityManagerFactoryBean bicompEntityManager(EntityManagerFactoryBuilder builder, @Qualifier("bicompDataSource") DataSource bicompDataSource) {
		
		Map<String, String> properties = new HashMap<>();
		properties.put("hibernate.dialect", this.config.getHibernate().getDialect());
		properties.put("hibernate.show_sql", this.config.getHibernate().getShowSql());
		properties.put("hibernate.format_sql", this.config.getHibernate().getFormatSql());
		
		return builder
				.dataSource(bicompDataSource)
				.properties(properties)
				.packages("com.example.minikube.entity")
				.persistenceUnit("bicomp")
				.build();
	}
	
	@Bean(name = "bicompTransactionManager")
	@Primary
	public PlatformTransactionManager bicompTransactionManager(@Qualifier("bicompEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
}
