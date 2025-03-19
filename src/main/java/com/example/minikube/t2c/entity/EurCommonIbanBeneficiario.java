package com.example.minikube.t2c.entity;

import java.io.Serializable;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the EUR_RTGS_OPERAZIONI database table.
 * 
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "EUR_COMMON_IBAN_BENEFICIARIO", schema = "TLM_T2C")
public class EurCommonIbanBeneficiario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PROGRESSIVO")
	private BigDecimal progressivo;
	
	@Column(name = "BIC_DESTINATARIO")
	private String bicDestinatario;

	@Column(name = "BIC_ISTITUTO")
	private String bicIstituto;

	@Column(name = "CANALE")
	private String canale;

	@Column(name = "CODICE_CONTROPARTE")
	private String codiceControparte;

	@Column(name = "CODICE_DIVISA")
	private String codiceDivisa;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_TS")
	private Date creationTs;

	@Column(name = "DESCRIZIONE")
	private String descrizione;

	@Column(name = "FLAG_IBAN_ATTIVO")
	private String flagIbanAttivo;

	@Column(name = "IBAN_BENEFICIARIO")
	private String ibanBeneficiario;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_TS")
	private Date updateTs;

}