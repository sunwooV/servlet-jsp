package article.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.DuplicateIdException;
import article.service.AddRequest;
import article.service.AddService;
import mvc.command.CommandHandler;

public class WriteHandler implements CommandHandler {

	private static final String FORM_VIEW = "/view/addForm.jsp";
	private AddService articleService = new AddService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		AddRequest articleReq = new AddRequest();
		articleReq.setNo(req.getParameter("no"));
		articleReq.setTitle(req.getParameter("title"));


		System.out.println("=====WriteHandler======");
		return FORM_VIEW;

		
	}


}
