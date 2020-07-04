package br.com.minhaCasaTech.model.VO;

public class Cliente {
	private String nome;
	private String cpf;
	private String endereco;
	
	
	//Set
	public void setNome(String nome) {
		if (nome == null) {
			System.out.println("Valor nulo");
		}else {
			if(nome.equals("")) {
				System.out.println("Esta vazio");
				this.nome =  "Sem nome";
			}else {
				this.nome = nome;
			}
		}
	}
	public void setCpf(String cpf) {
		if (cpf== null) {
			System.out.println("Valor nulo");
		}else {
			if(cpf.equals("")) {
				System.out.println("Esta vazio");
				this.cpf =  "Sem nome";
			}else {
				this.cpf = cpf;
			}
		}
	}
	public void setEndereco(String endereco) {
		if (endereco == null) {
			System.out.println("Valor nulo");
		}else {
			if(endereco.equals("")) {
				System.out.println("Esta vazio");
				this.endereco =  "Sem nome";
			}else {
				this.endereco = endereco;
			}
		}
	}
//get
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getEndereco() {
		return endereco;
	}
}
