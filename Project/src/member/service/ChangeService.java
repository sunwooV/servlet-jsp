package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class ChangeService {

	private MemberDao memberDao = new MemberDao();

	public void change(ChangeRequest changeReq,HttpServletRequest req,Map<String, Boolean> errors) {

		Connection conn = null;
		HttpSession session = req.getSession();
		boolean isLogn = (boolean)session.getAttribute("isLogn");
		if(isLogn) {
			try {
				conn = ConnectionProvider.getConnection(); 
				conn.setAutoCommit(false);
		
				LoginRequest loginReq = (LoginRequest) session.getAttribute("loginReq");

				Member member = memberDao.selectById(conn, changeReq.getId());
				if (member != null) {
					JdbcUtil.rollback(conn);
					throw new DuplicateIdException();
				}
				
				boolean check = memberDao.isExisted(conn, new Member(loginReq.getId(),changeReq.getPassword()));
				check(errors, check, "check");
				if(!check) {
					JdbcUtil.rollback(conn);
					throw new DuplicateIdException();
				}
				
				memberDao.changePwd(conn, new Member(loginReq.getId(), changeReq.getPassword(),changeReq.getNewPwd()));
				conn.commit();
				System.out.println(changeReq.getPassword());
				
			
//				session.setAttribute("isLogn", true);
//				session.setAttribute("changeReq", changeReq);
//				session.setAttribute("loginReq.getId()", loginReq.getId());
				
				
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

	private void check(Map<String, Boolean> errors, boolean check, String fieldName) {
		if(!check) {
			errors.put(fieldName, Boolean.TRUE);
			throw new DuplicateIdException();
			}
		// TODO Auto-generated method stub
		
	}

}
