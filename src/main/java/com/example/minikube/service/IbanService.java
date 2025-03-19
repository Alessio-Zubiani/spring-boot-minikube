package com.example.minikube.service;

import java.util.List;

import com.example.minikube.t2c.entity.EurCommonIbanBeneficiario;

public interface IbanService {
	
	List<EurCommonIbanBeneficiario> findByCodiceControparte(String codiceControparte);

}
