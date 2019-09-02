package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class PasswordChangeHandler implements CommandHandler {
	private static final String FORM_VIEW = "/view/changePw.jsp";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {

			return processForm(req, res);
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

}
