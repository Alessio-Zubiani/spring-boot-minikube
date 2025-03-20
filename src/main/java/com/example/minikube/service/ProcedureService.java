package com.example.minikube.service;

import com.example.minikube.slt.entity.Rstbproc;

public interface ProcedureService {
	
	Rstbproc findByTipoVoce(String tipoVoce);

}
