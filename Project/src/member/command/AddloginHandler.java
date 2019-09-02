package member.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDao;
import member.model.Member;
import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.LoginRequest;
import member.service.LoginService;
import mvc.command.CommandHandler;

public class AddloginHandler implements CommandHandler{
	
	private static final String FORM_VIEW = "/view/loginForm.jsp";
	private LoginService loginService = new LoginService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		LoginRequest loginReq = new LoginRequest();//화면에 있는 data를 담아validation 처리할 객체
		loginReq.setId(req.getParameter("id"));
		loginReq.setPassword(req.getParameter("password"));
	


		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		loginReq.validate(errors);

		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			loginService.login(loginReq,req, errors);
			HttpSession session = req.getSession();
			session.setAttribute("isLogn", true);
			session.setAttribute("loginReq", loginReq);	
			return "/view/loginSuccess.jsp";
		} catch (DuplicateIdException e) {
			errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}
	}
		
}
	

	

