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
	public void setCodCelular(Reparo reparo) {
		this.codCelular = reparo.getCodCelular();
	}

	public Date getDataExecutada() {
		return dataExecutada;
	}
	public void setDataExecutada(Reparo reparo) {
		this.dataExecutada = reparo.getDataExecutada();
	}
	
	public int getCodMat() {
		return codMat;
	}
	public void setCodMat(Material material) {
		this.codMat = material.getCodMat();
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	
}
