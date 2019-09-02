package article.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.DuplicateIdException;
import article.service.AddRequest;
import article.service.AddService;
import article.service.RealEditRequest;
import article.service.RealEditService;
import article.service.ListService;
import mvc.command.CommandHandler;

public class RealEditHandler implements CommandHandler {

	private static final String FORM_VIEW = "list.do";

	private RealEditService realEditService = new RealEditService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		RealEditRequest realEditReq = new RealEditRequest();

		realEditReq.setTitle(req.getParameter("title"));
		realEditReq.setContent(req.getParameter("content"));
		realEditReq.setNo(req.getParameter("editId"));
		realEditReq.setPageNum(req.getParameter("pageNum"));

		System.out.println("title:" + req.getParameter("title") + ",content" + req.getParameter("content") + ",editId " + req.getParameter("editId") );

		try {
			realEditService.edit(realEditReq); //게시글 수정
			return FORM_VIEW;
		} catch (DuplicateIdException e) {
			//errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}
	}


}
