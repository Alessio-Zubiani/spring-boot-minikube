package com.example.minikube.t2c.repository;

import java.math.BigDecimal;
import java.util.List;

import com.example.minikube.t2c.entity.EurCommonIbanBeneficiario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EurCommonIbanBeneficiarioRepository extends JpaRepository<EurCommonIbanBeneficiario, BigDecimal> {
	
	List<EurCommonIbanBeneficiario> findByCodiceControparte(String codiceControparte);
	
}
