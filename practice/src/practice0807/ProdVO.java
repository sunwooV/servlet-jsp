package practice0807;

public class ProdVO {
	private String id; //��ǰ��ȣ
	private String name; //��ǰ��
	private String price; //��ǰ����
	private String desc; //��ǰ����
	private String vendNm; //���޾�ü��
	private String searchId;
	private String searchVendId;
	private String delId;
	
	public ProdVO(){
		System.out.println("VO ������ ȣ��");
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getVendNm() {
		return vendNm;
	}
	public void setVendNm(String vendNm) {
		this.vendNm = vendNm;
	}
	public String getSearchId() {
		return searchId;
	}
	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}
	public String getSearchVendId() {
		return searchVendId;
	}
	public void setSearchVendId(String searchVendId) {
		this.searchVendId = searchVendId;
	}

	public String getDelId() {
		return delId;
	}

	public void setDelId(String delId) {
		this.delId = delId;
	}
	

}
