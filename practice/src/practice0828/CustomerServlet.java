package practice0828;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/cus")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doHandle(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doHandle(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		CustomerDAO dao = new CustomerDAO();
		CustomerVO vo = new CustomerVO();
		Customer customer;
		
		JSONObject totalObject = new JSONObject();
		JSONArray customersArray = new JSONArray();
		JSONObject customerInfo = new JSONObject();
		
		String _id = (String)request.getParameter("id");
		System.out.println(_id);
		vo.setId(_id);
		customer = dao.customerList(vo);
		
		
		
		customerInfo.put("id", customer.getId());
		customerInfo.put("name", customer.getName());
		customerInfo.put("address", customer.getAddress());
		customerInfo.put("state", customer.getState());
		customerInfo.put("zip", customer.getZip());
		customerInfo.put("country", customer.getCountry());
		customerInfo.put("contact", customer.getContact());
		customerInfo.put("email", customer.getEmail());
		
		customersArray.add(customerInfo);
		
		totalObject.put("customers", customersArray);
		
		String jsonInfo = totalObject.toJSONString();
		System.out.println("jsonInfo :::: " + jsonInfo);
		writer.print(jsonInfo); //JSON 데이터를 브라우저로 전송
	}

}
