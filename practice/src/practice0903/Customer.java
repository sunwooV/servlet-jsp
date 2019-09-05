package practice0903;

public class Customer {
	private String id;
	private String name;
	private String address;
	private String state;
	private String zip;
	private String country;
	private String contact;
	private String email;
	
	public Customer(String id, String name, String address, String state, String zip, String country, String contact, String email) {
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

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public String getCountry() {
		return country;
	}

	public String getContact() {
		return contact;
	}

	public String getEmail() {
		return email;
	}
	
	
}
