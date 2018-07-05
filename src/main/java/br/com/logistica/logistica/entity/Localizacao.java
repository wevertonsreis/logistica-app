package br.com.logistica.logistica.entity;

import java.util.Date;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Localizacao extends GenericEntity<Long> {

	@Getter @Setter
	private Double latitude;
	
	@Getter @Setter
	private Double longitude;
	
	@Getter @Setter
	private Date data;

}
