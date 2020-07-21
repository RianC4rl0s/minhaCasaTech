package br.com.minhaCasaTech.model.VO;

public class ProprietarioVO extends ResponsavelVO {

	private Long id_proprietario;
	
	public Long getId_proprietario() {
		return id_proprietario;
	}

	public void setId_proprietario(Long id) {
		this.id_proprietario = id;
	}

	public ProprietarioVO(String nome,String endereco,String telefone,String login,String senha) {
		super(nome,endereco,telefone,login,senha);
	}
	
}
