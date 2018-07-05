package br.com.logistica.logistica.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Entrega extends GenericEntity<Long> {

	@ManyToOne
	@Getter @Setter
	private Veiculo veiculo;
	
	@ManyToOne
	@Getter @Setter
	private Pedido pedido;
	
	@Enumerated(EnumType.STRING)
	@Getter @Setter
	private SituacaoEntrega situacao;

	@ManyToMany
	@JoinTable(name = "entrega_localizacao", 
		joinColumns = { @JoinColumn(name = "entrega_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "localizacao_id") })
	@Getter @Setter
	private List<Localizacao> localizacoes;

}
