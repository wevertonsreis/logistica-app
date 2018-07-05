package br.com.logistica.logistica.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Pedido extends GenericEntity<Long> {
	
	@ManyToOne
	@Getter @Setter
	private Cliente cliente;
	
	@OneToMany
	@JoinColumn(name = "pedido_id", referencedColumnName = "id")	
	@Getter @Setter
	private List<PedidoItem> itens;
	
}