package model.bean;

public class Smartphone {

	private String codCelular; //Primary Key
	private String numSerie; //varchar 5
	private String modelo; //varchar20
	private String marca; //tamanho10
	private String cor; //varchar10
	private String cpfCliente;
	//Foreign Key (cpf) references Cliente(cpf)
	
	public String getCodCelular() {
		return codCelular;
	}
	public void setCodCelular(String codCelular) {
		this.codCelular = codCelular;
	}
	
	public String getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public String getCpf() {
		return cpfCliente;
	}
	public void setCpf(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
		
}
