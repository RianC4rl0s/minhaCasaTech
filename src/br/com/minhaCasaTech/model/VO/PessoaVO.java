package br.com.minhaCasaTech.model.VO;

public class PessoaVO {
	private String nome;
	private String endereco;
	
	public void setNome(String nome) {
		if(nome == null) {
			System.out.println("Valor nulo");
		}else {
			if(nome.equals("")) {
				System.out.println("Sem nome");
				this.nome = "semnome";
				
			}else {
				this.nome = nome;
			}
		}	
	}
	public void setEndereco(String endereco) {
		if(endereco== null) {
			System.out.println("Valor nulo");
		}else {
			if(endereco.equals("")) {
				System.out.println("Sem nome");
				this.endereco = "semnome";
				
			}else {
				this.endereco= endereco;
			}
		}
	}
	
	public String getNome() {
		return nome;
	}
	public String getEndereco() {
	return endereco;
	}

	public PessoaVO() {	}
	public PessoaVO(String nome, String endereco) {
		setNome(nome);
		setEndereco(endereco);
		
	}
}

