package com.example.demo.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;

public class MyConnection {
//	static {
//		//static초기화 불럭이라고 부른다. 
//		// 클래스를 실행할 때 클래스가 
//		// 1. JDBC드라이버로드 
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver"); //클래스 이름을 문자열로 전달하면 jvm메모리 위쪽으로 로드가능 
//
//		}catch(ClassNotFoundException e) {
//			e.printStackTrace();// 어떤 때에 어던 오류가 나는지 나는 어디서 실수 많은지 오류를 판단자기가 해야 한다. 
//			// 예외 종류,메세지, 위치가 출력된다. 에러는 
//			// 해당 클래슬르 못 찾아서 , jdbc
//		}
//	}
//	public static Connection getConnection() throws SQLException {
//		Connection con = null;  //connection 객체 생성을 하는데 ㄱ본값 null 로 지정 
//		//접속할 db url을 적어주는 공간이다. 각자 공간이다 보니까 로컬 호스트나 127.0.0.1을 쓰면 된다. 
//		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //localhost대신 ip값도 가능 
//		//jdbc: jdbc프로토컬, : 다음에 dbms 종류를 적는다. : oracle, oracle에서 제공되는 jdbc 드라이버가 thin드라이버와 oci라는 드라이버가 있다. thin은 java로만 이루어진 경우, c나 ㅊC++은 oci이다. 
//		//@구분자는 콜론이고 호스트 localhost다음에 ip값, 서비스 아이디 : xe 
//		// 서비스 아이디는 db 관리자에게 문의하면 된다. 접속할 아이디, 포트번호, 서비스아이디 
//		
//		String user = "hr"; //접속할 계정명 
//		String password = "hr";
//		con = DriverManager.getConnection(url,user,password);//연결을 하는데 위에 url, user, password로 연결한다 
//		System.out.println("DB와 연결 성공 ");  //연결성공했으면 연결 성공 출력 
//		return con;
//	}

	public static void close(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	public static void close(Statement stmt) {
		if(stmt !=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void close(Connection con) {
		if(con !=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void close(ResultSet rs, Statement stmt, Connection con) {
		close(rs);
		close(stmt);
		close(con);
	}
	public static void close(Statement stmt, Connection con) {
		close(stmt);
		close(con);
		
	}
	
}
