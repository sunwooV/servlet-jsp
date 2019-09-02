package article.service;

public class RealEditRequest {
	private String no;
	private String title;
	private String content;
	private String pageNum;

	public String getContent() {
		return content;
	}

	public String getTitle() {
		return title;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	
}
