package member.model;

import java.util.Date;

public class Member {

	private String id;
	private String name;
	private String password;
	private String answer;
	private Date regDate;
	private String newPwd; //���� �ٲ� ���

	public Member(String id, String name,String answer ,String password, Date regDate) {//���Խû��
		this.id = id;
		this.name = name;
		this.password = password;
		this.answer=answer;
		this.regDate = regDate;

	}
	public Member(String id, String password) {//�α���
		this.id = id;
		this.password = password;
	}
	public Member(String id, String password,String newPwd) {//��й�ȣ ����
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