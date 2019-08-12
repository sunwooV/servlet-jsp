package practice0807;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProdDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public ProdDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List ProdList(String prodId, String vendId) {
		List list = new ArrayList();
		try {
			Connection con = dataFactory.getConnection();
			
			System.out.println(prodId + vendId);
			
			String query = "select p.prod_id, p.prod_name, p.prod_price, p.prod_desc, v.vend_name, v.vend_id"
					+ " from products p, vendors v "
					+ " where p.vend_id = v.vend_id";
//			if(prodId != null && !"".equals(prodId)){ //��ǰ��ȣ �Է����� ��
//				query += " and p.prod_id like '%" + prodId + "%'";
//			} if(vendId != null && !"".equals(vendId)){ //���޾�ü��ȣ �Է����� ��
//				query += " and v.vend_id like '%" + vendId + "%'";
//			}
			
			//������ Ȥ�� �Ʒ��� (�� �� ����)
			if(prodId != null && prodId.length() != 0){ //��ǰ��ȣ �Է����� ��
				query += " and p.prod_id like '%" + prodId + "%'";
			} if(vendId != null && vendId.length() != 0){ //���޾�ü��ȣ �Է����� ��
				query += " and v.vend_id like '%" + vendId + "%'";
			}
			
			
			//��� ����� ���� ������ �ʾƵ� �ȴ�. 
			//-> �̷��� �ϸ� ��ǰ��ȣ, ���޾�ü ��ȣ �Է� ���ϸ� null ���� �ƴ� ""���� �� �� ������ �ִ� where ���� �Ѿ
//			if(prodId != null && vendId == null){ //��ǰ��ȣ�� �Է����� ��
//				query += " and p.prod_id like '%" + prodId + "%'";
//			} else if(vendId != null && prodId == null){ //���޾�ü��ȣ �Է����� ��
//				query += " and v.vend_id like '%" + vendId + "%'";
//			} else if(vendId != null && prodId != null){ //���޾�ü��ȣ �Է����� ��
//				query += " and v.vend_id like '%" + vendId + "%'"
//						+ " and p.prod_id like '%" + prodId + "%'";
//			}
			
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.executeUpdate(); //ȸ�� ������ ���̺� �߰��մϴ�.
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				String id = rs.getString("prod_id");
				String name = rs.getString("prod_name");
				String price = rs.getString("prod_price");
				String desc = rs.getString("prod_desc");
				String vendNm = rs.getString("vend_name");
				String searchId = rs.getString("prod_id");
				String searchVendId = rs.getString("vend_id");
				ProdVO vo = new ProdVO();
				vo.setId(id);
				vo.setName(name);
				vo.setPrice(price);
				vo.setDesc(desc);
				vo.setVendNm(vendNm);
				vo.setSearchId(searchId);
				vo.setSearchVendId(searchVendId);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void addProd(String id, String name, double price, String desc, String vendId) {
		try {
			Connection con = dataFactory.getConnection();
			
			String query = "insert into products"
					+ " (prod_id, prod_name, prod_price, prod_desc, vend_id)"
					+ " values (?, ?, ?, ?, ?)";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setDouble(3, price);
			pstmt.setString(4, desc);
			pstmt.setString(5, vendId);

			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delProd(String id) {
		try {
			ProdVO vo = new ProdVO();
			vo.setDelId(id);
			Connection con = dataFactory.getConnection();

			String query = "delete from products where prod_id=?";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			
			pstmt.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
