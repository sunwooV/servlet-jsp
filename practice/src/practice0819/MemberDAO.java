package practice0819;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addMember(MemberVO vo) {
		try {
			con = dataFactory.getConnection();

			String query = "insert into member (member_id, name, password, regdate) values(?,?,?,sysdate)";
			System.out.println("prepareStatement: " + query);

			System.out.println("-----------------------------------");
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPwd());
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	

	public void editMember(MemberVO vo) {
		try {
			con = dataFactory.getConnection();

			String query = "update member set password=? where member_id=?";
			System.out.println("prepareStatement: " + query);

			System.out.println("-----------------------------------");
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, vo.getNewPwd());
			pstmt.setString(2, vo.getUser_id());

			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public int checkMember(MemberVO vo) {
		ResultSet rs = null;

		try {
			con = dataFactory.getConnection();
			
			String query = "select count(*) as cnt from member where member_id=? and password=?";
			System.out.println("prepareStatement: " + query);
			
			pstmt = con.prepareStatement(query); 
			pstmt.setString(1, vo.getUser_id());
			pstmt.setString(2, vo.getUser_pwd());
			
			rs = pstmt.executeQuery();
			rs.next();
			
			System.out.println("//////////////////////////////" + rs.getString("cnt"));
			
			if(rs.getString("cnt").equals("1")) {
				rs = null;
				String query2 = "select name from member where member_id='" + vo.getUser_id() + "' and password='" + vo.getUser_pwd() + "'";
				System.out.println("prepareStatement: " + query2);
				
				pstmt = con.prepareStatement(query2); 
//				pstmt.setString(1, vo.getUser_id());
//				pstmt.setString(2, vo.getUser_pwd());
				rs = pstmt.executeQuery();
				rs.next();
				
				String name = rs.getString("name");
				vo.setName(name);
				pstmt.close();
				con.close();
				return 1;
			} else {
				return 0;
			}

			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	

}
