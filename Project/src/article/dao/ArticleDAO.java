package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import article.model.Article;
import article.model.ArticleContent;
import jdbc.JdbcUtil;

public class ArticleDAO {
	

	public List listArticle(Connection conn, int firstRow, int endRow) throws SQLException { //게시물 리스트
		List<Article> list = new ArrayList();
		HttpSession session = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String query = "select * from (select rownum rnum, a.* from article a) where rnum >= ? and rnum <= ? order by article_no";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			System.out.println("query : " + query);
			Article article = null;
			while (rs.next()) {
				System.out.println("=====================");
				article = new Article(
						rs.getInt("article_no"),
						rs.getString("writer_id"), 
						rs.getString("writer_name"), 
						rs.getString("title"), 
						toDate(rs.getTimestamp("regdate")),
						toDate(rs.getTimestamp("moddate")),
						rs.getInt("read_cnt"));
				list.add(article);
				
			}

			return list;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			
		}
	}
	
	@SuppressWarnings("resource")
	public List listEach(Connection conn, int eachId) throws SQLException {
		
		List<ArticleContent> list = new ArrayList();

		PreparedStatement pstmt = null;

		ResultSet rs = null;
		try {
			String query = "select a.*, (select content from article_content ac where ac.article_no = a.article_no) content"
					+ " from article a"
					+ " where a.article_no = '" + eachId + "'";
			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery();
			System.out.println("query : " + query);
			
			while (rs.next()) {
				System.out.println("=====================");

				ArticleContent ac = new ArticleContent(
						rs.getInt("article_no"),
						rs.getString("writer_name"), 
						rs.getString("title"), 
						rs.getString("content"));
				list.add(ac);
				
				
			}

			String query2 = "update article set read_cnt = read_cnt + 1"
					+ " where article_no = '" + eachId + "'";
			pstmt = conn.prepareStatement(query2);

			pstmt.executeUpdate();
			System.out.println("query : " + query2);
			
			return list;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			
		}
		
	}
	
	public int totalArticle(Connection conn) throws SQLException { //게시물 리스트
		String total = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String query = "select count(*) as totalArticle from article";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			System.out.println("query : " + query);

			while (rs.next()) {
				System.out.println("=====================");
				total = rs.getString("totalArticle");

			}

			return Integer.parseInt(total);
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			
		}
	}

	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}

	@SuppressWarnings("resource")
	public void addArticle(Connection conn, Article article, ArticleContent articlecontent, String name, String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//String writer_id = article.getId();
			//String writer_name = article.getName();
//			String title = articlecontent.getContent();
			
	
			String origin = null;
			String writer_id = id;
			String writer_name = name;
			
			String query2 = "select article_no_seq.nextval article_no from dual";
			pstmt = conn.prepareStatement(query2);
			rs = pstmt.executeQuery();
			System.out.println("query222:" + query2);

			while(rs.next()) {
				origin = rs.getString("article_no");
				System.out.println(origin + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			
			}
			pstmt.clearParameters();

			System.out.println("ArticleDAO(addArticle) :" + writer_id + "/" + writer_name);
			
			String query = "insert into article "
					+ " (article_no, writer_id, writer_name, title, regdate, moddate, read_cnt) "
					+ " values ('" + origin + "', '" + writer_id + "','" + writer_name + "','" + article.getTitle() + "', sysdate,sysdate,0)";
			
		
			pstmt = conn.prepareStatement(query);
	
			pstmt.executeUpdate();
			System.out.println("article db:" + query);
			System.out.println("sysout 된다");
			System.out.println("제바라ㅏ라");
			
			pstmt.clearParameters();

			String query3 = "insert into article_content "
					+ " (article_no, content) "
					+ " values (?,?)";
			pstmt = conn.prepareStatement(query3);
			System.out.println("article_content:" + query3);
			pstmt.setInt(1, Integer.parseInt(origin));
			pstmt.setString(2, articlecontent.getContent());
			pstmt.executeUpdate();
			
			pstmt.clearParameters();
		
		}catch(Exception e) {
			e.getStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			
		}
	}
	
	
	public void editArticle(Connection conn, String title, String content, String pageNum, String editId) throws SQLException {
		PreparedStatement pstmt = null;
		try  { 
			System.out.println("확인완료");
			String query = "update article set title = '" + title + "', moddate = sysdate where article_no = '" + editId+"'";
			pstmt = conn.prepareStatement(query);
			System.out.println("editArticle-======"+ query);		

			pstmt.executeUpdate();
		
			String query2 = "update article_content set content = ? where article_no = ?";
			pstmt = conn.prepareStatement(query2);
			System.out.println("=======en"+ query2);
			pstmt.setString(1, content);
			pstmt.setInt(2, Integer.parseInt(editId));
			pstmt.executeUpdate();

		}catch(Exception e) {
			e.getStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			
		}
	}
	
	public void delArticle(Connection conn, int delId) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"delete from article where article_no = ?")) {
			pstmt.setInt(1, delId);

			pstmt.executeUpdate();
			
			String query = "delete from article_content where article_no = ?";
			pstmt.setInt(1, delId);
			pstmt.executeUpdate();
			System.out.println("query : " + query);
		}
	}
}
