package com.example.minikube.controller;

import com.example.minikube.service.ProcedureService;
import com.example.minikube.slt.entity.Rstbproc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@RestController
@RequestMapping("/api/v1/procedures")
@RequiredArgsConstructor
public class ProcedureController {
	
	private final ProcedureService procedureService;
	
	
	@GetMapping("{tipoVoce}")
	public ResponseEntity<Rstbproc> getProcedureByTipoVoce(@PathVariable("tipoVoce") String tipoVoce) {
		
		log.info("Called [getProcedureByTipoVoce] Rest API");
		Rstbproc rstbproc = this.procedureService.findByTipoVoce(tipoVoce);
		
		return ResponseEntity.ok().body(rstbproc);
	}

}
