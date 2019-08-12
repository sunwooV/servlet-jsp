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
 * Servlet implementation class ShowMember
 */
@WebServlet("/show2")
public class ShowMember extends HttpServlet {
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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = "", pwd = "";
		Boolean isLogon=false;
		HttpSession session = request.getSession(false); //�̹� ������ �����ϸ� ������ ��ȯ, ������ null�� ��ȯ
		if(session != null) { //���� ������ �����Ǿ� �ִ��� Ȯ��
			isLogon = (Boolean)session.getAttribute("isLogon"); //isLogon �Ӽ��� ������ �α��� ���¸� Ȯ��
			if(isLogon==true) {
				id = (String)session.getAttribute("login.id");
				pwd = (String)session.getAttribute("login.pwd");
				out.print("<html><body>");
				out.print("���̵� : " + id + "<br>");
				out.print("��й�ȣ : " + pwd + "<br>");
				out.print("</body></html>");
			} else { //�α��� ���°� �ƴϸ�
				response.sendRedirect("login3.html");
			}
		} else { //������ �������� �ʾ����� �α��� â���� �̵�
			response.sendRedirect("login3.html");
		}
	}

}
