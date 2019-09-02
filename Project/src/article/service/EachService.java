package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.naming.NamingException;

import article.dao.ArticleDAO;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class EachService {
	private ArticleDAO articleDAO = new ArticleDAO();


	public List list(int eachId) {
		EachRequest eachReq = new EachRequest();
		List listEach = null;
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection(); 
			conn.setAutoCommit(false);
			
			
			System.out.println("each list=================");
			listEach = articleDAO.listEach(conn, eachId);

			System.out.println("eachId :::: " + eachId);
			

			eachReq.setNo(eachId);

			JdbcUtil.commit(conn);
			return listEach;
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