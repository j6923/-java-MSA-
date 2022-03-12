/**
 * 고객 객체용 클래스이다. 
 * 고객정보(아이디, 이름, 비밀번호, 주소 )
 * @author KOSTA
 * 
 */
class Customer{
	String id;
	String pwd;
	String name;
	String address;
	
//	Customer(){}
	/**
	 * 고객정보를 초기화한다. 
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
	 * 고객 정보를 출력한다. 
	 * 출력 예로 아이디:1, 비밀번호:2, 이름:3, 주소:4 이다 
	 */
	void printInfo() {
		System.out.println("아이디:" + id + ", 비밀번호: " + pwd + ",이름:" + name + ",주소: " + address);
	}
	
	
	
}

/**
 * 고객 객체를 저장소에 추가, 조회, 수정, 삭제하는 클래스이다
 * @author KOSTA
 *
 */
class CustomerDAO{//배열이 되게 함. 
	int count; //저장된 고객수
	
	Customer[] customers;   //고객저장소   //고객객체가 저장될 공간 
	
	CustomerDAO(){
		customers = new Customer[5];
	}
	CustomerDAO(int size){
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
//		Customer firstC = customers[0];
//		firstC.printInfo();
	}
	void add(Customer customer){//Customer 타입의 매개변수 
		if(count >= customers.length) {
			System.out.println("저장소가 꽉찼습니다.");
		}else {
		customers[count] = customer;   //고정된 인덱스 값을 변경해줘야 함. 1씩 증가되야 함. 
		count++; //Good Code 
		}  //제공자쪽 코드에서 큭정범위에서 벗어날 경우 프로그램이 죽으니까 필터링 해줘야 함. 
//		customers[count++] = customer;   //count++을 다른 코드와 같이 쓰는 건 좋은 코드가 아니여서 이 코드는 좋은 코드는 아니다.   //Bad Code 
	}
	
	
	
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
			case "9":
				System.exit(0);
				break;
			}
		}
	}
		
		
//		do {
//		//입력받음
//			System.out.print("아이디:");
//			String id = sc.nextLine();
//			System.out.println("비밀번호:");
//			String pwd = sc.nextLine();
//			
//			System.out.print("이름:");
//			String name = sc.nextLine();
//			System.out.println("주소:");
//			String address = sc.nextLine();  //입력된 값 저장함. 
//			
//			Customer c1 = new Customer(id, pwd, name, address);
//			dao.add(c1);
//			
//			//물어봄 
//			System.out.print("종료하려면 quit을 입력하세요. 계속하려면 그외의 값을 입력하세요");
//			readValue = sc.nextLine(); //읽어옴. 
//		}while(! readValue.equals("quit"));
		
	
				
//		Customer c1 = new Customer("id1", "p1", "n1", "a1"); 
//		dao.add(c1); //고객저장소의 0번 index에 c1객체 참조시킨다. 
//		Customer c2 = new Customer("id2", "p2", "n2", "a2");
//		dao.add(c2); //고객저장소의 1번 index에 c2객체 참조시킨다. 
//		
//		Customer c3 = new Customer("id3", "p3", "n3","a3");
//		dao.add(c3);
//		
//		dao.add(new Customer("id4", "p4", "n4","a4"));
//		dao.add(new Customer("id5", "p5", "n5","a5"));//여기까지는 문제 없음. 카운트 5가 된느 시점에는 coumers 의 6번쨰는 공간이 없어 out of excption 이 일어남. 
//		dao.add(new Customer("id6", "p6", "n6","a6"));
//		dao.add(new Customer("id7", "p7", "n7","a7"));
//		
		dao.printInfo(); //저장소의 저장된 고객 정보를 출력 
//		dao = new CustomerDAO(10); //최대 10명이 저장될 저장소로 초기화 
		

	}

}
