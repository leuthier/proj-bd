package model.bean;

public class Cliente {
	
	private int id;
	private String cpf; //Primary key
	private String telefone; //varchar11
	private String nomeCli; //varchar100
	private String email; //varchar50
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String strCpf) {
		this.cpf = strCpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getNomeCli() {
		return nomeCli;
	}
	public void setNomeCli(String nomeCli) {
		this.nomeCli = nomeCli;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId(){
		return id;
	}
	public void setId(int id) {
		this.id = id;		
	}
	
	
	
}
