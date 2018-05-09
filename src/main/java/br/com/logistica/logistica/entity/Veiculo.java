package br.com.logistica.logistica.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Veiculo extends GenericEntity {
	
	private String placa;
	@ManyToOne
	private Motorista motorista;
	@ManyToMany
	@JoinTable(name = "vaiculo_localizacao", 
		joinColumns = { @JoinColumn(name = "veiculo_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "localizacao_id") })
	private List<Localizacao> localizacoes;
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public List<Localizacao> getLocalizacoes() {
		return localizacoes;
	}

	public void setLocalizacoes(List<Localizacao> localizacoes) {
		this.localizacoes = localizacoes;
	}

}