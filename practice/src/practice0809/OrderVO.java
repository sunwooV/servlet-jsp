package practice0809;

public class OrderVO {
	private String num; //�ֹ���ȣ
	private String item; //�׸��ȣ
	private String prodId; //��ǰ��ȣ
	private String name; //��ǰ�̸�
	private String quantity; //���޾�ü��
	private String price;
	private String searchId;
	private String delId;
	private String editId;
	private String editProdId;
	
	public OrderVO(){
		System.out.println("VO ������ ȣ��");
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public String getDelId() {
		return delId;
	}

	public void setDelId(String delId) {
		this.delId = delId;
	}

	public String getEditId() {
		return editId;
	}

	public void setEditId(String editId) {
		this.editId = editId;
	}

	public String getEditProdId() {
		return editProdId;
	}

	public void setEditProdId(String editProdId) {
		this.editProdId = editProdId;
	}



}
