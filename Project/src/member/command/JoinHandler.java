package member.command;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import mvc.command.CommandHandler;

public class JoinHandler implements CommandHandler {

	private static final String FORM_VIEW = "/view/joinForm.jsp";
	private JoinService joinService = new JoinService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {

			return processForm(req, res);
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

//	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
//		JoinRequest joinReq = new JoinRequest();//화면에 있는 data를 담아validation 처리할 객체
//		joinReq.setId(req.getParameter("id"));
//		joinReq.setName(req.getParameter("name"));
//		joinReq.setPassword(req.getParameter("password"));
//		joinReq.setConfirmPassword(req.getParameter("confirmPassword"));
//
//		Map<String, Boolean> errors = new HashMap<>();
//		req.setAttribute("errors", errors);
//
//		joinReq.validate(errors);
//
//		if (!errors.isEmpty()) {
//			return FORM_VIEW;
//		}
//
//		try {
//			joinService.join(joinReq);
//			return "/view/joinSuccess.jsp";
//		} catch (DuplicateIdException e) {
//			errors.put("duplicateId", Boolean.TRUE);
//			return FORM_VIEW;
//		}
//	}

}