package br.com.minhaCasaTech.model.VO;

public class VendaVO extends TransacaoVO{

	private Long id_venda;
	private Long id_transacao;
	private ClienteVO cliente;
	
	public VendaVO() {
		
	}
	
	public VendaVO(double valorTotal, double pesoTotal, int totalEquip) {
		super(valorTotal, pesoTotal, totalEquip, 0);
		
		this.setCliente(cliente);
	}

	public ClienteVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVO cliente) {
		if (cliente != null)
			this.cliente = cliente;
		else
			System.out.println("Cliente Invalido");
	}
	
	public Long getId_venda() {
		return id_venda;
	}

	public void setId_venda(Long id) {
		this.id_venda = id;
	}

	public Long getId_transacao() {
		return id_transacao;
	}

	public void setId_transacao(Long id_transacao) {
		this.id_transacao = id_transacao;
	}	
}
