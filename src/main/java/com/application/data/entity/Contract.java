package com.application.data.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contract")
public class Contract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contract_id",columnDefinition = "serial")
    private Long id; 

	@Column(name = "room_id")
	private Integer room_id;
	
	private  java.sql.Date  start_date  ;
	private  java.sql.Date end_date ;
	private  Double  deposit_usd ;
	private  Integer  contract_status_id ;
}
