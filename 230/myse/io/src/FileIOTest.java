

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOTest {
	public static void readTest() {
		/**
		 * 1. 리소스결정: a.txt파일 
		 * 2. 노드스트림결정: 문자단위스트림- FileReader
		 */
		
		String fileName = "a.txt";  //상대경로표기법 : .. -상위경로   ex) ..\\a.txt 
		                              //           : . - 현재경로  ex) .\\a.txt 
                                      //      : .\\하위경로명 ex) .\\src\\a.txt     src\\a.txt
		                              //절대경로표기법: 절대경로 플레임 다 주면 됨. ex)E:\\230\\myse\\io\\a.txt           
		//io패키지에 있어야지 src에 있으면 안됨.
		//현재 경로에 있는 a.txt가 된다. 앞에 아무 경로가 없으면
		//..은 상위 경로    
		FileReader fr = null;
		try {
			fr = new FileReader(fileName);
			//한 문자씩 읽기 
//			int readValue = -1;
//			while((readValue=fr.read())!= -1){
//				System.out.print((char)readValue);
//				
//			}
//여러문자 한 번에 읽기 
			char[] cbuf = new char[5];
			int offset = 0;
			int length = 5;// 밖으로 빼면 재사용하겠다.
			while(true) {
				
				
				int size = fr.read(cbuf, offset, length);
				if(size== -1) {
					break;
				}
				for(int i=0; i<cbuf.length; i++) {
					char c = cbuf[i];
					System.out.println(i+ ":"+c);
					
				}
				String str = new String(cbuf, 0, size);
				System.out.println(str);
				System.out.println("실제 읽어온 문자수: " + size);
				
			}
			
//			for(char c: cbuf) {
//				System.out.println(c);
//			}
			
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	




	
		
	}
	public static void writeTest() {
		/**
		 * a.txt파일에 바이트단위로 쓰기 
		 * 1. 목적지결정: a.txt파일 
		 * 2. 노드스트림결정: FileOutputStream
		 */
		String fileNmae = "a.txt";
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(fileNmae);
			fos.write(65); //'A'
			fos.write(97); //'a'
			fos.write(13); //enter
			fos.write(10); //enter
			fos.write(49);//'1'
//			fos.write(44032); //16bit unicode '가'  //bit로는 넘쳐서 써지지 않음. //굳이 쓰고 싶으면 바이트 각각 3개 합쳐서 쓰기를 해줘야 함. 
			fos.write(234); fos.write(176); fos.write(128);//utf-8 '가'
			byte[] buf = "가".getBytes();
			fos.write(buf);
			
			fos.write("안녕하세요".getBytes());
			
			fos.write('A');
			fos.write('a');
			fos.write('1');
//			fos.write('가'); //문자의 byte가 커서 저장이 되지 않음.   //저장안됨. 
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void writeTest1() {
		/**
		 * 문자단위로 a.txt파일에 쓰기 
		 */
		String fileName = "a.txt";
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);  //새파일만들기 
			fw.write("hello");
			fw.write("\n");
			
			fw.flush();
			
			fw.write("자바입출력");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}// 외부와의 자원과의 연결을 끊겠다는 것인데 방뭄 닫을 때 끼어서 잘 안 닫힐 수 있다. 즉 예외가 발생할 수 있다. 
				
			}
			
		}
		
		
	}
	public static void main(String[] args) {
//		writeTest();
		writeTest1();
		
		readTest();
		
	}
	
	}
		
		
		