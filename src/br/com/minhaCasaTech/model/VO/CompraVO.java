package br.com.minhaCasaTech.model.VO;

public class CompraVO extends TransacaoVO {
	
	private Long id;
	private Long id_transacao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_transacao() {
		return id_transacao;
	}

	public void setId_transacao(Long id_transacao) {
		this.id_transacao = id_transacao;
	}

	public CompraVO(double valorTotal, double pesoTotal, int totalEquip) {
		super(valorTotal, pesoTotal, totalEquip);
		// TODO Auto-generated constructor stub
	}
	
}
