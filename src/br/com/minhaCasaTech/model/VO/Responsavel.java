package br.com.minhaCasaTech.model.VO;

public class Responsavel {
	private String nome;
	private String endereco;
	private String telefone;
	
	//Set
	public void setNome(String nome) {
		if(nome == null) {
			System.out.println("valor nulo");
			
		}else {
			if(nome.equals("")) {
				System.out.println("Nada escrito");
			}else {
			this.nome = nome;
			}
		}
	}
	public void setEndereco(String endereco) {
		if(endereco== null) {
			System.out.println("valor nulo");
			
		}else {
			if(endereco.equals("")) {
				System.out.println("Nada escrito");
				this.endereco = "NADA";
			}else {
			this.endereco = endereco;
			}
		}
	}
	public void setTelefone(String telefone) {
		if(telefone== null) {
			System.out.println("valor nulo");
			
		}else {
			if(telefone.equals("")) {
				System.out.println("Nada escrito");
				this.telefone= "NADA";
			}else {
			this.telefone = telefone;
			}		
		}
	}
	
	//Get
	public String getNome() {
		return nome;
	}
	public String getEndereco(){
		return endereco;
		
	}
	public String getTelefone() {
		return telefone;
	}
	public Responsavel() {}
	public Responsavel(String nome, String endereco, String telefone) {
		setNome(nome);
		setEndereco(endereco);
		setTelefone(telefone);
	}
}



