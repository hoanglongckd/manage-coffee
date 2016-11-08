package bean;

public class LoginedAccount {
	private String username;
	private String key;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public LoginedAccount(String username, String key) {
		super();
		this.username = username;
		this.key = key;
	}

}
