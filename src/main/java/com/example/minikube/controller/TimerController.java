package com.example.minikube.controller;

import java.util.List;

import com.example.minikube.entity.Timer;
import com.example.minikube.service.TimerService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@RestController
@RequestMapping("/api/v1/timers")
@RequiredArgsConstructor
public class TimerController {
	
	private final TimerService timerService;
	
	
	@GetMapping
	public ResponseEntity<List<Timer>> getTimers() {
		
		log.info("Called [getTimers] Rest API");
		List<Timer> timers = this.timerService.findTimers();
		
		return ResponseEntity.ok().body(timers);
	}

}
