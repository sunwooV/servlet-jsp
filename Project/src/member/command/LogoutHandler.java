package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.JoinService;
import mvc.command.CommandHandler;

public class LogoutHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "index.jsp";


	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		session.invalidate();
		return FORM_VIEW;
	}
}
