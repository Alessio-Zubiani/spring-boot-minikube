package com.example.minio.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.example.minio.properties.Minio;
import com.example.minio.service.FileService;

import org.springframework.stereotype.Service;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

	private final Minio minio;
	
	private final MinioClient client;

	
	@Override
	public void uploadFile() {
		
		try {
            boolean found = this.client.bucketExists(BucketExistsArgs.builder().bucket(this.minio.getBucket().getName()).build());
            if(!found) {
                this.client.makeBucket(MakeBucketArgs.builder().bucket(this.minio.getBucket().getName()).build());
            }
            
            File file = new File("C:\\Users\\4631.POPSO\\Desktop\\prova_minio.txt");
            InputStream inputStream = new FileInputStream(file);
            
            this.client.putObject(PutObjectArgs.builder()
            		.bucket(this.minio.getBucket().getName())
            		.object(file.getName())
            		.stream(inputStream, inputStream.available(), -1)
                    .build());
        } catch (Exception e) {
            throw new RuntimeException("Error occurred: " + e.getMessage());
        }
	}

	@Override
	public void downloadFile() {
	}
	
}
