package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.AnswerService;
import mvc.command.CommandHandler;

public class AnswerHandler implements CommandHandler {

	private static final String FORM_VIEW = "/view/answer.jsp";
	private AnswerService answerService = new AnswerService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {

			return processForm(req, res);
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

}
