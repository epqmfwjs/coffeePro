package dinoServlet;

import java.sql.SQLException;

public class MemberDTO {
	private String dbId1;
	private String dbPw1;
	private String dbName;
	
	public MemberDTO() {
	} 
 
	public MemberDTO(String dbId1,String dbPw1,String dbName) throws SQLException {
		super();
		//System.out.println("DTO"+dbId1 + dbPw1 + dbName);
		this.dbId1 = dbId1;
		this.dbPw1 = dbPw1;
		this.dbName = dbName;
	} 
	public MemberDTO(String dbId1,String dbPw1) throws SQLException {
		super();
		//System.out.println("DTO"+dbId1 + dbPw1 + dbName);
		this.dbId1 = dbId1;
		this.dbPw1 = dbPw1;

	} 
		
	public String getDbId1() {
		return dbId1;
	}
	public void setDbId1(String dbId1) {
		this.dbId1 = dbId1;
	}
	public String getDbPw1() {
		return dbPw1;
	}
	public void setDbPw1(String dbPw1) {
		this.dbPw1 = dbPw1;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	
	
}
