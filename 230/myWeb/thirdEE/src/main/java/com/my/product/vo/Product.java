package com.my.product.vo;

import java.util.Objects;

public class Product {
	private String prodNo;
	private String prodName;
	private int prodPrice;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String prodNo, String prodName, int prodPrice) {
		super();
		this.prodNo = prodNo;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
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
