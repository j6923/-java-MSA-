package com.example.demo.customer.vo;

import java.io.Serializable;

public class Person implements Serializable{
	protected String name;
	protected String address;
	public Person() {}
	public Person(String name, String address) {
		this.name = name;
		this.address = address;
		
	}
	public void printInfo() {
		System.out.println("이름:" + name + ", 주소: " + address);
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}

	}



