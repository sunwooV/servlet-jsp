package sec01.ex01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet("/download.do")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
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
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String file_repo = "C:\\file_repo";
		String fileName = (String)request.getParameter("fileName"); //�Ű������� ���۵� ���� �̸��� �о�´�.
		System.out.println("fileName=" + fileName);
		OutputStream out = response.getOutputStream(); //response���� OutputStream ��ü�� �����´�.
		String downFile = file_repo + "\\" + fileName;
		File f = new File(downFile);
		response.setHeader("Cache-Control", "no-cache"); //������ �ٿ�ε��� �� �ִ�.
		response.addHeader("content-disposition", "attachment; fileName = " + fileName);
		FileInputStream in = new FileInputStream(f);
		byte[] buffer = new byte[1024*8]; //���� ����� �̿��� ���Ͽ��� ���۷� �����͸� �о�� �Ѳ����� ����Ѵ�.
		while(true) {
			int count = in.read(buffer);
			if(count==-1) break;
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
		
	}

}
