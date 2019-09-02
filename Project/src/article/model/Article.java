package article.model;

import java.util.Date;

public class Article {
	private int no;
	private String id;
	private String name;
	private String title;
	private Date regDate;
	private Date modDate;
	private int cnt;
	
	public Article(int no, String id, String name, String title, Date regDate, Date modDate, int cnt) {
		this.no = no;
		this.id = id;
		this.name = name;
		this.title = title;
		this.regDate = regDate;
		this.modDate = modDate;
		this.cnt = cnt;
	}
	
	public int getNo() {
		return no;
	}

	
	public Article(String title) {
		this.title = title;
	}

	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public Date getRegDate() {
		return regDate;
	}

	public Date getModDate() {
		return modDate;
	}
	
	public int getCnt() {
		return cnt;
	}
	
	
}