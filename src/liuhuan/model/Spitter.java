package liuhuan.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spitter {
	
	private long id;
	@NotNull
	@Size( min = 2,max=30)
	private String firstName;
	
	@NotNull
	@Size( min = 2,max=30)
	private String lastName;
	
	
	@NotNull
	@Size( min = 5,max=15)
	private String username;
	
	@NotNull
	@Size( min = 5,max=25)
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb =  new StringBuilder();
		sb.append("firstName"+firstName);
		sb.append("\nlastName"+lastName);
		sb.append("\nusername"+username);
		sb.append("\npassword"+password);
		return sb.toString();
	}
	
}
