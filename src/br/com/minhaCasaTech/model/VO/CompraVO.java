package br.com.minhaCasaTech.model.VO;

public class CompraVO extends TransacaoVO {
	
	private Long id_compra;
	private Long id_transacao;
	
	public CompraVO() {
		
	}
	
	public CompraVO(double valorTotal, double pesoTotal, int totalEquip) {
		super(valorTotal, pesoTotal, totalEquip, 1);
		// TODO Auto-generated constructor stub
	}
	
	public Long getId_compra() {
		return id_compra;
	}

	public void setId_compra(Long id) {
		this.id_compra = id;
	}

	public Long getId_transacao() {
		return id_transacao;
	}

	public void setId_transacao(Long id_transacao) {
		this.id_transacao = id_transacao;
	}
	
}
