package model;

public class User {

	String id;
	String email, password;

	public User() {
	}

	public User(String id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		System.out.println("ID: " + id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
