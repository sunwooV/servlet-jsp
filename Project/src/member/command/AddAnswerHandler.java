package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.AnswerRequest;
import member.service.AnswerService;
import member.service.DuplicateIdException;
import mvc.command.CommandHandler;


public class AddAnswerHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "/view/answer.jsp";
	private AnswerService answerService = new AnswerService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
				return processSubmit(req, res);
	
	}
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		AnswerRequest answerReq = new AnswerRequest();//화면에 있는 data를 담아validation 처리할 객체
		answerReq.setId(req.getParameter("id"));
		answerReq.setAnswer(req.getParameter("answer"));
		System.out.println(req.getParameter("answer"));
	
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		answerReq.validate(errors);


		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			answerService.answer(answerReq, req, errors);	
			HttpSession session = req.getSession();
			session.setAttribute("answerReq", answerReq);
			return "/view/answerSuccess.jsp";
		} catch (DuplicateIdException e) {
			errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}

	}	
}

