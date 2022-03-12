package com.my.customer.dao;
import java.util.ArrayList;
import java.util.List;

import com.my.customer.vo.Customer;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;


/**
 * 고객객체를 저장소에 추가, 조회, 수정, 삭제하는 클래스이다
 * 각 기능별 예외처리한다.
 * 리스트자료구조형태의 저장소를 사용한다.  
 * @author KOSTA
 * @version 3.0 
 */
public class CustomerDAOList implements CustomerDAOInterface{
	private List<Customer> customers; // 고객저장소 

	

//	public class CustomerDAOList {
	
		;// 고객저장소   //Customer타입만 추가할 수 있도록 제내릭을 추가함. 
//		customers = new ArrayList<>(); //10개의 index가 만들어짐. 
		// 제내릭을 쓰지 않으면 어떤 타입이든 저장할 수 있게 된다. 
		// 특별 고객들만 저장될 곳이다라는 것을 알릭위해서는 제내릭을 사용한다. 
//		private Customer[] customers; //고객저장소  dao패키지와 vo패키지 사용하려면 com.my.customer.vo.Customer라고 해야함. 
//		private int count; //저장된 고객수
//}
		public CustomerDAOList(){
//			customers = new Customer[5];
			customers = new ArrayList<>();  //기본 10개짜리 리스트를 생성하게 됨.   //10개의 index가 만들어짐. 
		}
		public CustomerDAOList(int size) {
//			customers = new Customer[size];
			customers = new ArrayList<>(size);  //size개수의 index가 만들어짐. 
		}
		public void printInfo() { //여기는 오버라이딩 되지 않았다. 
//			System.out.println("고객저장소의 크기" + customers.length); 
			System.out.println("저장된 고객수" + customers.size());  //size는 저장된 요소의 개수를 구할 때 사용함. 
			
//			for(int i=0; i<count; i++) {
//				Customer c = customers[i];
//				System.out.print("[" + i + "]=");
//				c.printInfo();
//			}
			for(Customer c : customers) {   
				Customer o = (Customer)c;
				c.printInfo();
			}
		}
		/**
		 * 저장소에 고객을 추가한다
		 * 단, ID가 중복된 경우에는 "이미 존재하는 아이디입니다"출력하고 저장 안 한다. 
		 * @param customer   추가할 고객 객체 
		 */
//		public void add(Customer customer) throws Exception{
//			//ID중복확인
//			try {
//				for(int i=0; i<count; i++) {
//					if(customers[i].equals(customer)) {
//						//System.out.println("이미 존재하는 아이디입니다");
//						//return;
//						throw new Exception("이미 존재하는 아이디입니다");
//					}
//				}
//				//중복되지 않은 경우
//				customers[count] = customer;
//				count++; //Good Code		
//				//System.out.println("고객추가 성공");	
////				customers[count++] = customer; //Bad Code
//			}catch(ArrayIndexOutOfBoundsException e) {
//				throw new Exception("저장소가 꽉찼습니다");
//			}
//			
//		}
		
		/**
		 * 저장소에 고객을 추가한다
		 * @param customer 추가할 고객객체
		 * @throws AddException  
		 *   ID가 중복된 경우에는 "이미 존재하는 아이디입니다"상세메시지를 갖는 예외가 발생한다.<br>
		 *   저장소가 꽉찬경우에는 ""저장소가 꽉찼습니다"상세메시지를 갖는 예외가 발생한다.
		 */
		public void add(Customer customer) throws AddException{
			//ID중복확인
			
//				for(int i=0; i<count; i++) {
			for(Customer c: customers) {
//				Customer c = (Customer)o;
//				c.printInfo();
				if(c.equals(customer)) {
						//System.out.println("이미 존재하는 아이디입니다");
						//return;
					throw new AddException("이미 존재하는 아이디입니다");
				}
			}
				//중복되지 않은 경우
//			customers[count] = customer;
			customers.add(customer);
			
			}
			
//		}
			
//			if(count >= customers.length) {
//				System.out.println("저장소가 꽉찼습니다");
//			}else {
				//ID중복 확인 
//				customer.id  //private이어서 안됨. 
//				String id = customer.getId();   //추가할 고객의 아이디 
//				int i = 0;
//				for(; i<count; i++) {
//					Customer c = customers[i];   //이미 저장된 고객 
//					//id 중복 혹인 
//					if(c.getId().equals(id)) {//중복 
//						System.out.println("이미 존재하는 아이디입니다.");
//						break; 
//						
//					}
//				}
//				if(i==count) {//중복되지 않은 경우 
//					customers[count] = customer;
//					count++; //Good Code
//					System.out.println("고객추가 성공");
//					
//				}  중복확인 첫번째 방법 
//				for(int i=0; i<count; i++) {
//					Customer c = customers[i];
//					if(c.getId().equals(id)) {
//						System.out.println("이미 존재하는 아이디입니다.");
//						return;
//					}
//					if(customers[i].equals(customer)) {
//						System.out.println("이미 존재하는 아이디입니다. ");
//						return; 
//					}
//				}
				//중복되지 않은 경우
//				customers[count]=customer;
//				count++; //Good Code 
				
//				System.out.println("고객추가 성공");	
			

				
//			}
//			customers[count++] = customer; //Bad Code
//		}
		
		public List<Customer> findAll(){    //Customer[]all = dao.findAll();로 사용한다
			//customer 배열타입으로 하지 않을 것이다. 
			
			return customers;

		}
		
		/**
		 * 아이디에 해당 고객을 저장소에서 찾아 반환한다.
		 * @param id 아이디 
		 * @return 고객객체
		 * @throws FindException 아디에 해당 고객이 저장소에 없으면 "아이디에 해당하는 고객이 없습니다." 메세지를 갖는 예외발생한다. 
		 */
		
		public Customer findById(String id) throws FindException{ //Customer c = dao.findById(id);로 사용한다
			Customer c1 = new Customer();
			c1.setId(id);
			
			for(Customer c:customers) {//for(int i = 0; i<customers.size(); i++){
										// Customer c = customers.get(i);

//				Customer c1 = new Customer();  c1.setId(id);
				if(c.equals(c1)) {
					return c;
				}
				
			}
			//System.out.println(id+"고객은 존재하지 않습니다");
			throw new FindException("아이디에 해당하는 고객이 없습니다.");
//			return null;
		}
		/**
		 * 단어를 포함한 이름을 갖는 고객들을 반환한다. 
		 * @param word 단어
		 * @return 고객들
		 * @throws FindException 단어를 포함한 이름을 갖는 고객이 한명도 없으면 "고객정보가 변경되지않았습니다"
		 */
		
		public List<Customer> findByName(String word) throws FindException{
			//TODO 완성하세요
			List<Customer> list = new ArrayList<>();
			for(Customer c: customers) {
				if(c.getName().contains(word)) {
					list.add(c);
				}
			}
			if(list.size() > 0) {
				return list;
			}else {
				throw new FindException("단어를 포함한 이름의 고객은 없습니다");
			}
		}

//				}else { 
//					throw new FindException 
//////				Customer c = customers[i];
//////				 cName = c.getName();
////				if(cName.contains(word)) {
////					cArr1 = c; 
////					cArrIndex++;
//				}
//			}
//			Customer []cArr = null;
//			if(cArrIndex > 0) { 
//				cArr = new Customer[cArrIndex];
//				System.arraycopy(cArr1, 0, cArr, 0, cArrIndex);
//				return cArr;
//			}else {
//				throw new FindException("단어를 포함한 이름의 고객은 없습니다");
//			}
//		}

		/**
		 * 아이디에 해당하는 고객정보(비밀번호, 이름, 주소)를 수정한다<br>
		 * 단, 정보가 기존내용과 같을 경우는 변경하지 않는다
		 * @param c 변경할 고객객체
		 * @throws ModifyException c고객객체의 아이디가 저장소에 없으면 예외 발생한다<br>
		 *                         기존내용과 같을 경우는 "고객정보가 변경되지않았습니다"메시지를 갖는 예외가 발생한다
		 */
		public void modify(Customer c) throws ModifyException{
			try {
				Customer c1 = findById(c.getId()); //c1: 저장소의 고객	
				boolean flag = false;
				if(c1 != null) {
					if(!"".equals(c.getPwd())) {
						//c1.pwd = c.pwd;
						c1.setPwd(c.getPwd());
						flag = true;
					}
					if(!"".equals(c.getName())) {
						c1.setName(c.getName());
						flag = true;
					}
					if(!"".equals(c.getAddress())) {
						c1.setAddress(c.getAddress());
						flag = true;
					}
				}
				if(!flag) {
					throw new ModifyException("고객정보가 변경되지않았습니다");
				}
			}catch(FindException e) {
				throw new ModifyException(e.getMessage());
			}
		}

//		boolean modify(Customer c){
//			Customer c1 = findById(c.id); //c1: 저장소의 고객
//			if(c1 != null) {
//				boolean flag = false;
//				if(!"".equals(c.pwd)) {
//					c1.pwd = c.pwd;
//					flag = true;
//				}
//				if(!"".equals(c.name)) {
//					c1.name = c.name;
//					flag = true;
//				}
//				if(!"".equals(c.address)) {
//					c1.address = c.address;
//					flag = true;
//				}
//				return flag;
//			}
//			return false;
//		}
		public void remove(String id) {
			//TODO 완성하세요
			Customer c = new Customer();
			c.setId(id);
			customers.remove(c);
		}
		
		
		public static void main(String[] args) {
			CustomerDAOList dao = new CustomerDAOList();
			try {
				dao.add(new Customer("id1","p1","n1","a1"));
			} catch (AddException e) {
				e.printStackTrace();
			}
			try {
				dao.add(new Customer("id2","p2","n2","a2"));
			} catch (AddException e) {
				e.printStackTrace();
			}
			try {
				dao.add(new Customer("id1","x1","x1","x1"));
			} catch (AddException e) {
				e.printStackTrace();
			}
			try {
				dao.add(new Customer("id4","p4","n4","a4"));
				
			} catch (AddException e) {
				e.printStackTrace();
			}
			List<Customer> all = dao.findAll();
			for(Customer c: all) {
				c.printInfo();
			}
			try {
				Customer c = dao.findById("id3");
				c.printInfo();
			}catch (FindException e) {
				System.out.println(e.getMessage());
				// TODO: handle exception
			}
			System.out.println("---이름으로 검색 테스트--");
			try {
				List<Customer> list1 = dao.findByName("X");
				for(Customer c:list1) {
					c.printInfo();
				}
			} catch (FindException e) {
				
				System.out.println(e.getMessage());
			}
			System.out.println("--수정 테스트--");
			Customer c = new Customer("id1","", "nn1","aa1");
			
			try {
				dao.modify(c);
			} catch (ModifyException e) {
				e.printStackTrace();
			}
			System.out.println("--수정후 조회 테스트--");
			try {
				dao.findById("id1").printInfo();
			} catch (FindException e) {
				e.printStackTrace();
			}
			
			System.out.println("--삭제 테스트--");
			dao.remove("id1");
			System.out.println("--삭제후 전체조회 테스트--");
			for(Customer c1: dao.findAll()) {
				c1.printInfo();
			}
			
			
		}

			
		}

