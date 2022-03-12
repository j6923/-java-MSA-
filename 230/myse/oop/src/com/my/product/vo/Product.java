package com.my.product.vo;

import java.util.Objects;

public class Product {

	
		private String prodNO;
		private String prodName;
		private int prodPrice;


	

	public Product(String prodNO, String prodName, int prodPrice) {
			super();
			this.prodNO = prodNO;
			this.prodName = prodName;
			this.prodPrice = prodPrice;
		}
	

	
	
	
	


	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}



//	public Product() {
//		// TODO Auto-generated constructor stub
//	}








	/**
	 * 주석
	 * comment : 컴파일, 실행에 영향없음.  
	 * annotation : @ 컴파일시나 실행시에 영향있음 
	 * 				ex> @override - 메서드가 오버라이딩되지 않은 경우 컴파일 오류가 발생한다. 
	 */
	@Override  //밑의 메서드는 오버라이딩할 메서드라는 것을 알리는 애, 오버라이딩 안 했을 떄 오버라이드를 안 했을 떄 컴파일 에러를 발생시켜줌.
	public String toString() {//어노
		return "Product [prodNO=" + prodNO + ", prodName=" + prodName + ", prodPrice=" + prodPrice + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(prodNO);
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
		return Objects.equals(prodNO, other.prodNO);
	}



	public String getProdNO() {
		return prodNO;
	}




	public void setProdNO(String prodNO) {
		this.prodNO = prodNO;
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
