package guestBook.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestBook.model.GuestBook;
import guestBook.service.EditRequest;
import guestBook.service.EditService;
import guestBook.service.GuestBookRequest;
import member.service.DuplicateIdException;
import mvc.command.CommandHandler;

public class EditHandler implements CommandHandler {

	private static final String FORM_VIEW = "/view/guestBookCheckForm.jsp";

	private EditService editService = new EditService();
	private EditRequest editReq = new EditRequest();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		editReq.setEditId(req.getParameter("messageId"));
		editReq.setMessagepassword(req.getParameter("messagepassword"));
		editReq.setName(req.getParameter("messagename"));
		editReq.setContent(req.getParameter("content"));
		
		req.setAttribute("editReq", editReq);
		
		System.out.println(req.getParameter("messageId")+req.getParameter("messagepassword") + " " + (req.getParameter("messagename") + " " + req.getParameter("content")));

		return FORM_VIEW;
	}
	
	


}
