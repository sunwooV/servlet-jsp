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
		System.out.println("doFilter 호출");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		
		LoginRequest loginReq = (LoginRequest) session.getAttribute("loginReq");
		if(loginReq == null) {//로그인 안한거
			System.out.println("로그인 안했어!!!");
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
