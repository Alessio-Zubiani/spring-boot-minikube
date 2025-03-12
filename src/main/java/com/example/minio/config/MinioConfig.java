package com.example.minio.config;

import com.example.minio.properties.Minio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MinioConfig {
	
	private final Minio minio;

	@Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(this.minio.getUrl())
                .credentials(this.minio.getAccess().getName(), this.minio.getAccess().getSecret())
                .build();
    }
	
}
