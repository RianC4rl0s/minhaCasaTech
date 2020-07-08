package br.com.minhaCasaTech.model.VO;

public class ClienteVO extends PessoaVO {
	private String cpf;
	
	public void setCpf(String cpf) {
		if(cpf == null) {
			System.out.println("Valor nulo");
			
		}else{
			if(cpf.equals("")) {
				System.out.println("SEM CPF");
			}else {
				if(cpf.length() == 11) {
					this.cpf = cpf;
				}else {
					System.out.println("Formato nao padrao");
				}
			}
		}
	}
	
	public String getCpf(){
		
	return cpf;
	}
	public String toString() {
		String s = getCpf();
		return s;
	}
	public ClienteVO() {
		super();
	}
	public ClienteVO(String nome,String endereco, String cpf) {
		super(nome, endereco);
		setCpf(cpf);
	}
}
