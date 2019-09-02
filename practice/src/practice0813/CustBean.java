package practice0813;

public class CustBean {
	private String id; //고객번호
	private String name; //고객이름
	private String address; //고객주소
	private String state; //고객 주
	private String zip; //고객 우편번호
	private String country; //고객 국가
	private String contact; //고객 담당자
	private String email; //고객 메일 주소
	private String searchId; //조회시 입력한 고객번호
	private String editId; //수정할 고객번호
	private String command;
	
	public CustBean(){
		
	}
	
	public CustBean(String searchId){
		this.searchId = searchId;
	}
	
	public CustBean(String id, String name, String address, String state, String zip, String country, String contact, String email){
		this.id = id;
		this.name = name;
		this.address = address;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.contact = contact;
		this.email = email;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public String getEditId() {
		return editId;
	}

	public void setEditId(String editId) {
		this.editId = editId;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}
	
}
