package article.command;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.EachService;
import member.service.DuplicateIdException;
import mvc.command.CommandHandler;

public class EachHandler implements CommandHandler {
	private static final String FORM_VIEW = "/view/eachForm.jsp";
	private EachService eachService = new EachService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ParseException {


		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		String eachId = (String)req.getParameter("eachId");
		System.out.println("게시판 세부 조회 ID : " + eachId);


		try {
			List list = eachService.list(Integer.parseInt(eachId));
			req.setAttribute("eachList", list);
			req.setAttribute("eachId", eachId);
			System.out.println("eachId !!!!! " + eachId);
			return FORM_VIEW;

		} catch (DuplicateIdException e) {
			//errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}


	}
}