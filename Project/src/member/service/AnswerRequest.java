package member.service;

import java.util.Map;

public class AnswerRequest {

	private String id;
	private String password;
	private String answer;

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, id, "id");
		checkEmpty(errors, answer, "answer");
//		if (!errors.containsKey("newPwd")) {
//			if (isPasswordEqualToConfirm()) {
//				errors.put("Match", Boolean.TRUE);
//			}
//		}
	}

	
	private void checkEmpty(Map<String, Boolean> errors, 
			String value, String fieldName) {
		if (value == null || value.isEmpty())
			errors.put(fieldName, Boolean.TRUE);
		}
	}