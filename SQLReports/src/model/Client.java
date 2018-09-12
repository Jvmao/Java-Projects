package model;

import java.io.Serializable;

public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Variables
	int id;
	String name;
	String lastName;
	String country;
	String city;
	int tel;
	String mail;
	String code;
	
	//Empty Constructor
	public Client() {}

	//Constructor with Fields
	public Client(int id, String name, String lastName, String country, String city, int tel, String mail,String code) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.country = country;
		this.city = city;
		this.tel = tel;
		this.mail = mail;
		this.code = code;
	}

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", lastName=" + lastName + ", country=" + country + ", city="
				+ city + ", tel=" + tel + ", mail=" + mail + ", code=" + code + "]";
	}

}
