package br.com.logistica.logistica.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EqualsAndHashCode
public class GenericEntity<T> {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter 
	private T id;
	
}
