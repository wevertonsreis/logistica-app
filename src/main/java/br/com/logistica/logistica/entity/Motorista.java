package br.com.logistica.logistica.entity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Motorista extends GenericEntity<Long> {
	
	@Getter @Setter
	private String nome;
	
}