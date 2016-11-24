package model.bean;

import java.sql.Date;

public class Reparo {

	private Date dataExecutada; //Primary key
    //codCelular not null - SMARTPHONE NAO DEVERIA SER PARAMETRO?
	private Date dataUltimoConserto;
	private int codCelular;
	//Foreign Key (codCelular) references Smartphone(codCelular)
	
	public Date getDataExecutada() {
		return dataExecutada;
	}
	public void setDataExecutada(Date dataExecutada) {
		this.dataExecutada = dataExecutada;
	}
	
	public int getCodCelular(){
		return codCelular;
	}
	public void setCodCelular(int codCelular) {
		this.codCelular = codCelular;
	}
	
	public Date getDataUltimoConserto() {
		return dataUltimoConserto;
	}
	public void setDataUltimoConserto(Date dataUltimoConserto) {
		this.dataUltimoConserto = dataUltimoConserto;
	}
	
}
