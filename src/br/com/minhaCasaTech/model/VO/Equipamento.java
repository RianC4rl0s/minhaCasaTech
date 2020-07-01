package br.com.minhaCasaTech.model.VO;

public class Equipamento {
	private String nome;
	private double peso;
	private double preco;
	private int quantidade;
	private int numeroDeSerie;
	//private Responsavel responsavel = new Responsavel();
	private String local;
	
	public void setNome(String nome) {
		if(nome != null) {
			if(nome.equals("")) {
				System.out.println("Vazio");
			}else {
				this.nome = nome;
			}
		}else {
			System.out.println("O valor esta nulo");
		}
	}
	public String getNome() {
		return nome;
	}
	public void setPeso(double peso) {
		if (peso <=0 ) {
			System.out.println("Valor invalido");
		}else {
			this.peso = peso;
		}
	
	}
	public double getPeso() {
		return peso;
	}
	public void setPreco(double preco) {
		if (peso <=0 ) {
			System.out.println("Valor invalido");
		}else {
			this.preco = preco;
		}
	
	}
	public double getPreco() {
		
		return preco;
	}
	public void setQuantidade(int quantidade) {
		if (quantidade <= 0) {
			System.out.println("Valor invalido");
		}else {
			this.quantidade = quantidade;
		}
	}
	public int getQuantidade() {
	 return quantidade;
	}
	public void setNumeroSDeSerie(int numeroDeSerie) {
		if (quantidade <= 0) {
			System.out.println("Valor invalido");
		}else {
			this.numeroDeSerie = numeroDeSerie;
		}
	}
	public int getNumeroDeSerie() {
	 return numeroDeSerie;
	}
	public void setLocal(String local) {
		if(local != null) {
			if(local.equals("")) {
				System.out.println("Vazio");
			}else {
				this.local = local;
			}
		}else {
			System.out.println("O valor esta nulo");
		}
	}
	public String getLocal() {
		return local;
	}
}
