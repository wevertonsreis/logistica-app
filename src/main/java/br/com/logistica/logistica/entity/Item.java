package br.com.logistica.logistica.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Item extends GenericEntity<Long> {
	
	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private BigDecimal valor;

}