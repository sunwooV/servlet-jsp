package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import article.dao.ArticleDAO;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class DelService {
	
	ArticleDAO articleDAO = new ArticleDAO();
	
	public void delete(int delId, int pageNum) {
		DelRequest delReq = new DelRequest();

		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection(); 
			conn.setAutoCommit(false);
			
			
			System.out.println("delete list=================");
			articleDAO.delArticle(conn, delId);

			System.out.println("delId :::: " + delId);
			
			delReq.setPageNum(pageNum);

			JdbcUtil.commit(conn);

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