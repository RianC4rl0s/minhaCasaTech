package br.com.minhaCasaTech.model.VO;
import java.util.Calendar;
public class Relatorio {
	private int totalCompra;
	private int totalVenda;
	private Compra[] compra = new Compra[totalCompra];
	private Venda[] venda =  new Venda[totalVenda];
	private Calendar dataInicial;
	private Calendar dataFinal;
	
	//Set
	public void setCompra(Compra[] compra) {
		if(compra == null) {
			System.out.println("Vetor nulo");
		}else {
			for (int i = 0; i < totalCompra;i++) {
				this.compra[i] = compra[i];
			}
		}
	}
	public void setVenda(Venda[] venda) {
		if(venda == null) {
			System.out.println("Vetor nulo");
		}else {
			for (int i = 0; i < totalVenda;i++) {
				this.venda[i] = venda[i];
			}
		}
	}
	public void setTotalCOmpra(int totalCompra) {
		if(totalCompra<= 0) {
			System.out.println("Vazio");
		}else {
			this.totalCompra =totalCompra;
		}
		
	}
	public void setTotalVenda(int totalVenda) {
		if(totalVenda<= 0) {
			System.out.println("Vazio");
		}else {
			this.totalVenda=totalVenda;
		}
		
	}
	public void setDataInicial(Calendar dataInicial) {
		if(dataInicial== null) {
			System.out.println("Valor nulo");
		}else {
			this.dataInicial =  dataInicial;
		}
	}
	public void setDataFinal(Calendar dataFinal) {
		if(dataFinal== null) {
			System.out.println("Valor nulo");
		}else {
			this.dataFinal =  dataFinal;
		}
	}
	
	//Get
	public int getTotalCompra() {
		return totalCompra;
	}
	public int getTotalVenda() {
		return totalVenda;
	}
	public Calendar getDataInicial() {
		return dataInicial;
	}
	public Calendar getDataFinal() {
		return dataFinal;
	}
	public Compra[] getCompras() {
		return compra;
	}
	public Venda[] getVendas() {
		return venda;
	}
	
}
