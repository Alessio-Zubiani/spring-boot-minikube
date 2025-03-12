package com.example.minio.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Component
@ConfigurationProperties(prefix = "minio")
public class Minio {
	
	private String url;
	private Access access;
	private Bucket bucket;

}
