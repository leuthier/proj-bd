package model.bean;

import java.sql.Date;

public class MaterialReparo {
	
	private int codCelular; //not null
	private Date dataExecutada; //not null
	private int codMat; //Primary key
	private int quantidade;
	//Foreign Key (codCelular, dataExecutada) references Reparo(codCelular, dataExecutada),
	//Foreign Key (codMat) references Material(codMat)
	
	public int getCodCelular() {
		return codCelular;
	}
	public void setCodCelular(int codCelular) {
		this.codCelular = codCelular;
	}
	public Date getDataExecutada() {
		return dataExecutada;
	}
	public void setDataExecutada(Date dataExecutada) {
		this.dataExecutada = dataExecutada;
	}
	public int getCodMat() {
		return codMat;
	}
	public void setCodMat(int codMat) {
		this.codMat = codMat;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
