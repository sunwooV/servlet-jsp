package practice0828;

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
	
	public Customer customerList(CustomerVO vo) throws SQLException {
		List list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Customer customer = null;
		try {
			con = dataFactory.getConnection();
			String query = "select * from customers where cust_id = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, vo.getId());
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
				System.out.println(rs.getString("cust_id") +
												rs.getString("cust_name")+
												rs.getString("cust_address")+
												rs.getString("cust_state")+
												rs.getString("cust_zip")+
												rs.getString("cust_country")+
												rs.getString("cust_contact")+
												rs.getString("cust_email"));
			
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		return customer;
	}
}
