package br.com.minhaCasaTech.model.VO;

public class Local {
	private String casa;
	private String compartimento;
	//Set
	public void setCasa(String casa) {
		if(casa ==null) {
			System.out.println("ValorNulo");
			
		}else {
			this.casa = casa;
		}
	}
	public void setCompartimento(String compartimento) {
		if(compartimento==null) {
			System.out.println("ValorNulo");
			
		}else {
			this.compartimento= compartimento;
		}
	}
	//Get
	public String getCasa() {
		return casa;
	}
	public String getCompartimento() {
		return compartimento;
	}
}
