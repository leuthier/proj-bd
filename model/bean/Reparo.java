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
	public void setCodCelular(Smartphone smartphone) {
		this.codCelular = smartphone.getCodCelular();
	}
	
	
	public Date getDataUltimoConserto() {
		return dataUltimoConserto;
	}
	public void setDataUltimoConserto(Date dataUltimoConserto) {
		this.dataUltimoConserto = dataUltimoConserto;
	}
	
}
