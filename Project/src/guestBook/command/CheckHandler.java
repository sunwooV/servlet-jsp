package guestBook.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestBook.service.DuplicateIdException;
import guestBook.service.EditRequest;
import guestBook.service.GuestBookRequest;
import guestBook.service.RealDelService;
import guestBook.service.RealEditService;
import guestBook.service.WriteService;
import mvc.command.CommandHandler;


public class CheckHandler implements CommandHandler {

	private static final String FORM_VIEW = "/view/editfail.jsp";
	


	public String process(HttpServletRequest req, HttpServletResponse res) {
		RealEditService realEditService = new RealEditService();
		EditRequest editReq = new EditRequest();

		String input_password = req.getParameter("password");
		
		editReq.setEditId(req.getParameter("messageid"));
		editReq.setMessagepassword(req.getParameter("messagepassword"));
		editReq.setName(req.getParameter("messagename"));
		editReq.setContent(req.getParameter("content"));
		//delReq.setPageNum(req.getParameter("pageNum"));
		
		System.out.println("checkHandler : " + input_password + req.getParameter("messageid")+req.getParameter("messagepassword"));
		
		try {
			if(realEditService.editCheck(editReq)) {
				return "/view/guestBookEditForm.jsp";
			}else {
				return "/view/editfail.jsp";
			}

			
		} catch (DuplicateIdException e) {
//			errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;

		}
	}
}
