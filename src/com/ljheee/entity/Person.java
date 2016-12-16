package com.ljheee.entity;

import java.io.Serializable;
/**
 * JOPO实体类
 */
public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5197004772200969575L;
	
	private String name;
	private String pass;
	private String address;
	
	public Person(String name, String pass, String address) {
		super();
		this.name = name;
		this.pass = pass;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
