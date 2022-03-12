/**
 * 고객객체용 클래스이다
 * 고객정보(아이디, 비밀번호, 이름, 주소)
 * @author KOSTA
 * 
 */
class Customer{
	String id;
	String pwd;
	String name;
	String address;
	Customer(){}
	
	/**
	 * 고객정보를 초기화한다
	 * @param id 아이디
	 * @param pwd 비밀번호
	 * @param name 이름
	 * @param address 주소
	 */
	Customer(String id, String pwd, String name, String address){
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.address = address;
	}
	
	/**
	 * 고객정보를 출력한다
	 * 출력예는 아이디:1, 비밀번호:2, 이름:3, 주소:4 이다 
	 */
	void printInfo() {
		System.out.println("아이디:" + id +", 비밀번호:" + pwd + ",이름:" + name + ",주소:" + address);
	}
}

/**
 * 고객객체를 저장소에 추가, 조회, 수정, 삭제하는 클래스이다
 * @author KOSTA
 *
 */
class CustomerDAO{
	Customer[] customers; //고객저장소
	int count; //저장된 고객수
	CustomerDAO(){
		customers = new Customer[5];
	}
	CustomerDAO(int size) {
		customers = new Customer[size];
	}
	void printInfo() {
		System.out.println("고객저장소의 크기" + customers.length);
		System.out.println("저장된 고객수" + count);
		
		for(int i=0; i<count; i++) {
			Customer c = customers[i];
			System.out.print("[" + i + "]=");
			c.printInfo();
		}
	}
	
	void add(Customer customer){
		if(count >= customers.length) {
			System.out.println("저장소가 꽉찼습니다");
		}else {
			customers[count] = customer;
			count++; //Good Code
			System.out.println("고객추가 성공");
		}
//		customers[count++] = customer; //Bad Code
	}
	
	Customer[] findAll(){    //Customer[]all = dao.findAll();로 사용한다
		//return customers;
		Customer[]all = new Customer[count];
//		for(int i=0; i<count; i++) {
//			all[i] = customers[i];
//		}
		System.arraycopy(customers, 0, all, 0, count);
		return all;
	}
	//TODO 완성하세요
}


public class CustomerManager {
	public static void main(String[] args) {
		CustomerDAO dao;
		dao = new CustomerDAO(); //최대5명이 저장될 저장소로 초기화
		
		java.util.Scanner sc;
		sc = new java.util.Scanner(System.in);
		String readValue;
		while(true) {
			System.out.println("작업구분: 1-추가, 2-저장소, 3-전체조회, 4-아이디로 검색, 9-종료");
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

			case "9":
				System.exit(0);
				break;
			}
		}
	}
}