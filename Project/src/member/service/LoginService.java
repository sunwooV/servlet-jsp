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

public class LoginService {

		private MemberDao memberDao = new MemberDao();

		public void login(LoginRequest loginReq,HttpServletRequest req, Map<String, Boolean> errors) {
	
			Connection conn = null;
	
			try {
				conn = ConnectionProvider.getConnection(); 
				conn.setAutoCommit(false);

				Member member = memberDao.selectById(conn, loginReq.getId());
				memberDao.getMemberInfo(conn, new Member(loginReq.getId(),loginReq.getPassword()), loginReq );
				
				boolean checklog = memberDao.isExisted(conn, new Member(loginReq.getId(),loginReq.getPassword()));
				check(errors, checklog, "checklog");
				if(!checklog) {
					JdbcUtil.rollback(conn);
					throw new DuplicateIdException();
				}
			
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

		private void check(Map<String, Boolean> errors, boolean checklog, String fieldName) {
			if(!checklog) {
				errors.put(fieldName, Boolean.TRUE);
				throw new DuplicateIdException();
				}
			}
		}


			


