package com.example.minikube.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor

@Component
@PropertySource(value = "classpath:application.yml", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "slt")
public class SltHibernateConfig extends HibernateBaseEntity {
	
	@Builder
	public SltHibernateConfig(Datasource datasource, Hibernate hibernate) {
		super(datasource, hibernate);
	}

}
