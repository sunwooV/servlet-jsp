package practice0903;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet("/cus3")
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
		List customer = new ArrayList();
		List stateList = new ArrayList();
		List countryList = new ArrayList();
		String jsonInfo = null;
		
		JSONObject totalObject = new JSONObject();
		JSONArray customersArray = new JSONArray();
		JSONObject error = new JSONObject();
		JSONObject customerInfo = new JSONObject();
		
		String _id = (String)request.getParameter("_id"); //�˻��� ����ȣ
		String _command = (String)request.getParameter("command");
		
		vo.setSearchId(_id);
		
		System.out.println(_id + ", command = " + _command);
	
		if(_command.equals("before")) { //���� �� ��ȸ
			System.out.println("before ������");
			
			vo.setId((String)request.getParameter("id"));

			dao.before(vo);
			
			_command = "search";
		} else if(_command.equals("after")) { //���� �� ��ȸ
			System.out.println("after ������");
			
			vo.setId((String)request.getParameter("id"));

			dao.after(vo);
			
			_command = "search";
		}

		if(_command.equals("search")) { //��ȸ
			System.out.println("search������");
			
			customer = dao.customerList(vo);

			if(customer.size() == 0) { //�ش�� ����ȣ�� ���� ��
				error.put("error_yn", "Y");
				error.put("error_text", "���� �������� �ʽ��ϴ�.");
				
				totalObject.put("error", error);
				jsonInfo = totalObject.toJSONString();
				System.out.println("jsonInfo ::: " + jsonInfo);
				writer.print(jsonInfo);
				return;
			}
	
			customerInfo.put("id", ((Customer)customer.get(0)).getId());
			customerInfo.put("name", ((Customer)customer.get(0)).getName());
			customerInfo.put("address", ((Customer)customer.get(0)).getAddress());
			customerInfo.put("state", ((Customer)customer.get(0)).getState());
			customerInfo.put("zip", ((Customer)customer.get(0)).getZip());
			customerInfo.put("country", ((Customer)customer.get(0)).getCountry());
			customerInfo.put("contact", ((Customer)customer.get(0)).getContact());
			customerInfo.put("email", ((Customer)customer.get(0)).getEmail());
			
			customersArray.add(customerInfo);
			error.put("error_yn", "N");
			totalObject.put("error", error);
			
			totalObject.put("customers", customersArray);
			
			jsonInfo = totalObject.toJSONString();
			System.out.println("jsonInfo :::: " + jsonInfo);
			writer.print(jsonInfo); //JSON �����͸� �������� ����
			return;
		} else if(_command.equals("save")) {
			String id = (String)request.getParameter("id");
			String copyId = (String)request.getParameter("copyId"); //��ȸ �� �������� �߰����� �����ϱ� ����
	
			System.out.println("save ������");
			
			vo.setId((String)request.getParameter("id"));
			vo.setName((String)request.getParameter("name"));
			vo.setAddress((String)request.getParameter("address"));
			vo.setState((String)request.getParameter("state"));
			vo.setZip((String)request.getParameter("zip"));
			vo.setCountry((String)request.getParameter("country"));
			vo.setContact((String)request.getParameter("contact"));
			vo.setEmail((String)request.getParameter("email"));
			System.out.println(copyId);
			if(!id.equals(copyId)) { //�߰�
				dao.insert(vo);
			}
			else { //��ȸ �� ����
				dao.update(vo);
			}
		} else if(_command.equals("delete")) {
	
			System.out.println("delete ������");
			
			vo.setId((String)request.getParameter("id"));

			dao.delete(vo);
			
		}
		
	}

}
