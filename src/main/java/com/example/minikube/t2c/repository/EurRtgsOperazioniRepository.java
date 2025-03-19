package com.example.minikube.t2c.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.example.minikube.t2c.entity.EurRtgsOperazioni;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EurRtgsOperazioniRepository extends JpaRepository<EurRtgsOperazioni, BigDecimal> {
	
	@Query("SELECT e FROM EurRtgsOperazioni e WHERE e.dataRegolamento = ?1 AND e.codiceFamiglia = ?2 ORDER BY e.timbroRegolamento DESC")
	List<EurRtgsOperazioni> findLastCompensazioneNazionaleSettlement(Date dataRegolamento, String codiceFamiglia, Pageable paging);
	
}
