package jdbcUtil;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JDBConnection {

	public Connection con;  // 연결된 드라이버에 SQL을 요청할 객체를 생성하는 클래스
	public Statement stmt;  // SQL 실행요청을 하는 클래스
	public PreparedStatement psmt; // SQL 실행 결과를 받아오는 클래스
	
	
	// 기본생성자
	public JDBConnection() {
		// JDBC 드라이버 로드
		//MySQL 
		
		try {
			// mysql-connector-j.xxx.jar 드라이버의 클래스를 로드한다.
			Class.forName("com.mysql.cj.jdbc.Driver");
			 
			// DB에 연결
			// - 연결에 필요한 정보 : URL, id, pw
			// URL : jdbc:mysql://도메인:[PORT]/[스키마]?옵션파라미터
			//     *내 PC의 IP주소 : localhost : 127.0.0.1
			// *33096 : MySQL 데이터베이스의 기본 포트
		    String url = "jdbc:mysql://localhost:3306/dinoDB";
			String id ="dino";// DB_ID  사용자계정
		    String pw ="1234";// DB_PW  사용자계정
		    //String dbURL = "jdbc:mysql://localhost:3306/데이터베이스명";  참고 URL
		    // 자바 프로그램에서 JDBC 드라이버를 연결시켜주는 클래스
		    //getConnection() 매소드로 DB에 연결 요청하고 생성된 Connection 객체를 반환받는다.
		    con = DriverManager.getConnection(url, id, pw);
		    
		    System.out.println("DB 연동 성공");
		} catch(Exception e) {
			System.out.println("DB 연동 실패");
			e.printStackTrace(); 	
		}
	}
}
