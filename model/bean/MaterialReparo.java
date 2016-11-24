package model.bean;

import java.sql.Date;


public class MaterialReparo {
	
	private int codCelular; //not null references Reparo(codCelular)
	private Date dataExecutada; //not null references Reparo(dataExecutada)
	private int codMat; //Primary key references Material(codMat)
	private int quantidade;

	
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
