package article.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.DuplicateIdException;
import article.service.AddRequest;
import article.service.AddService;
import article.service.EditRequest;
import article.service.EditService;
import article.service.RealEditRequest;
import article.service.RealEditService;
import article.service.ListService;
import mvc.command.CommandHandler;

public class EditHandler implements CommandHandler {

	private static final String FORM_VIEW = "/view/editForm.jsp";

	private EditService editService = new EditService();
	private EditRequest editReq = new EditRequest();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		editReq.setEditId(req.getParameter("editId"));
		editReq.setPageNum(req.getParameter("pageNum"));
		
		System.out.println("log ----- " + req.getParameter("editId") + "           " + req.getParameter("pageNum"));
		return FORM_VIEW;
	}


}
