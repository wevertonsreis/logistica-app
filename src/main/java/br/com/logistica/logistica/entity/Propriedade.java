package br.com.logistica.logistica.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Propriedade {

	@Id
	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private String valor;
	
	@Getter @Setter
	private String descricao;
	
	@Getter @Setter
	private String categoria;
	
	@Getter @Setter
	private String subcategoria;

}