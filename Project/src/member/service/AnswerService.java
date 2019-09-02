package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class AnswerService {
	
	private MemberDao memberDao = new MemberDao();

	public void answer(AnswerRequest answerReq,HttpServletRequest req,Map<String, Boolean> errors) {

		Connection conn = null;
		HttpSession session = req.getSession();

			try {
				conn = ConnectionProvider.getConnection(); 
				conn.setAutoCommit(false);
				System.out.println("11111111111");

				Member member = memberDao.selectById(conn, answerReq.getId());
//				if (member != null) {
//					JdbcUtil.rollback(conn);
//					throw new DuplicateIdException();
//				}
				System.out.println("222222");
				memberDao.getanswerInfo(conn, new Member(answerReq.getId(),answerReq.getAnswer()), answerReq);
				
				boolean check = memberDao.answer(conn,answerReq);
				System.out.println("-----" + answerReq.getAnswer());
				check(errors, check, "check");
				if(!check) {
					JdbcUtil.rollback(conn);
					throw new DuplicateIdException();
					}
	
//				memberDao.changePwd(conn, new Member(loginReq.getId(), answerReq.getPassword(),answerReq.getNewPwd()));
//				conn.commit();
//				System.out.println(answerReq.getPassword());
				
			
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
		

	private void check(Map<String, Boolean> errors, boolean check, String fieldName) {
		if(!check) {
			errors.put(fieldName, Boolean.TRUE);
			throw new DuplicateIdException();
			}
		// TODO Auto-generated method stub
		
	}
}


		