package com.example.minikube.service.impl;

import java.util.List;

import com.example.minikube.service.IbanService;
import com.example.minikube.t2c.entity.EurCommonIbanBeneficiario;
import com.example.minikube.t2c.repository.EurCommonIbanBeneficiarioRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IbanServiceImpl implements IbanService {

	private final EurCommonIbanBeneficiarioRepository eurCommonIbanBeneficiarioRepository;

	@Override
	public List<EurCommonIbanBeneficiario> findByCodiceControparte(String codiceControparte) {
		
		return this.eurCommonIbanBeneficiarioRepository.findByCodiceControparte(codiceControparte);
	}
	
}
