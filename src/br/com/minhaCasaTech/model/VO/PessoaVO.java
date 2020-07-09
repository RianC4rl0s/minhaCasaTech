package br.com.minhaCasaTech.model.VO;

public class PessoaVO {
	
	private String nome;
	private String endereco;
	
	public PessoaVO(String nome, String endereco) {
		setNome(nome);
		setEndereco(endereco);
	}
	
	public void setNome(String nome) {
		if(nome == null)
			System.out.println("valor nulo");
		else
			if(nome.equals(""))
				System.out.println("Nada escrito");
			else
				this.nome = nome;
	}
	
	public void setEndereco(String endereco) {
		if(endereco== null) 
			System.out.println("valor nulo");
		else
			if(endereco.equals(""))
				System.out.println("Nada escrito");
			else
				this.endereco = endereco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public String toString() {
		return
		"Nome: "+nome+"\n"+
		"Endereço: "+endereco+"\n";
	}
}

