package guestBook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.RealEditService;
import guestBook.service.GuestBookRequest;
import mvc.command.CommandHandler;

public class RealEditHandler implements CommandHandler {

	private static final String FORM_VIEW = "/Project/guestBook/list.do";

	public String process(HttpServletRequest req, HttpServletResponse res) {
		RealEditService realEditService = new RealEditService();
		GuestBookRequest editReq = new GuestBookRequest();

		String input_password = req.getParameter("password");

		editReq.setId(req.getParameter("id"));
		editReq.setPassword(req.getParameter("messagepassword"));
		editReq.setName(req.getParameter("messagename"));
		editReq.setMessage(req.getParameter("content"));
		// delReq.setPageNum(req.getParameter("pageNum"));

		System.out.println("확인확인확인확인 ++++++++++++" + input_password + " " + req.getParameter("id") + " " + req.getParameter("password"));

		return FORM_VIEW;
	}

}
