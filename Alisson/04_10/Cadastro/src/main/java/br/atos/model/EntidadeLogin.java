package br.atos.model;

public class EntidadeLogin {

	private String username;
	private String password;
	private String confirmarPassword;
	
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
	public String getConfirmarPassword() {
		return confirmarPassword;
	}
	public void setConfirmarPassword(String confirmarPassword) {
		this.confirmarPassword = confirmarPassword;
	}

}
