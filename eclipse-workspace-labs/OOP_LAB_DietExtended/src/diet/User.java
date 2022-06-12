package diet;


public class User {
	private String Fname;
	private String Lname;
	private String email;
	private String phoneNum;

	
	public User(String fname, String lname) {
		Fname = fname;
		Lname = lname;
		
	}

	public String getLastName() {
		return Lname;
	}
	
	public String getFirstName() {
		return Fname;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phoneNum;
	}
	
	public void SetEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phoneNum = phone;
	}
	
	public String toString() {
		return Fname + " " + Lname;
	}
}
