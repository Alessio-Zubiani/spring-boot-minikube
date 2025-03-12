package com.example.minio.controller;

import com.example.minio.service.FileService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
public class FileController {
	
	private final FileService fileService;
	
	
	@GetMapping
	public ResponseEntity<String> helloWorld() {
		
		return ResponseEntity.ok().body("Hello world. First Kubernetes project");
	}
	
	@PostMapping
	public ResponseEntity<String> uploadFile() {
		
		this.fileService.uploadFile();
		return ResponseEntity.ok().build();
	}

}
