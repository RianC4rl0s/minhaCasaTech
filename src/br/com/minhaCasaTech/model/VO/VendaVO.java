package br.com.minhaCasaTech.model.VO;

public class VendaVO extends TransacaoVO{

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
	
}
