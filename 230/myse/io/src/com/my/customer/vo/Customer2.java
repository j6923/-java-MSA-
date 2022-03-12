package com.my.customer.vo;



public class Customer2  {
	
		private String id;  //고객 객체의 고유 특성 //외부에 노출되지 않도록 
		private String pwd;
		private String name;
		private String address;
		
		
		public Customer2(){}
		
		/**
		 * 고객정보를 초기화한다
		 * @param id 아이디
		 * @param pwd 비밀번호
		 * @param name 이름
		 * @param address 주소
		 */
		public Customer2(String id, String pwd, String name, String address){  //사용해서 접근할 수 있도록 public생성자로 만듦 
			this.id = id;
			this.pwd = pwd;
			this.name = name;
			this.address = address;
		}
		
		/**
		 * 고객정보를 출력한다
		 * 출력예는 아이디:1, 비밀번호:2, 이름:3, 주소:4 이다 
		 */
		public void printInfo() {
			System.out.println("아이디:" + id +", 비밀번호:" + pwd + ",이름:" + name + ",주소:" + address);
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







