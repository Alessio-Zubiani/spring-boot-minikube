package com.example.minikube.service.impl;

import java.util.Optional;

import com.example.minikube.exception.BicompException;
import com.example.minikube.service.ProcedureService;
import com.example.minikube.slt.entity.Rstbproc;
import com.example.minikube.slt.repository.RstbprocRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProcedureServiceImpl implements ProcedureService {
	
	private final RstbprocRepository rstbprocRepository;
	

	@Override
	public Rstbproc findByTipoVoce(String tipoVoce) {
		
		Optional<Rstbproc> o = this.rstbprocRepository.findByProcTipoVoce(tipoVoce);
		if(o.isEmpty()) {
			throw new BicompException("TipoVoce [".concat(tipoVoce).concat("] not present"));
		}
		
		return o.get();
	}

}
