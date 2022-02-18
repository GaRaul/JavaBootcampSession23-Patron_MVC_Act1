package com.MVCAct1.T22Act1.model.dto;

public class Client {
	
	//Atributos
	private int id;
	private int idSelected;
	private String name;
	private String surname;
	private String address;
	private String dni;
	private String localDate;
	
	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getLocalDate() {
		return localDate;
	}
	public void setLocalDate(String localDate) {
		this.localDate = localDate;
	}
	public void setIdSelected(int idSelected) {
		this.idSelected = idSelected;
	}
	
	public int getIdSelected() {
		return idSelected;
	}
}
