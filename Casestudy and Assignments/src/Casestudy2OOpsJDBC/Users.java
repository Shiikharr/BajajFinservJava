package Casestudy2OOpsJDBC;

public class Users 
{
	String name;
	String password;
	String email;
	String address;
	
	public Users()
	{
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Users(String name, String password, String email, String address) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.address = address;
	}
	
}
