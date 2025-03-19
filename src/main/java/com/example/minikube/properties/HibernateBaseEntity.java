package com.example.minikube.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HibernateBaseEntity {
	
	private Datasource datasource;
	private Hibernate hibernate;

}
