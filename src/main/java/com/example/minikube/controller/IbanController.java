package com.example.minikube.controller;

import java.util.List;

import com.example.minikube.service.IbanService;
import com.example.minikube.t2c.entity.EurCommonIbanBeneficiario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@RestController
@RequestMapping("/api/v1/ibans")
@RequiredArgsConstructor
public class IbanController {
	
	private final IbanService ibanService;
	
	
	@GetMapping("{codiceControparte}")
	public ResponseEntity<List<EurCommonIbanBeneficiario>> getIbansByCodiceControparte(@PathVariable("id") String codiceControparte) {
		
		log.info("Called [getIbansByCodiceControparte] Rest API");
		List<EurCommonIbanBeneficiario> ibans = this.ibanService.findByCodiceControparte(codiceControparte);
		
		return ResponseEntity.ok().body(ibans);
	}

}
