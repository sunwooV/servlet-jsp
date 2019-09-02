package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import member.service.LoginRequest;
import member.service.LoginService;
import mvc.command.CommandHandler;

public class LoginHandler implements CommandHandler {
	private static final String FORM_VIEW = "/view/loginForm.jsp";
	private JoinService joinService = new JoinService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

}