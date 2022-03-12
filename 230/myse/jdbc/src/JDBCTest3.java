import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//SELECT NAME, DB_UNIQUE_NAME FROM v$database; 서비스 이름 확인하는 방법 
public class JDBCTest3 {
	public static void selectTest() {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver"); //클래스 이름을 문자열로 전달하면 jvm메모리 위쪽으로 로드가능 

	}catch(ClassNotFoundException e) {
		e.printStackTrace();// 어떤 때에 어던 오류가 나는지 나는 어디서 실수 많은지 오류를 판단자기가 해야 한다. 
		// 예외 종류,메세지, 위치가 출력된다. 에러는 
		// 해당 클래슬르 못 찾아서 , jdbc
	}
	//2. DB와 연결 
	// JAVA.connect이라는 패키지에서 함/

	Connection con = null;  //connection 객체 생성을 하는데 ㄱ본값 null 로 지정 
	//접속할 db url을 적어주는 공간이다. 각자 공간이다 보니까 로컬 호스트나 127.0.0.1을 쓰면 된다. 
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; //localhost대신 ip값도 가능 
	//jdbc: jdbc프로토컬, : 다음에 dbms 종류를 적는다. : oracle, oracle에서 제공되는 jdbc 드라이버가 thin드라이버와 oci라는 드라이버가 있다. thin은 java로만 이루어진 경우, c나 ㅊC++은 oci이다. 
	//@구분자는 콜론이고 호스트 localhost다음에 ip값, 서비스 아이디 : xe 
	// 서비스 아이디는 db 관리자에게 문의하면 된다. 접속할 아이디, 포트번호, 서비스아이디 
	
	String user = "hr"; //접속할 계정명 
	String password = "hr";
	
	
	Statement stmt = null; //송신
	ResultSet rs = null; //수신 
	try {
		con = DriverManager.getConnection(url,user,password);//연결을 하는데 위에 url, user, password로 연결한다 
		System.out.println("DB와 연결 성공 ");  //연결성공했으면 연결 성공 출력 
		
		//3. sql문 송신 
		String selectSQL = "SELECT employee_id, first_name, salary, hire_date FROM employees";
		stmt = con.createStatement();//송신함. connect객체인 con로 createStatement를 호출 
		stmt.executeQuery(selectSQL);  //수신하는데 selectSQL의 결과를 수신한다. 
		//4. 결과 수신 
		rs = stmt.executeQuery(selectSQL); //결과를 변수에 다음. 
		rs.next(); //수신된 결과값을 첫번째 행으로 옴겨야 해서 첫번째 행으로 커서가 이동하게 된다. 
		//마지막 까지 가면 next가 false가 됨. 
		
		while(rs.next()) {//while(rs.next()==true){
			int emp_id = rs.getInt("employee_id"); // employee_id 의 100 1행 1열 값 숫자값을 가져오겠다. 
			String f_name = rs.getString("first_name");  //first_name의 값을 문자열로 가져오겠다. 
			int sal = rs.getInt(3); //3번쨰이다. 자바의 인덱스는 0이지만 db에서의 인덱스는 1로 시작하여 주의해야 한다. 
			Date hireDt=rs.getDate("hire_date");
			System.out.println(emp_id + ":" + f_name + ":" + sal + ":" + hireDt);
			// db 접속하고 송신해서 처음부터 마지막 행 반복 수행하면서 각 행의 컬럼 값들을 자바 콘솔에 출력한다 
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		//5. DB연결닫기 
	} finally {
		//밖의 자원 닫으려면 
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
			if(stmt !=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				if(con !=null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
		}
	
	// 여기까지 하면 db연결 성공 
	//위는 클래스가 stacic이어서 클래스 이름으로 가능 
	
}
	public static void dmlTest() {
		//1. JDBC 드라이버 로드 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2. DB연결
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		Statement stmt = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			
			Scanner sc = new Scanner(System.in);
			System.out.print("고객ID:");
			String id = sc.nextLine();
			System.out.print("고객 비밀번호:");
			String pwd = sc.nextLine();
			
			
			stmt = con.createStatement();
			
			String insertSQL = "INSERT INTO customer(id,pwd) VALUES('"+id+"', '" + pwd+"')";
			stmt.executeUpdate(insertSQL);  //insert update는 반환값이 
			// 콘솔에 나오는 처리 결과가 반환된다. 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				
				if(stmt !=null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					if(con !=null) {
						try {
							con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			
		}
		
		
	}  //jdbc는 오토 커밋이다. 
	
	public static void dmlPrepareStatementTest() {
		//1. JDBC 드라이버 로드 
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//2. DB연결
				Connection con = null;
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "hr";
				String password = "hr";
//				Statement stmt = null;
				PreparedStatement pstmt = null;  //송신을 담당해줄 라이브러리 
				try {
					con = DriverManager.getConnection(url, user, password);
					
					
					Scanner sc = new Scanner(System.in);
					System.out.print("고객ID:");
					String id = sc.nextLine();
					System.out.print("고객 비밀번호:");
					String pwd = sc.nextLine();
					
					
//					stmt = con.createStatement();
//					
//					String insertSQL = "INSERT INTO customer(id,pwd) VALUES('"+id+"', '" + pwd+"')";
//					stmt.executeUpdate(insertSQL);  //insert update는 반환값이 
//					// 콘솔에 나오는 처리 결과가 반환된다. 
					String insertSQL = "INSERT INTO customer(id,pwd) VALUES(?,?)";
					pstmt = con.prepareStatement(insertSQL);
					pstmt.setString(1, id);
					pstmt.setString(2, pwd);
					pstmt.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					
						
						if(pstmt !=null) {
							try {
								pstmt.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
							if(con !=null) {
								try {
									con.close();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
					
				}
				
		
	}
	public static void main(String[] args) {
		
//		selectTest();
		// 1. jdbc드라이버로드 
//		dmlTest();
		dmlPrepareStatementTest();
     }
	
}
