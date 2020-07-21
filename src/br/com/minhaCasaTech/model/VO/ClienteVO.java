package br.com.minhaCasaTech.model.VO;

public class ClienteVO extends PessoaVO {
	
	private Long id_cliente;
	private Long id_pessoa;
	private String cpf;
	
	public ClienteVO() {
		
	}
	
	public ClienteVO(String nome,String endereco, String cpf) {
		super(nome, endereco);
		setCpf(cpf);
	}
	
	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id) {
		this.id_cliente = id;
	}

	public Long getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(Long id_pessoa) {
		this.id_pessoa = id_pessoa;
	}
	
	public void setCpf(String cpf) {
		if(cpf == null)
			System.out.println("Valor nulo");
		else
			if(cpf.equals(""))
				System.out.println("SEM CPF");
			else
				if(cpf.length() == 11)
					this.cpf = cpf;
				else
					System.out.println("CPF inválido");
	}
	
	public String getCpf(){
		return cpf;
	}
	
	public String toString() {
		String s = getCpf();
		return s;
	}
}
