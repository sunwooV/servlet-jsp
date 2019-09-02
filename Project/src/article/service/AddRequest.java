package article.service;

import java.util.Date;
import java.util.Map;

public class AddRequest {
	private String no;
	private String content;
	private String id;
	private String name;
	private String title;
	private Date regDate;
	private Date modDate;
	private String cnt;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}


//	public void validate(Map<String, Boolean> errors) {
//		checkEmpty(errors, id, "id");
//		checkEmpty(errors, name, "name");
//		checkEmpty(errors, password, "password");
//		checkEmpty(errors, confirmPassword, "confirmPassword");
//		if (!errors.containsKey("confirmPassword")) {
//			if (!isPasswordEqualToConfirm()) {
//				errors.put("notMatch", Boolean.TRUE);
//			}
//		}
//	}
//
//	private void checkEmpty(Map<String, Boolean> errors, 
//			String value, String fieldName) {
//		if (value == null || value.isEmpty())
//			errors.put(fieldName, Boolean.TRUE);
//	}
}
