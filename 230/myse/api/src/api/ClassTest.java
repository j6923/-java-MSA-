package api;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ClassTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //값 입력을 받아보려고 한다. 
		System.out.println("런타임 다이너믹 클래스로드");
		System.out.print("패키지명.클래스명을 정확히 입력하세요");//사용자에게 알린다 
		String className = sc.nextLine();  //입력받은 클래스 이름
		
		try {
			Class clazz = Class.forName(className);
			System.out.println("로드된 실제클래스 이름은 " + clazz.getName());
			Field[] fields =clazz.getDeclaredFields(); //클래스가 가지고 있는 필드를 얻어올 수 있다. // fields 정보 얻기
			System.out.println("--로드된 클래스의 멤버필드들---");
			for(Field f: fields) {
				System.out.println(f.getName());
			}
			System.out.println("--로드된 클래스의 멤버필드들---");
			Method[] method = clazz.getDeclaredMethods(); //methods 정보 얻기 
			for(Method m:method) {
				System.out.println(m.getName());
			}
			//객체를 생성한다거나 
			//객체생성
			Object o = clazz.newInstance();  //로드된 객체가 자동 
			
			//toString메서드 찾기 
			Method toStringMethod = clazz.getDeclaredMethod("toString"); 
			//toString메서드 호출 
			Object result = toStringMethod.invoke(o, null); //아규먼트 없어서 null
			//결과 출력
			System.out.println("toString()결과:" + result);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
