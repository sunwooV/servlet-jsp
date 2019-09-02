package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.naming.NamingException;

import article.dao.ArticleDAO;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;


public class ListService {
	private static final int article_per_page = 10;
	private ArticleDAO articleDAO = new ArticleDAO();
	private static int totalPage;

	public List list(int pageNumber) {
		ListRequest listReq = new ListRequest();
		List listArticle = null;
		Connection conn = null;
		int currentPageNumber = pageNumber;
		try {

			conn = ConnectionProvider.getConnection(); 
			conn.setAutoCommit(false);
			
			int totalCount = articleDAO.totalArticle(conn);
			int firstRow = 0;
			int endRow = 0;
			
			if(totalCount > 0) {
				firstRow = (pageNumber - 1) * article_per_page + 1;
				endRow = firstRow + article_per_page - 1;
				System.out.println("list=================");
				listArticle = articleDAO.listArticle(conn, firstRow, endRow);
				if(totalCount % article_per_page == 0) {
					totalPage = totalCount / article_per_page;
				} else {
					totalPage = totalCount / article_per_page + 1;
				}
				System.out.println("pageCount :::: " + totalPage);
			} else {
				currentPageNumber = 0;
				listArticle = Collections.emptyList();
			}

			listReq.setEndRow(endRow);
			listReq.setFirstRow(firstRow);
			listReq.setArticle_per_page(article_per_page);
			listReq.setCurrentPageNumber(currentPageNumber);

			return listArticle;
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
	
	public int totalPage() {
		return totalPage;
	}
}