package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import jdbc.JdbcUtil;

import member.model.Member;
import member.service.AnswerRequest;
import member.service.LoginRequest;

public class MemberDao {

	public Member selectById(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from member where member_id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			Member member = null;
			if (rs.next()) {
				member = new Member(
						rs.getString("member_id"), 
						rs.getString("name"), 
						rs.getString("answer"),
						rs.getString("password"),
						toDate(rs.getTimestamp("regdate")));
		
			}
			return member;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}

	public void insert(Connection conn, Member mem) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into member values(?,?,?,?,?)")) {
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getName());
			pstmt.setString(3, mem.getPassword());
			pstmt.setString(4,mem.getAnswer());
			System.out.println("wwwwwwww"+mem.getAnswer());
			pstmt.setTimestamp(5, new Timestamp(mem.getRegDate().getTime()));
			pstmt.executeUpdate();
		}
	}

	public void update(Connection conn, Member member) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"update member set name = ?, password = ? where member_id = ?")) {
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getId());
			pstmt.executeUpdate();
		}
	}
	
	
	
	public void changePwd(Connection conn, Member member) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				 "update member set password='"+member.getNewPwd()+"'" + " WHERE member_id = '"+member.getId()+"' and password ='"+member.getPassword()+"'")) {
//			pstmt.setString(1, member.getNewPwd());
//			pstmt.setString(2, member.getId());
			pstmt.executeUpdate();
		}
	}
	
	
	public boolean isExisted(Connection conn, Member member) {
		boolean result = false;
		try (PreparedStatement pstmt = conn.prepareStatement(
				"select decode(count(*),1,'true','false') as result  from member where member_id = ? and password = ?")){
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());

			ResultSet rs = pstmt.executeQuery();
			rs.next();
			result = Boolean.parseBoolean(rs.getString("result"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		}

	
	public void getMemberInfo(Connection conn, Member member, LoginRequest loginReq) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select name from member where member_id = '"+member.getId()+"'");
			//pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				loginReq.setName(name);
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			}
		}
	
	public boolean answer(Connection conn, AnswerRequest answerReq) {
		boolean result = false;
		try (PreparedStatement pstmt = conn.prepareStatement(
				"select decode(count(*),1,'true','false') as result from member where member_id = ? and answer = ?")){
			pstmt.setString(1, answerReq.getId());
			pstmt.setString(2, answerReq.getAnswer());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			result = Boolean.parseBoolean(rs.getString("result"));
			System.out.println(answerReq.getId() + "--" +answerReq.getAnswer());
	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		}
	
	
	
	
	public void getanswerInfo(Connection conn, Member member, AnswerRequest answerReq) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select password from member where member_id = '"+member.getId()+"'");
			//pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String password = rs.getString("password");
				answerReq.setPassword(password);
				System.out.println(member.getId() + "777777"+password);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			}
		}
	}
	
	

	


	
	







