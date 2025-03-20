package com.example.minikube.config;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import com.example.minikube.properties.SltHibernateConfig;

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
		entityManagerFactoryRef = "sltEntityManager",
        transactionManagerRef = "sltTransactionManager",
        basePackages = {
    		"com.example.minikube.slt.repository"
        })
@RequiredArgsConstructor
public class SltJdbcConfig {
	
	private final SltHibernateConfig config;
	
	
	@Bean(name = "sltDataSource")
	public DataSource sltDataSource() {
		
		log.info("Connecting to schema: [{}]", this.config.getDatasource().getUsername());
		
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(this.config.getDatasource().getDriver());
        dataSourceBuilder.url(this.config.getDatasource().getUrl());
        dataSourceBuilder.username(this.config.getDatasource().getUsername());
        dataSourceBuilder.password(this.config.getDatasource().getPassword());
        
        return dataSourceBuilder.build();
	}

	@Bean(name = "sltEntityManager")
	public LocalContainerEntityManagerFactoryBean sltEntityManager(EntityManagerFactoryBuilder builder, @Qualifier("sltDataSource") DataSource sltDataSource) {
		
		Map<String, String> properties = new HashMap<>();
		properties.put("hibernate.show_sql", this.config.getHibernate().getShowSql());
		properties.put("hibernate.format_sql", this.config.getHibernate().getFormatSql());
		
		return builder
				.dataSource(sltDataSource)
				.properties(properties)
				.packages("com.example.minikube.slt.entity")
				.persistenceUnit("slt")
				.build();
	}
	
	@Bean(name = "sltTransactionManager")
	public PlatformTransactionManager sltTransactionManager(@Qualifier("sltEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
}
