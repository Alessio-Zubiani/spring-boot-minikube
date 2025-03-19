package com.example.minikube.properties;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Component
public class Datasource {
	
	private String url;
	private String username;
	private String password;
	private String driver;

}
