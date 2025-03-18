package com.example.minikube.service;

import java.util.List;

import com.example.minikube.entity.Timer;

public interface TimerService {
	
	List<Timer> findTimers();

}
