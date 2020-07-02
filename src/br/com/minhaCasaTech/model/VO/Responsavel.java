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
			this.nome = nome;
		}
	}
	public void setEndereco(String endereco) {
		if(endereco== null) {
			System.out.println("valor nulo");
			
		}else {
			this.endereco= endereco;
		}
	}
	public void setTelefone(String telefone) {
		if(telefone== null) {
			System.out.println("valor nulo");
			
		}else {
			this.telefone= telefone;
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
}
