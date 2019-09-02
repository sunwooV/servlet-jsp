package practice0819;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Management
 */
@WebServlet("/management")
public class Management extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		String command=request.getParameter("command"); //login or join
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		 
		if(command!=null && command.equals("join")) { //회원 가입 창에서 가입 버튼
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			
//			System.out.println(id + " " + pwd + " " + name);
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setName(name);
			
			dao.addMember(vo);
			
			response.sendRedirect("/practice/0819/first.jsp");
			
		} else if(command!=null && command.equals("login")) { //로그인 창에서 로그인 버튼
			String user_id = request.getParameter("user_id");
			String user_pwd = request.getParameter("user_pwd");
			
			vo.setUser_id(user_id);
			vo.setUser_pwd(user_pwd);
			int result = dao.checkMember(vo);
			
			System.out.println("******************************" + result);
			if(result == 1) { //id, pwd 일치
				session.setAttribute("name", vo.getName());
				session.setAttribute("id", user_id);
				response.sendRedirect("/practice/0819/show.jsp");
			} else { //id, pwd 불일치
				response.sendRedirect("/practice/0819/retry.jsp");
			}
		} else if(command!=null && command.equals("change")){ //비밀번호 변경 버튼
			String id = (String) session.getAttribute("id");
			String pwd = request.getParameter("pwd");
			String newPwd = request.getParameter("newPwd");
			
			vo.setUser_id(id);
			vo.setUser_pwd(pwd);
			vo.setNewPwd(newPwd);
			
			int result = dao.checkMember(vo);
			if(result == 1) { //id, pwd 일치
				dao.editMember(vo);
				session.invalidate(); //세션 삭제 -> 초기 화면
				response.sendRedirect("/practice/0819/first.jsp");
			} else { //id, pwd 불일치
				response.sendRedirect("/practice/0819/change.jsp");
			}
			
		} else { //로그아웃 버튼 누르면
			session.invalidate(); //세션 삭제
			response.sendRedirect("/practice/0819/first.jsp");
		}
	}

}
