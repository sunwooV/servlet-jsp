package article.model;

public class ArticleContent {
	static int cnt = 0;
	private int no;
	private String name;
	private String title;
	private String content;
	
	public ArticleContent(int no, String name, String title, String content) {
		this.no = no;
		this.name = name;
		this.title = title;
		this.content = content;
		cnt ++;
	}

	public ArticleContent(String content) {
		this.content = content;
	}
	
	public int getNo() {
		return no;
	}

	public String getContent() {
		return content;
	}

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}
	
	
}