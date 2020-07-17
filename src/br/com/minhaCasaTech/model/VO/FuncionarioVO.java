package br.com.minhaCasaTech.model.VO;

public class FuncionarioVO extends ResponsavelVO{

	private Long id_funcionario;
	private Long id_responsavel;
	
	public Long getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(Long id) {
		this.id_funcionario = id;
	}

	public Long getId_responsavel() {
		return id_responsavel;
	}

	public void setId_responsavel(Long id_responsavel) {
		this.id_responsavel = id_responsavel;
	}

	public FuncionarioVO(String nome,String endereco,String telefone,String login,String senha) {
		super(nome,endereco,telefone,login,senha);
	}
	
}
