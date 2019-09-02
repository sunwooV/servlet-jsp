package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.NamingException;

import article.dao.ArticleDAO;
import article.model.*;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class RealEditService {
	private ArticleDAO articleDao = new ArticleDAO();

	public void edit(RealEditRequest realEditReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection(); 
			conn.setAutoCommit(false);


			String title = realEditReq.getTitle();
			String content = realEditReq.getContent();
			String pageNum = realEditReq.getPageNum();
			String editId = realEditReq.getNo();
			
			System.out.println(title+","+content +"," + pageNum + "," + editId);
//			articleReq.setTitle(req.getParameter("title"));
//			articleReq.setContent(req.getParameter("content"));
//			System.out.println("title:" + req.getParameter("title") + ",content" + req.getParameter("content") );
			
			articleDao.editArticle(conn, title, content, pageNum, editId);
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
