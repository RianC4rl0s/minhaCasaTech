package br.com.minhaCasaTech.model.VO;

public class LocalVO {
	
	private String casa;
	private String compartimento;
	
	public LocalVO(String casa, String compartimento){
		this.setCasa(casa);
		this.setCompartimento(compartimento);
	}
	
	//Set
	
	public void setCasa(String casa) {
		if(casa ==null)
			System.out.println("Valor nulo!");
		else
			if(casa.equals(""))
				System.out.println("Nada escrito");
			else
				this.casa = casa;
	}
	
	public void setCompartimento(String compartimento) {
		if(compartimento==null)
			System.out.println("Valor nulo");
		else
			if(compartimento.equals(""))
				System.out.println("Nada escrito");
			else
				this.compartimento = compartimento;
	}
	
	//Get
	
	public String getCasa() {
		return casa;
	}
	
	public String getCompartimento() {
		return compartimento;
	}
	
	public String toString() {
		return
		"Casa: "+casa+"\n"+
		"Compartimento"+compartimento+"\n";
	}
}