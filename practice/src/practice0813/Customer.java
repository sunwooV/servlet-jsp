package practice0813;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import practice0809.OrderDAO;
import practice0809.OrderVO;

/**
 * Servlet implementation class Customer
 */
@WebServlet("/customer")
public class Customer extends HttpServlet {
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
		CustBean vo = new CustBean();
		CustDAO dao = new CustDAO();
		List list = null;
		
		String command = request.getParameter("command");
		String searchId = request.getParameter("searchId");
		vo.setSearchId(searchId);

		
		if(command != null && command.equals("search")) { //조회 버튼
			
			request.setAttribute("command", "search");
			request.setAttribute("searchId", searchId);
	
			RequestDispatcher dispatcher = request.getRequestDispatcher("0813/lookCust.jsp");
			dispatcher.forward(request, response);
			
		} else if (command != null && command.equals("add")){ //추가버튼
	
			
			request.setAttribute("command", "add");

			RequestDispatcher dispatcher = request.getRequestDispatcher("0813/manageCust.jsp");
			dispatcher.forward(request, response);
			
		} else if(command != null && command.equals("edit")){ //수정 버튼


			request.setAttribute("command", "edit");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("0813/manageCust.jsp");
			dispatcher.forward(request, response);
		}	

	}
}
