package com.my.customer.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import com.my.customer.CustomerManager;
import com.my.customer.vo.Customer;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;

public class CustomerDAOFile implements CustomerDAOInterface {
		private List<CustomerDAOInterface> CustomerDAOInterface;
	
		public void add(Customer customer) throws AddException{
			File file = new File("customers.txt");
			FileWriter fw = null;

			try {
			    FileWriter fileWriter = new FileWriter(file);
//			    PrintWriter printWriter = new PrintWriter(fileWriter);
//			    printWriter.println("오늘은 금요일이에요.\n");
//			    printWriter.println("강사님!");
//			    printWriter.println("오늘 3시에 기업설명회 있습니다.");
//			    printWriter.println("잊어버리실까봐 미리 말씀드리는 거예요.");
//			    printWriter.close();
			} catch (IOException e) {
			    e.printStackTrace();
			}
			
		}
		
		public List<Customer> findAll() throws FindException{
			return null;
			
			
		}
		  
		public Customer findById(String id, Customer[] customers) throws FindException{
			return null;
//			Customer c1 = new Customer();
//			c1.setId(id);
//			
//			for(Customer c:customers) {//for(int i = 0; i<customers.size(); i++){
//										// Customer c = customers.get(i);
//
////				Customer c1 = new Customer();  c1.setId(id);
//				if(c.equals(c1)) {
//					return c;
//				}
//				
//			}
//			//System.out.println(id+"고객은 존재하지 않습니다");
//			throw new FindException("아이디에 해당하는 고객이 없습니다.");
////			return null;
		}
		
		
		public List<Customer> findByName(String word) throws FindException{
			return null;
			
		}
		
		public void modify(Customer c) throws ModifyException{
			
		}
		public void remove(String id) {
			
		}
		public void printInfo() {
			String fileName = "customers.txt";
			FileReader fr = null;
			try {
				fr = new FileReader(fileName);
				
				char[] cbuf = new char[1000];
				int offset = 0;
				int length = 1000;// 밖으로 빼면 재사용하겠다.
				while(true) {
					
					
					int size = fr.read(cbuf, offset, length);
					if(size== -1) {
						break;
					}
					for(char c: cbuf) {
						System.out.print(c);
						
					}
					
					
					
				}
				

				
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		@Override
		public com.my.customer.vo.Customer findById(String id) throws FindException {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		

	}


