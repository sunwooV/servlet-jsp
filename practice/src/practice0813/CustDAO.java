package practice0813;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CustDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public CustDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List listCusts(CustBean cb) {
		List list = new ArrayList();
		try {
			//connDB(); //�� ���� ������ �����ͺ��̽��� �����Ѵ�.
			con = dataFactory.getConnection();
			
			if(cb.getSearchId() == null) {
				cb.setSearchId("");
			}
			
			String query = "select cust_id, cust_name, cust_address, cust_state, cust_zip, cust_country, cust_contact, cust_email"
					+ " from customers"
					+ " where cust_id like '%" + cb.getSearchId() + "%'";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("cust_id");
				String name = rs.getString("cust_name");
				String address = rs.getString("cust_address");
				String state = rs.getString("cust_state");
				String zip = rs.getString("cust_zip");
				String country = rs.getString("cust_country");
				String contact = rs.getString("cust_contact");
				String email = rs.getString("cust_email");
				
				CustBean bean = new CustBean();

				bean.setId(id);
				bean.setName(name);
				bean.setAddress(address);
				bean.setState(state);
				bean.setZip(zip);
				bean.setCountry(country);
				bean.setContact(contact);
				bean.setEmail(email);

				list.add(bean);
			}
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list; //��ȸ�� ���ڵ��� ������ŭ MemberVO ��ü�� ������ ArrayList �� ��ȯ�մϴ�.
	}
	
	public void addCust(CustBean custbean) {
		try {
			Connection con = dataFactory.getConnection();
			String id = custbean.getId(); //���̺� ������ ȸ�� ������ �޾� �ɴϴ�.
			String name = custbean.getName();
			String address = custbean.getAddress();
			String state = custbean.getState();
			String zip = custbean.getZip();
			String country = custbean.getCountry();
			String contact = custbean.getContact();
			String email = custbean.getEmail();
			
			String query = "insert into customers";
			query += " (cust_id, cust_name, cust_address, cust_state, cust_zip, cust_country, cust_contact, cust_email)";
			query += " values(?,?,?,?,?,?,?,?)";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id); //insert ���� �� '?'�� ������� ȸ�� ������ �����մϴ�.
			pstmt.setString(2, name);
			pstmt.setString(3, address);
			pstmt.setString(4, state);
			pstmt.setString(5, zip);
			pstmt.setString(6, country);
			pstmt.setString(7, contact);
			pstmt.setString(8, email);

			pstmt.executeUpdate(); //ȸ�� ������ ���̺� �߰��մϴ�.
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editCust(CustBean custbean) {
		try {
			Connection con = dataFactory.getConnection();
			String id = custbean.getId(); //���̺� ������ ȸ�� ������ �޾� �ɴϴ�.
			String name = custbean.getName();
			String address = custbean.getAddress();
			String state = custbean.getState();
			String zip = custbean.getZip();
			String country = custbean.getCountry();
			String contact = custbean.getContact();
			String email = custbean.getEmail();
			String editId = custbean.getEditId();
			
//			System.out.println(id + " " + name + " " + address + " " + state + " " + zip + " " + country + " " + contact + " " + email + " " + editId );
			
			String query = "update customers set cust_id=?, cust_name=?, cust_address=?, cust_state=?, cust_zip=?, cust_country=?, cust_contact=?, cust_email=? where cust_id='" + editId + "'";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id); //insert ���� �� '?'�� ������� ȸ�� ������ �����մϴ�.
			pstmt.setString(2, name);
			pstmt.setString(3, address);
			pstmt.setString(4, state);
			pstmt.setString(5, zip);
			pstmt.setString(6, country);
			pstmt.setString(7, contact);
			pstmt.setString(8, email);
			pstmt.executeUpdate();
			pstmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
