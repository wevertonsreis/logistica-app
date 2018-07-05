package br.com.logistica.logistica.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Cliente extends GenericEntity<Long> {
	
	@NotNull
	@Length(min = 2, max = 50, message = "O tamanho do nome deve ser entre {min} e {max} caracteres")
	@Getter @Setter
	private String nome;
	
	@NotNull
	@Length(min = 2, max = 300, message = "O tamanho do endereço deve ser entre {min} e {max} caracteres")
	@Getter @Setter
	private String endereco;
	
	@OneToMany(mappedBy = "cliente")
	@Getter @Setter
	private List<Pedido> pedidos;

}
