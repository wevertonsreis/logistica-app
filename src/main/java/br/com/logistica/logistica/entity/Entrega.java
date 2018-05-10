package br.com.logistica.logistica.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Entrega extends GenericEntity {

	@ManyToOne
	private Veiculo veiculo;
	
	@ManyToOne
	private Pedido pedido;
	
	@Enumerated(EnumType.STRING)
	private SituacaoEntrega situacao;

	@ManyToMany
	@JoinTable(name = "entrega_localizacao", 
		joinColumns = { @JoinColumn(name = "entrega_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "localizacao_id") })
	private List<Localizacao> localizacoes;
	
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public SituacaoEntrega getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoEntrega situacao) {
		this.situacao = situacao;
	}

	public List<Localizacao> getLocalizacoes() {
		return localizacoes;
	}

	public void setLocalizacoes(List<Localizacao> localizacoes) {
		this.localizacoes = localizacoes;
	}

}
