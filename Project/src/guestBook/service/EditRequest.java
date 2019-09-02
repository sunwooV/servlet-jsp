package guestBook.service;

public class EditRequest {
	private String pageNum;
	private String editId;
	private String messagepassword;
	private String name;
	private String content;
	
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public String getEditId() {
		return editId;
	}
	public void setEditId(String editId) {
		this.editId = editId;
	}
	public String getMessagepassword() {
		return messagepassword;
	}
	public void setMessagepassword(String messagepassword) {
		this.messagepassword = messagepassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	

}
