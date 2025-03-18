package com.example.minikube.repository;

import java.math.BigDecimal;

import com.example.minikube.entity.Timer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TimerRepository extends JpaRepository<Timer, BigDecimal> {

}
