package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet1
 */
@WebServlet("/login10")
public class LoginServlet extends HttpServlet {
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
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		MemberVO vo = new MemberVO();
		vo.setId(user_id);
		vo.setPwd(user_pwd);
		MemberDAO dao = new MemberDAO();
		boolean result = dao.isExisted(vo); //MemberDAO�� isExisted() �޼��带 ȣ���ϸ鼭 MemberVO�� �����մϴ�.
		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogon", true); //��ȸ�� ����� true�̸� isLogOn �Ӽ��� true�� ���ǿ� ����
			session.setAttribute("login.id", user_id); //��ȸ�� ����� true�� ID�� ��й�ȣ�� ���ǿ� ����
			session.setAttribute("login.pwd", user_pwd);
			out.print("<html><body>");
			out.print("�ȳ��ϼ��� " + user_id + " ��!!!!<br>");
			out.print("<a href='show2'>ȸ������ ����</a>");
			out.print("</body></html>");
			
		} else {
			out.print("<html><body><center>ȸ�� ���̵� Ʋ���ϴ�.");
			out.print("<a href='login3.html'>�ٽ� �α����ϱ�</a>");
			out.print("</body></html>");
		}
	}

}
