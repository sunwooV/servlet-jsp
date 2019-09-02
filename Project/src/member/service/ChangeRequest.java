package member.service;

import java.util.Map;

public class ChangeRequest {
	private String id;
	private String name;
	private String password;
	private String newPwd;


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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	
	public boolean isPasswordEqualToConfirm() {
		return password != null && password.equals(newPwd);
	}
	
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, password, "password");
		checkEmpty(errors, newPwd, "newPwd");
		if (!errors.containsKey("newPwd")) {
			if (isPasswordEqualToConfirm()) {
				errors.put("Match", Boolean.TRUE);
			}
		}
	}

	
	private void checkEmpty(Map<String, Boolean> errors, 
			String value, String fieldName) {
		if (value == null || value.isEmpty())
			errors.put(fieldName, Boolean.TRUE);
		}
	}


