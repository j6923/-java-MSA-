package com.my.product.vo;

import java.util.Objects;
//엔터티할 역할할 클래스 
//dao도 인터페이스와 오라클 쓸 게 아니라 repostory로 바꾸기 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="product")
@Table(name="PRODUCT")
public class Product {
	
	@Id
	@Column(name = "prod_no")
	private String prodNo;
	
	@Column(name="prod_name")
	private String prodName = "상품이름";
	
	@Column(name="prod_price")
	private int prodPrice;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String prodNo, String prodName) {
		super();
		this.prodNo = prodNo;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
	}
	
	public Product(String string, String string2, int i) {
		// TODO Auto-generated constructor stub
	}
	/*
	 * 주석
	 * comment : 컴파일,실행에 영향없음
	 * annotation : @ 컴파일시나 실행시에 영향있음
	 *            ex)@Override - 메서드가 오버라이딩되지 않은경우 컴파일오류가 발생한다
	 */
	@Override
	public String toString() {
		return "Product [prodNo=" + prodNo + ", prodName=" + prodName + ", prodPrice=" + prodPrice + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(prodNo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(prodNo, other.prodNo);
	}
	public String getProdNo() {
		return prodNo;
	}
	
	//@Required
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	
	
}
