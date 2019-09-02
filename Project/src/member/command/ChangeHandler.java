package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.ChangeRequest;
import member.service.ChangeService;
import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import member.service.LoginRequest;
import mvc.command.CommandHandler;

public class ChangeHandler implements CommandHandler  {
	private static final String FORM_VIEW = "/view/changePw.jsp";
	private ChangeService changeService = new ChangeService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {

				return processSubmit(req, res);
	
	}
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		ChangeRequest changeReq = new ChangeRequest();//화면에 있는 data를 담아validation 처리할 객체
		LoginRequest loginReq = new LoginRequest();
		changeReq.setPassword(req.getParameter("password"));
		changeReq.setNewPwd(req.getParameter("newPwd"));
//		String id = loginReq.getId();
//		String name = loginReq.getName();
//		String password = loginReq.getPassword();
//		String p_password = req.getParameter("password");
//		String newPwd =req.getParameter("newPwd"); 
//		HttpSession session = req.getSession();
//		session.setAttribute(p_password, newPwd);
		
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		changeReq.validate(errors);


		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			changeService.change(changeReq,req, errors);
			System.out.println("11111ss");
			
			return "/view/loginSuccess.jsp";
		
		} catch (DuplicateIdException e) {
			errors.put("duplicateId", Boolean.TRUE);
			System.out.println("ff");
			return FORM_VIEW;
		}

	}	
}
