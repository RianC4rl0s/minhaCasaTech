package br.com.minhaCasaTech.model.VO;

public abstract class PessoaVO {
	
	private Long id_pessoa;
	private String nome;
	private String endereco;
	
	public PessoaVO() {
	
	}
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
	public Long getId_pessoa() {
		return id_pessoa;
	}
	public void setId_pessoa(Long id) {
		this.id_pessoa = id;
	}
}

