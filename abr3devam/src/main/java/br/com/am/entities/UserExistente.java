package br.com.am.entities;

public class UserExistente {

	private String rm;
	private String email;
	
	public UserExistente(String rm, String email) {
		super();
		this.rm = rm;
		this.email = email;
	}
	public UserExistente() {
		super();
	}
	
	public String getRm() {
		return rm;
	}
	public void setRm(String rm) {
		this.rm = rm;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
