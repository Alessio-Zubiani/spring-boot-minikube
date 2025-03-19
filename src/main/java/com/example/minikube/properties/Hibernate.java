package com.example.minikube.properties;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Component
public class Hibernate {
	
	private String dialect;
    private String showSql;
    private String formatSql;

}
