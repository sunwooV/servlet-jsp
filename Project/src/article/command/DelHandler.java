package article.command;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.DelService;
import article.service.EachService;
import member.service.DuplicateIdException;
import mvc.command.CommandHandler;

public class DelHandler implements CommandHandler {
	private static final String FORM_VIEW = "list.do";
	private DelService delService = new DelService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ParseException {

		System.out.println("del.do확인");
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		String delId = (String)req.getParameter("delId");
		String pageNum = (String)req.getParameter("pageNum");
		
		System.out.println("게시판 삭제 ID : " + delId);
		


		try {
			delService.delete(Integer.parseInt(delId), Integer.parseInt(pageNum));
	
			req.setAttribute("pageNum", pageNum);
			System.out.println("pageNum !!!!! " + pageNum);
			return FORM_VIEW;

		} catch (DuplicateIdException e) {
			//errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}


	}
}