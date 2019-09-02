package guestBook.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import guestBook.dao.GuestBookDao;
import guestBook.model.GuestBook;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class RealEditService {
	private GuestBookDao guestDao = new GuestBookDao();
	private static final int message_count_per_page = 3;
	private static int totalPage;
	
	public boolean editCheck(EditRequest editReq) {
		boolean result=false;
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			System.out.println("service");
			
			result = guestDao.isExisted(conn, editReq.getEditId(), editReq.getMessagepassword());
			
			if(result) {
				guestDao.update(conn, new GuestBook(editReq.getEditId(), editReq.getName(), editReq.getMessagepassword(), editReq.getContent()));
				conn.commit();
			}
			conn.commit();
			System.out.println(editReq.getEditId()+editReq.getMessagepassword());
		} catch (NamingException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
		return result;
	}
}
