package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.NamingException;

import article.dao.ArticleDAO;
import article.model.*;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.service.LoginRequest;

public class AddService {
	private ArticleDAO articleDao = new ArticleDAO();

	public void add(AddRequest articleReq, LoginRequest loginReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection(); 
			conn.setAutoCommit(false);

			String title = articleReq.getTitle();
			String content = articleReq.getContent();
			System.out.println(title+","+content);
			
			String name = loginReq.getName();
			String id = loginReq.getId();
			
			articleDao.addArticle(conn, new Article(articleReq.getTitle()), new ArticleContent(articleReq.getContent()), name, id);
			conn.commit();
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
