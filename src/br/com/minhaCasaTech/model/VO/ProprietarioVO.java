package br.com.minhaCasaTech.model.VO;

public class ProprietarioVO extends ResponsavelVO {

	private Long id_proprietario;
	private Long id_responsavel;
	
	public Long getId_proprietario() {
		return id_proprietario;
	}

	public void setId_proprietario(Long id) {
		this.id_proprietario = id;
	}

	public Long getId_responsavel() {
		return id_responsavel;
	}

	public void setId_responsavel(Long id_responsavel) {
		this.id_responsavel = id_responsavel;
	}

	public ProprietarioVO(String nome,String endereco,String telefone,String login,String senha) {
		super(nome,endereco,telefone,login,senha);
	}
	
}
