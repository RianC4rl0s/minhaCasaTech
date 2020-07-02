package br.com.minhaCasaTech.model.VO;

public class Equipamento {
	private String nome;
	private double peso;
	private double preco;
	private int quantidade;
	private int numeroDeSerie;
	private Responsavel responsavel = new Responsavel();
	private Local local = new Local();
	
	
	//Set
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
	
	public void setPeso(double peso) {
		if (peso <=0 ) {
			System.out.println("Valor invalido");
		}else {
			this.peso = peso;
		}
	
	}
	
	public void setPreco(double preco) {
		if (peso <=0 ) {
			System.out.println("Valor invalido");
		}else {
			this.preco = preco;
		}
	
	}
	
	public void setQuantidade(int quantidade) {
		if (quantidade <= 0) {
			System.out.println("Valor invalido");
		}else {
			this.quantidade = quantidade;
		}
	}
	
	public void setNumeroSDeSerie(int numeroDeSerie) {
		if (quantidade <= 0) {
			System.out.println("Valor invalido");
		}else {
			this.numeroDeSerie = numeroDeSerie;
		}
	}
	
	public void setLocal(Local local) {
		if(local != null) {
			
				this.local = local;
			
		}else {
			System.out.println("O valor esta nulo");
		}
	}
	public void setResponsavel(Responsavel responsavel) {
		if(responsavel == null) {
			System.out.println("Valor Nulo");
		}else {
			this.responsavel = responsavel;
		}
	}
	
	
	//Get
	public String getNome() {
		return nome;
	}
	public double getPeso() {
		return peso;
	}
	public int getQuantidade() {
		 return quantidade;
		}
	public double getPreco() {
		
		return preco;
	}
	public int getNumeroDeSerie() {
		 return numeroDeSerie;
		}
	public Local getLocal() {
		return local;
	}
	public Responsavel getResponsavel() {
		return responsavel;
	}
	
	//Methods
	
	//cadastrar BETA
	public boolean cadastrar(String nome, double peso, double preco, int quantidade, int numeroDeSerie,Responsavel responsavel, Local local) {
		
		if(nome != null) {
			if(nome.equals("")) {
				System.out.println("Vazio");
			}else {
				this.nome = nome;
			}
		}else {
			System.out.println("O valor esta nulo");
		}
		
		if (peso <=0 ) {
			System.out.println("Valor invalido");
		}else {
			this.peso = peso;
		}
		
		if (peso <=0 ) {
			System.out.println("Valor invalido");
		}else {
			this.preco = preco;
		}
		
		if (quantidade <= 0) {
			System.out.println("Valor invalido");
		}else {
			this.quantidade = quantidade;
		}
		
		if (quantidade <= 0) {
			System.out.println("Valor invalido");
		}else {
			this.numeroDeSerie = numeroDeSerie;
		}
		
		if(local != null) {
			this.local = local;
		}else {
			System.out.println("O valor esta nulo");
		}
		
		if(responsavel == null) {
			System.out.println("Valor Nulo");
		}else {
			this.responsavel = responsavel;
		}
		boolean r = true;
		return r;
	}
}
