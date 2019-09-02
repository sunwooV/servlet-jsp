package practice0829;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


public class CustomerDAO {
	private Connection con;
	private DataSource dataFactory;

	public CustomerDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List customerList(CustomerVO vo) throws SQLException {
		List list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Customer customer = null;
		try {
			con = dataFactory.getConnection();
			String query = "select * from customers where cust_id = '" + vo.getSearchId() + "'";
			pstmt = con.prepareStatement(query);
//			pstmt.setString(1, vo.getSearchId());
			rs = pstmt.executeQuery();
			System.out.println("query : " + query);
			while (rs.next()) {
				System.out.println("=====================");
				customer = new Customer(rs.getString("cust_id"),
												rs.getString("cust_name"),
												rs.getString("cust_address"),
												rs.getString("cust_state"),
												rs.getString("cust_zip"),
												rs.getString("cust_country"),
												rs.getString("cust_contact"),
												rs.getString("cust_email"));
				list.add(customer);
			
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		return list;
	}
	
	public void insert(CustomerVO vo) throws SQLException {
		PreparedStatement pstmt = null;

		try {
			con = dataFactory.getConnection();
			String query = "insert into customers (cust_id, cust_name, cust_address, cust_state, cust_zip, cust_country, cust_contact, cust_email) values(?,?,?,?,?,?,?,?)";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getState());
			pstmt.setString(5, vo.getZip());
			pstmt.setString(6, vo.getCountry());
			pstmt.setString(7, vo.getContact());
			pstmt.setString(8, vo.getEmail());
			
			pstmt.executeUpdate();

			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public void update(CustomerVO vo) throws SQLException {
		PreparedStatement pstmt = null;

		try {
			con = dataFactory.getConnection();
			String query = "update customers set cust_name=?,cust_address=?,cust_state=?,cust_zip=?,cust_country=?,cust_contact=?,cust_email=? where cust_id=?";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getAddress());
			pstmt.setString(3, vo.getState());
			pstmt.setString(4, vo.getZip());
			pstmt.setString(5, vo.getCountry());
			pstmt.setString(6, vo.getContact());
			pstmt.setString(7, vo.getEmail());
			pstmt.setString(8, vo.getId());
			
			pstmt.executeUpdate();

			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
}
