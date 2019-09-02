package article.command;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import article.service.ListRequest;
import article.service.ListService;
import member.service.DuplicateIdException;
import member.service.LoginRequest;
import mvc.command.CommandHandler;

public class ListHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "/view/articleForm.jsp";
	private ListService listservice = new ListService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ParseException {


		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		String pageNum = (String)req.getParameter("pageNum");
		System.out.println(pageNum);


//		articleReq.validate(errors);
		HttpSession session = req.getSession();
		LoginRequest loginReq = (LoginRequest) session.getAttribute("loginReq");
		try {
			if(pageNum != null) { //paging 버튼 눌렀을 때
				System.out.println("page ::::::::::::::::::::::::::: 0xxx" );
				List list = listservice.list(Integer.parseInt(pageNum));
				int totalPage = listservice.totalPage();
				req.setAttribute("list", list);
				req.setAttribute("totalPage", totalPage);
				return "/view/articleForm.jsp";
			} else { //처음에 리스트 띄었을 때
				System.out.println("page ::::::::::::::::::::::::::: 0" );
				List list = listservice.list(1);
				int totalPage = listservice.totalPage();
				req.setAttribute("list", list);
				req.setAttribute("totalPage", totalPage);
				return "/view/articleForm.jsp";
			}
//			return null;
		} catch (DuplicateIdException e) {
			//errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}


	}

}