package model.bean;

public class Smartphone {

	private int codCelular; //Primary Key
	private int numSerie; //int
	private String modelo; //varchar20
	private String marca; //tamanho10
	private String cor; //varchar10
	private int cpfCliente;
	//Foreign Key (cpf) references Cliente(cpf)
	
	public int getCodCelular() {
		return codCelular;
	}
	public void setCodCelular(int codCelular) {
		this.codCelular = codCelular;
	}
	
	public int getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(int numSerie) {
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
	
	public int getCpf() {
		return cpfCliente;
	}
	public void setCpf(int cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
		
}
