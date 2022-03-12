package com.my.customer.vo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {

	public static void main(String[] args) throws IOException {
		File dir;
		dir = new File(".");//현재경로
		                  // ".." - 상위경로 
		                  //"../.."  -상위상위경로 
		System.out.println( "dir.getName()"+dir.getName());
		System.out.println("dir.getAbsoluteFile"+ dir.getAbsoluteFile()); // 경로명이나 디렉토리 이름이나 같은 의미가 되어 같은 값을 반환 
		System.out.println("dir.getAbsolutePath"+dir.getAbsolutePath());  //디렉토리의 절대 path값이나 
		System.out.println("dir.getCanonicalPath"+dir.getCanonicalPath());
		
		System.out.println(dir.isDirectory()); //true이면 디렉토리이고 false면 디렉토리가 아니다 >> 일반 파일이다.   //true
		//없는 디렉토리를 쓴다면  false
		//배열타입으로 반환한다. 
		String[] fileNames = dir.list();
		for(String name:fileNames) {
			System.out.println(name);  //파일 디렉토리 하위 디렉토리 출력함. 현재 디렉토리가 갖고 있는 하위 디렉토리이름과 현재 디렉토리가 가지고 있는 파일 이름을 출력 
		}
		System.out.println("---------------------");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");  //대소문자 정확하게 지켜서 
		File[] files = dir.listFiles();  //하위디렉토리 및 
		for(File f1:files) {
//			f1.getName(); //파일 이름 
			Date dt= new Date(f1.lastModified());
			System.out.print(sdf.format(dt));
			System.out.print("\t");
			if(f1.isDirectory()) {  
//				Date dt = new Date(f1.lastModified()); //최종 사용시간 
				//하위폴더인 경우
				
//				System.out.println("<DIR> ");
				
//				System.out.printf("%s  ", "<DIR>");
				System.out.printf("**%10s  ", "<DIR>");
				
			}else {
				//파일인 경우
				System.out.print(f1.length());
				System.out.print(" ");
//				System.out.printf("%d ", f1.length());
				System.out.printf("**%-10d ** ", f1.length());
				
			}
			System.out.println(f1.getName());
		}
		
		File f;
		f=new File(".\\src\\FileIOTest.java");  //파일에 대한 정보를 알아보자. 
		System.out.println("f.exists()"+f.exists()); //파일의 존재 여부를 알 수 있다. 
		System.out.println("f.length():"+f.length()); //파일크기를 확인해볼 수 있다.  //기본 단위는 byte이다. 
		//자바프로그램으로 파일 타입 객체 생성하고 f.length로 그 파일 크기를 알아낸다. 
		System.out.println("f.canWrite():" + f.canWrite());  //쓰기 가능한 파일인지 확인하기 true: 쓰기 가능 false: 쓰기 불가능     //true
		System.out.println(new Date(f.lastModified()));  //최종사용시간을 반환한다. //리턴타입 long타입임. 
		//데이터 라이브러리의 생성자 인자로 전달하면 날짜로 변환되어 나온다. 
		
		//대표디렉토리가 갖고 있는 정보에는 
		
	}

}
