package com.hairpet.model;

import java.util.ArrayList;

public class Inventory {

	private Integer id;
	private String name;
	private String articleCode;
	private Integer quantity;
	private Integer idHairdresser;

	public Inventory() {
		super();
	}

	public ArrayList<String[]> convertObjectToArrayString() {
		ArrayList<String[]> inventoryString = new ArrayList<>();
		inventoryString.add(new String[] { "id", toString().valueOf(id) });
		inventoryString.add(new String[] { "name", name });
		inventoryString.add(new String[] { "articleCode", articleCode });
		inventoryString.add(new String[] { "quantity", toString().valueOf(quantity) });
		inventoryString.add(new String[] { "idHairdresser", toString().valueOf(idHairdresser) });
		return inventoryString;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArticleCode() {
		return articleCode;
	}

	public void setArticleCode(String articleCode) {
		this.articleCode = articleCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getIdHairdresser() {
		return idHairdresser;
	}

	public void setIdHairdresser(Integer idHairdresser) {
		this.idHairdresser = idHairdresser;
	}

}
