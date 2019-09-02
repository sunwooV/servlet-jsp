package guestBook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.NamingException;

import guestBook.dao.GuestBookDao;
import guestBook.model.GuestBook;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class EditService {
	private GuestBookDao guestBookDao = new GuestBookDao();

	public void edit(EditRequest editReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection(); 
			conn.setAutoCommit(false);

			String pageNum = editReq.getPageNum();
			String editId = editReq.getEditId();
			System.out.println(pageNum+","+editId);
//			articleReq.setTitle(req.getParameter("title"));
//			articleReq.setContent(req.getParameter("content"));
//			System.out.println("title:" + req.getParameter("title") + ",content" + req.getParameter("content") );
			
			//articleDao.editArticle(conn, new Article(editReq.getTitle()), new ArticleContent(editReq.getContent()));
			//conn.commit();
		} catch (NamingException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	
}
