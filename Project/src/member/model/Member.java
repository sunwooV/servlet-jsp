package member.model;

import java.util.Date;

public class Member {

	private String id;
	private String name;
	private String password;
	private String answer;
	private Date regDate;
	private String newPwd; //새로 바꿀 비번

	public Member(String id, String name,String answer ,String password, Date regDate) {//가입시사용
		this.id = id;
		this.name = name;
		this.password = password;
		this.answer=answer;
		this.regDate = regDate;

	}
	public Member(String id, String password) {//로그인
		this.id = id;
		this.password = password;
	}
	public Member(String id, String password,String newPwd) {//비밀번호 변경
		this.id = id;
		this.password = password;
		this.newPwd=newPwd;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
	public String getAnswer() {
		return answer;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	public String getNewPwd() {
		return newPwd;
	}
	
	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}

	public void changePassword(String newPwd) {
		this.password = newPwd;
	}

}