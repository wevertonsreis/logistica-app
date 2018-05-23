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
	private List<PedidoItem> itens;
	
	public List<PedidoItem> getItens() {
		return itens;
	}

	public void setItens(List<PedidoItem> itens) {
		this.itens = itens;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
}