package article.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.DuplicateIdException;
import member.service.LoginRequest;
import article.service.AddRequest;
import article.service.AddService;
import article.service.ListService;
import mvc.command.CommandHandler;

public class AddHandler implements CommandHandler {

	private static final String FORM_VIEW = "list.do";
	private AddService articleService = new AddService();
	private ListService listservice = new ListService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		AddRequest articleReq = new AddRequest();
		articleReq.setTitle(req.getParameter("title"));
		articleReq.setContent(req.getParameter("content"));

		System.out.println("title:" + req.getParameter("title") + ",content" + req.getParameter("content") );
		HttpSession session = req.getSession();
		LoginRequest loginReq = (LoginRequest) session.getAttribute("loginReq");
		

		try {
			if(loginReq != null) {
				articleService.add(articleReq, loginReq); //게시글 쓰기 처리
			}
			List list = listservice.list(1);
			req.setAttribute("list", list);
			return "list.do";
		} catch (DuplicateIdException e) {
			//errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}
	}

}
