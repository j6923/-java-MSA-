package com.my.customer.vo;

import java.io.Serializable;

public class Customer extends Person {
	
		private String id;  //고객 객체의 고유 특성 //외부에 노출되지 않도록 
		private String pwd;
//		private String name;
//		private String address;
		
		public Customer(){}
		
		/**
		 * 고객정보를 초기화한다
		 * @param id 아이디
		 * @param pwd 비밀번호
		 * @param name 이름
		 * @param address 주소
		 */
		public Customer(String id, String pwd, String name, String address){  //사용해서 접근할 수 있도록 public생성자로 만듦 
			super(name, address);
			this.id = id;
			this.pwd = pwd;
//			this.name = name;
//			this.address = address;
		}
		
		/**
		 * 고객정보를 출력한다
		 * 출력예는 아이디:1, 비밀번호:2, 이름:3, 주소:4 이다 
		 */
		public void printInfo() {
			System.out.println("아이디:" + id +", 비밀번호:" + pwd + "," );
			super.printInfo();
		}
		
		
		/**
		 * 현재고객의 아이디와 매개변수고객개체의 아이디가 같으면 true반환
		 * 그외의 경우는 false반환한다 
		 */
		public boolean equals(Object obj) {
			if(obj instanceof Customer) {
				Customer c = (Customer)obj;
				if(this.id.equals(c.id)) {
					return true;
				}
			}
			return false;
		}


		public void setId(String id) {
			this.id = id;
			
		}
		
		public String getId() {  //비밀번호용, 
			return id;
		}
		
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public String getPwd() {
			return pwd; 
		}
		
	}







