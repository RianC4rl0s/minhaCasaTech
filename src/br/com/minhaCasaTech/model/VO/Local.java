package br.com.minhaCasaTech.model.VO;

public class Local {
	private String casa;
	private String compartimento;
	//Set
	public void setCasa(String casa) {
		if(casa ==null) {
			System.out.println("ValorNulo");
			
		}else {
			if(casa.equals("")) {
				System.out.println("Nada escrito");
				this.casa = "NADA";
			}else {
			this.casa = casa;
			}
		
		}
	}
	public void setCompartimento(String compartimento) {
		if(compartimento==null) {
			System.out.println("ValorNulo");
			
		}else {
			if(compartimento.equals("")) {
				System.out.println("Nada escrito");
				this.compartimento = "NADA";
			}else {
			this.compartimento = compartimento;
			}
		
		}
	}
	//Get
	public String getCasa() {
		return casa;
	}
	public String getCompartimento() {
		return compartimento;
	}
	
	//Cadastrar??
	
	//public boolean cadastrar(String casa, String compartimento) {
		
		//Local l = new Local();
		//l.setCasa(casa);
		//l.setCompartimento(compartimento);
		
		//return true;
//}
	public Local() {}
	
	public Local(String casa, String compartimento) {
		setCasa(casa);
		setCompartimento(compartimento);
	}
	public String toString() {
		String retorno = getCasa() +" "+getCompartimento();
		return retorno;
	}

}
