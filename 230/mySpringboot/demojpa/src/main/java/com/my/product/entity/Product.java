package com.my.product.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity(name="product")
@Table(name="jpaproduct")  //이 테이블 사용할 것이다. 
//@DynamicUpdate
public class Product{
	@Id
	@Column(name="prod_no", length = 10 ) //spring.jpa.hibernate.ddl-auto=create 
	private String prod_no;               //length = 10,nullable = false, @ColumnDefault(value="1")
	
	@Column(name="prod_name", nullable = false)
	private String prod_name;
	
	@Column(name="prod_price")
	@ColumnDefault(value="1") //컬럼에 기본값이 설정 default값 줌 
	private int prod_price;
	
	@JsonFormat(pattern = "yy/MM/dd", timezone = "Asia/Seoul")// 나라마다 포맷이 달라서 지정해줌.
	@CreationTimestamp  //행이 insert될 때 insert시점의 시간값이 자동 대입되도록 함. 
	private java.util.Date prod_mf_dt;  //나라마다 사용하는 포멧이 다름. 
	
	@Transient
	private String prod_detail;

	public Product(){}
	public Product(String prod_no, String prod_name, int prod_price){
		this(prod_no, prod_name, prod_price, null, null);
	}                 
	public Product(String prod_no, String prod_name, int prod_price, 
			java.util.Date prod_mf_dt, String prod_detail){
		this.prod_no = prod_no;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_mf_dt = prod_mf_dt;
		this.prod_detail = prod_detail;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prod_no == null) ? 0 : prod_no.hashCode());
		return result;
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
		if (prod_no == null) {
			if (other.prod_no != null)
				return false;
		} else if (!prod_no.equals(other.prod_no))
			return false;
		return true; //현재객체의 상품번호(prod_no)와 매개변수객체의 상품번호가  같은경우 true반환
	}
	public String getProd_no() {
		return prod_no;
	}


	public void setProd_no(String prod_no) {
		this.prod_no = prod_no;
	}


	public String getProd_name() {
		return prod_name;
	}


	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}


	public int getProd_price() {
		return prod_price;
	}


	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}


	public Date getProd_mf_dt() {
		return prod_mf_dt;
	}


	public void setProd_mf_dt(Date prod_mf_dt) {
		this.prod_mf_dt = prod_mf_dt;
	}


	public String getProd_detail() {
		return prod_detail;
	}


	public void setProd_detail(String prod_detail) {
		this.prod_detail = prod_detail;
	}
	@Override
	public String toString() {
		return "Product [prod_no=" + prod_no + ", prod_name=" + prod_name + ", prod_price=" + prod_price
				+ ", prod_mf_dt=" + prod_mf_dt + ", prod_detail=" + prod_detail + "]";
	}

}


