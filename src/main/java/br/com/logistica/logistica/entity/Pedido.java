package br.com.logistica.logistica.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido extends GenericEntity {
	
	@ManyToOne
	private Cliente cliente;
	@OneToMany
	@JoinColumn(name = "pedido_id", referencedColumnName = "id")
	private List<Item> itens;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
}