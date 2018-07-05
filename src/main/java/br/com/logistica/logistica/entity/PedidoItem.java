package br.com.logistica.logistica.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class PedidoItem extends GenericEntity<Long> {

	@ManyToOne
	@Getter @Setter
	private Pedido pedido;
	
	@ManyToOne
	@Getter @Setter
	private Item item;
	
	@Getter @Setter
	private Integer quantidade;

}
