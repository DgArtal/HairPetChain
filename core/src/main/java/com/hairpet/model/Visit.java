package com.hairpet.model;

import java.util.Date;

public class Visit {

	private Integer id;
	private Date dateTime;
	private Integer idHaidresser;
	private Integer idPet;

	public Visit() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return dateTime;
	}

	public void setDate(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getIdHaidresser() {
		return idHaidresser;
	}

	public void setIdHairdresser(Integer idHaidresser) {
		this.idHaidresser = idHaidresser;
	}

	public Integer getIdPet() {
		return idPet;
	}

	public void setIdPet(Integer idPet) {
		this.idPet = idPet;
	}

}
