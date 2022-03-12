package com.my.customer;

import com.my.customer.dao.CustomerDAOList;
import com.my.customer.vo.Customer;

public class CustomerManager2 {
	public static void main(String[] args) {
		CustomerDAOList dao;
		dao = new CustomerDAOList(); //최대5명이 저장될 저장소로 초기화
		
		java.util.Scanner sc;
		sc = new java.util.Scanner(System.in);
		String readValue;
		while(true) {
			System.out.println("작업구분: 1-추가, 2-저장소, 3-전체조회, 4-아이디로 검색, 5-이름으로 검색, 6- 수정, 7 - 삭제,  9-종료");
			System.out.print("작업을 선택하세요:");
			readValue = sc.nextLine();		
			switch(readValue) {
			case "1":
				System.out.println(">>고객 추가<<");
				System.out.print("아이디:");
				String id = sc.nextLine();
				System.out.print("비밀번호:");
				String pwd = sc.nextLine();
				System.out.print("이름:");
				String name = sc.nextLine();
				System.out.print("주소:");
				String address = sc.nextLine();
			
				Customer c1 = new Customer(id, pwd, name, address);
				dao.add(c1);
				break;
			case "2":
				System.out.println(">>저장소 정보<<");
				dao.printInfo();
				break;
			case "3":
				System.out.println(">>고객 전체조회<<");
				Customer[]all = dao.findAll();
				for(Customer c: all) {
					c.printInfo();
				}
				break;
			case "4":
				System.out.println(">>아이디로 검색<<");
				System.out.print("아이디:");
				id = sc.nextLine();
				Customer c = dao.findById(id);
				if(c == null) {
					System.out.println(id+"고객은 존재하지 않습니다");
				}else {
					c.printInfo();
				}
				break;
			case "5":
				System.out.println(">>이름으로 검색<<");
				System.out.print("단어:");
				String word = sc.nextLine();
				Customer[] cArr = dao.findByName(word);
				if(cArr == null) {
					System.out.println("단어[" + word+"]를 이름에 포함한 고객은 존재하지 않습니다");
				}else {
					for(Customer c2: cArr) {
						c2.printInfo();
					}
				}
				break;
			case "6":
				System.out.println(">>고객 수정<<");
				System.out.print("아이디:");
				id = sc.nextLine();
				//조회
				Customer c6 = dao.findById(id);
				if(c6 == null) {
					System.out.println(id+"고객은 존재하지 않습니다");
				}else {
					c6.printInfo();
					System.out.println("변경안하려면 enter를 입력하고, 변경하려면 값을 입력하시오");
					System.out.print("비밀번호[" + c6.getPwd() +"]:");
					String c6Pwd = sc.nextLine();
					//System.out.println("입력된 비번값:" + c6Pwd);
					System.out.print("이름[" + c6.getName() +"]:");
					String c6Name = sc.nextLine();
					System.out.print("주소[" + c6.getAddress() +"]:");
					String c6Address = sc.nextLine();	
					Customer c6Modify = new Customer(id, c6Pwd, c6Name, c6Address);
					dao.modify(c6Modify);
				}
				break;
			case "7":
				System.out.println(">>고객 삭제<<");
				System.out.print("아이디:");
				id= sc.nextLine();
				dao.remove(id);
				break;
			
			case "9":
				System.exit(0);
				break;
			}

		}
	}
}
		
