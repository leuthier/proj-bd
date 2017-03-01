package model.bean;

import java.sql.Date;


public class MaterialReparo {
	
	private String codCelular; //not null references Reparo(codCelular)
	private Date dataExecutada; //not null references Reparo(dataExecutada)
	private String codMat; //Primary key references Material(codMat)
	private int quantidade;

	
	public String getCodCelular() {
		return codCelular;
	}
	public void setCodCelular(String codCelular) {
		this.codCelular = codCelular;
	}

	public Date getDataExecutada() {
		return dataExecutada;
	}
	public void setDataExecutada(Date dataExecutada) {
		this.dataExecutada = dataExecutada;
	}
	
	public String getCodMat() {
		return codMat;
	}
	public void setCodMat(String codMat) {
		this.codMat = codMat;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	
}
