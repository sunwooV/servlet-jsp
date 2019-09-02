package util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.Member;
import member.service.LoginRequest;

/**
 * Servlet Filter implementation class loginCheck
 */
@WebFilter("/article/*")
public class loginCheck implements Filter {

	
//	public loginCheck(){
//		whiteList = new ArrayList();
//		whiteList.add("/");
//		whiteList.add("/")
//	}
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter ȣ��");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		
		LoginRequest loginReq = (LoginRequest) session.getAttribute("loginReq");
		if(loginReq == null) {//�α��� ���Ѱ�
			System.out.println("�α��� ���߾�!!!");
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect("/Project/view/loginForm.jsp");

		}else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
