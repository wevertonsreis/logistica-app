package br.com.logistica.logistica.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Localizacao extends GenericEntity {

	private Double latitude;
	private Double longitude;
	private Date data;

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
