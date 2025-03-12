package com.example.minio.properties;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Component
public class Access {
	
	private String name;
	private String secret;

}
