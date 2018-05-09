package br.com.logistica.logistica.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Cliente extends GenericEntity {
	
	@NotNull
	@Length(min = 2, max = 50, message = "O tamanho do nome deve ser entre {min} e {max} caracteres")
	private String nome;
	
	@NotNull
	@Length(min = 2, max = 300, message = "O tamanho do endereço deve ser entre {min} e {max} caracteres")
	private String endereco;
	
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
}
