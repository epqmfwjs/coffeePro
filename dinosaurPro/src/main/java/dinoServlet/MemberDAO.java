package dinoServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class MemberDAO {
	   String DBurl = "jdbc:mysql://localhost:3306/dinoDB";
	   String DBid ="dino";// DB_ID  사용자계정
	   String DBpw ="1234";// DB_PW  사용자계정
	   
	   public MemberDAO() {/*기본생성자 생성*/}
	   
	// ------------------------------------------insert----------------------------------
	   
	public String insert(MemberDTO memberDTO) throws ClassNotFoundException, SQLException{

		String returnPage = null;
		Class.forName("com.mysql.cj.jdbc.Driver");	 
        Connection conn = DriverManager.getConnection(DBurl,DBid,DBpw);
        conn.setAutoCommit(false);
        
        PreparedStatement pstmt = conn.prepareStatement("insert into user(id, pw, name) values(?,?,?)");		
        pstmt.setString(1, memberDTO.getDbId1());
        pstmt.setString(2, memberDTO.getDbPw1());
        pstmt.setString(3, memberDTO.getDbName()); 
        int result = pstmt.executeUpdate();
        
       if (result == 1) {            
    	   returnPage = "okJoin.jsp";
			System.out.println("데이터 입력 완료!");
			conn.commit();
			}else {            
			returnPage = "login.jsp";
			System.out.println("데이터 입력 실패!");            
			conn.rollback();
		}       
        pstmt.close();
        conn.close();
        return returnPage;
    }
	
	// ------------------------------------------select----------------------------------

	public boolean select(String Uid, String Upw) {
	    boolean result = false;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	    try (Connection conn = DriverManager.getConnection(DBurl, DBid, DBpw);
	         PreparedStatement pstmt = conn.prepareStatement("select * from user where id = ?")) {
	        
	        pstmt.setString(1, Uid);
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                String dbId = rs.getString("id");
	                String dbPw = rs.getString("pw");
	                result = Uid.equals(dbId) && Upw.equals(dbPw);
	                System.out.println("셀렉트 끝");
	            }
	        }
	        pstmt.close();
	        conn.close();
	    }catch(SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	
	//---------------------------delete---------------------------------------
	
	public boolean delete(String Uid,String Upw ,String sId) {
		boolean result = false;
		Connection conn = null;
		int num = -1;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(DBurl,DBid,DBpw);
			pstmt = conn.prepareStatement("delete from user where id=?");
			pstmt.setString(1,sId);
			num = pstmt.executeUpdate();
			pstmt.executeUpdate();
			if(num == 0) {
				System.out.println("false");
				result = false;	
			}else {
				System.out.println("true");
				result = true;
			}
	        pstmt.close();
	        conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	// ------------------------------------------update----------------------------------
	
	public String update(String Unm,String Upw, String sId) {
		String returnPage = null;
		int result = -1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(DBurl,DBid,DBpw);
			pstmt = conn.prepareStatement("update user set name = ?,pw = ? where id=?");
			
			pstmt.setString(1,Unm);
			pstmt.setString(2,Upw);
			pstmt.setString(3,sId);
			
			result = pstmt.executeUpdate();	
			System.out.println(result);
			if(result == 1) {
				returnPage = "true";
			}else {
				returnPage = "false";
			}
	        pstmt.close();
	        conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return returnPage;
	}
}