package br.com.logistica.logistica.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Veiculo extends GenericEntity<Long> {
	
	@Getter @Setter
	private String placa;
	
	@ManyToOne
	@Getter @Setter
	private Motorista motorista;
	
	@ManyToMany
	@JoinTable(name = "vaiculo_localizacao", 
		joinColumns = { @JoinColumn(name = "veiculo_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "localizacao_id") })
	@Getter @Setter
	private List<Localizacao> localizacoes;
		
}