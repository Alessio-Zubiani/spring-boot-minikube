package com.example.minikube.slt.repository;

import java.util.Optional;

import com.example.minikube.slt.entity.Rstbproc;
import com.example.minikube.slt.entity.RstbprocPK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RstbprocRepository extends JpaRepository<Rstbproc, RstbprocPK> {
	
	@Query("SELECT r FROM Rstbproc r WHERE r.id.procTipoVoce = ?1")
	Optional<Rstbproc> findByProcTipoVoce(String procTipoVoce);

}
