package com.example.minikube.service.impl;

import java.util.List;

import com.example.minikube.entity.Timer;
import com.example.minikube.repository.TimerRepository;
import com.example.minikube.service.TimerService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@Service
@RequiredArgsConstructor
public class TimerServiceImpl implements TimerService {
	
	private final TimerRepository timerRepository;
	

	@Override
	public List<Timer> findTimers() {
		
		log.info("Find all timers");
		
		return this.timerRepository.findAll();
	}

}
