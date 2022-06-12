package delivery;

public class Customer {
	private int id;
	private String name;
	private String address;
	private String tel;
	private String email;
	private double total;
	
	
	public Customer(int id,
			String name, 
			String address, 
			String tel, 
			String email) {
		
		
		this.id = id;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.total =0 ;
	}
	
	
	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getAddress() {
		return address;
	}


	public String getTel() {
		return tel;
	}


	public String getEmail() {
		return email;
	}


	@Override
	public String toString() {
		return name + ", " + address + ", " + tel + ", " + email;
	}
	
	public void addToTotal(double amount) {
		this.total += amount;
	}
	public double getTotal() {
		return this.total;
	}
	
}
