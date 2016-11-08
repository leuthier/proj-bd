package model.bean;

public class Material {
	
	private int codMat; //Primary key
	private String descricao; //varchar100
	
	public int getCodMat() {
		return codMat;
	}
	public void setCodMat(int codMat) {
		this.codMat = codMat;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
