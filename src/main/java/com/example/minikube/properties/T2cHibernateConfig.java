package com.example.minikube.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Component
@PropertySource(value = "classpath:application.yaml", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "t2c")
public class T2cHibernateConfig extends HibernateBaseEntity {
	
	@Builder
	public T2cHibernateConfig(Datasource datasource, Hibernate hibernate) {
		super(datasource, hibernate);
	}

}
