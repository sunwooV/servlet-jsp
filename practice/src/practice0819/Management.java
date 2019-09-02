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
		 
		if(command!=null && command.equals("join")) { //ȸ�� ���� â���� ���� ��ư
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			
//			System.out.println(id + " " + pwd + " " + name);
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setName(name);
			
			dao.addMember(vo);
			
			response.sendRedirect("/practice/0819/first.jsp");
			
		} else if(command!=null && command.equals("login")) { //�α��� â���� �α��� ��ư
			String user_id = request.getParameter("user_id");
			String user_pwd = request.getParameter("user_pwd");
			
			vo.setUser_id(user_id);
			vo.setUser_pwd(user_pwd);
			int result = dao.checkMember(vo);
			
			System.out.println("******************************" + result);
			if(result == 1) { //id, pwd ��ġ
				session.setAttribute("name", vo.getName());
				session.setAttribute("id", user_id);
				response.sendRedirect("/practice/0819/show.jsp");
			} else { //id, pwd ����ġ
				response.sendRedirect("/practice/0819/retry.jsp");
			}
		} else if(command!=null && command.equals("change")){ //��й�ȣ ���� ��ư
			String id = (String) session.getAttribute("id");
			String pwd = request.getParameter("pwd");
			String newPwd = request.getParameter("newPwd");
			
			vo.setUser_id(id);
			vo.setUser_pwd(pwd);
			vo.setNewPwd(newPwd);
			
			int result = dao.checkMember(vo);
			if(result == 1) { //id, pwd ��ġ
				dao.editMember(vo);
				session.invalidate(); //���� ���� -> �ʱ� ȭ��
				response.sendRedirect("/practice/0819/first.jsp");
			} else { //id, pwd ����ġ
				response.sendRedirect("/practice/0819/change.jsp");
			}
			
		} else { //�α׾ƿ� ��ư ������
			session.invalidate(); //���� ����
			response.sendRedirect("/practice/0819/first.jsp");
		}
	}

}
