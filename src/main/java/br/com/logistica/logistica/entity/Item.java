package br.com.logistica.logistica.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class Item extends GenericEntity {

	private String nome;
	private BigDecimal valor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}