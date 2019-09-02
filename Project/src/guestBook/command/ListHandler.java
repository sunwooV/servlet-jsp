package guestBook.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import guestBook.service.GuestBookRequest;
import guestBook.model.GuestBook;
import guestBook.service.DuplicateIdException;
import guestBook.service.ListService;
import mvc.command.CommandHandler;

public class ListHandler implements CommandHandler {

	private static final String FORM_VIEW = "/view/guestBookForm.jsp";
	private ListService listservice = new ListService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		String pageNum = (String)req.getParameter("pageNum");
		System.out.println(pageNum);
		
		

//		articleReq.validate(errors);

		try {
			if(pageNum != null) { 
				System.out.println("page ::::::::::::::::::::::::::: 0xxx" );
				List list = listservice.list(Integer.parseInt(pageNum));
				int totalPage = listservice.totalPage();
				req.setAttribute("list", list);
				req.setAttribute("totalPage", totalPage);
				req.setAttribute("pageNum", pageNum);
				return "/view/guestBookForm.jsp";
			} else { 
				System.out.println("page ::::::::::::::::::::::::::: 0" );
				List list = listservice.list(1);
				int totalPage = listservice.totalPage();
				req.setAttribute("list", list);
				req.setAttribute("totalPage", totalPage);
				req.setAttribute("pageNum", pageNum);
				return "/view/guestBookForm.jsp";
			}
		} catch (DuplicateIdException e) {
			//errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		
		}
	}
}
