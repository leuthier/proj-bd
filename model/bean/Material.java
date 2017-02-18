package model.bean;

public class Material {
	
	private String codMat; //Primary key
	private String descricao; //varchar100
	
	public String getCodMat() {
		return codMat;
	}
	public void setCodMat(String codMat) {
		this.codMat = codMat;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
