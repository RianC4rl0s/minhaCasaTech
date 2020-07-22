package br.com.minhaCasaTech.model.VO;

public class FuncionarioVO extends ResponsavelVO{

	private Long id_funcionario;
	
	public Long getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(Long id) {
		this.id_funcionario = id;
	}
	
	public FuncionarioVO() {
		
	}

	public FuncionarioVO(String nome,String endereco,String telefone,String login,String senha) {
		super(nome,endereco,telefone,login,senha);
	}
	
}
