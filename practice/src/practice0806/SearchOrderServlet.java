package practice0806;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchOrderServlet
 */
@WebServlet("/search2")
public class SearchOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

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
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		SearchDAO dao = new SearchDAO();
		String command = request.getParameter("command");
		List list = null;
		
		
		if(command != null && command.equals("delOrder")) {
			String num = request.getParameter("order_num");
			String name = request.getParameter("prod_id");
			dao.delOrder(num, name);
		}
		
		String id2 = request.getParameter("searchid");
		list = dao.searchOrder(id2);

		
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightyellow'>");
		out.print("<td>�ֹ���ȣ</td><td>��ǰ��</td><td>�׸����</td><td>�׸񰡰�</td><td>����</td></tr>");
		
		for(int i=0;i<list.size();i++) {
			SearchVO searchVO = (SearchVO)list.get(i);
			String order_num = searchVO.getOrder_num();
			String prod_id = searchVO.getProd_id();
			String prod_name = searchVO.getProd_name();
			String quantity = searchVO.getQuantity();
			String price = searchVO.getPrice();
			out.print("<tr><td>" + order_num + "</td><td>" + prod_name + "</td><td>" + quantity + "</td><td>" + price + "</td><td>" + "<a href='/practice/search2?command=delOrder&order_num=" + order_num + "&prod_id=" + prod_id + "&searchid=" + id2 + "'> ���� </a></td></tr>");
		}
		
		out.print("</table></body></html>");
		out.print("<a href='/practice/search.html'>���ο� �� ��ȸ�ϱ�</a>");
		

	}
}
