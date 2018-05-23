package br.com.logistica.logistica.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PedidoItem extends GenericEntity {

	@ManyToOne
	private Pedido pedido;
	@ManyToOne
	private Item item;

	private Integer quantidade;
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
