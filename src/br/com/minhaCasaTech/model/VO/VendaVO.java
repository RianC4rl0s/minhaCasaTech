package br.com.minhaCasaTech.model.VO;

public class VendaVO extends TransacaoVO{

	private Long id;
	private Long id_transacao;
	private ClienteVO cliente;
	
	public VendaVO(double valorTotal, double pesoTotal, int totalEquip) {
		super(valorTotal, pesoTotal, totalEquip);
		
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
}
