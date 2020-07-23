package br.com.minhaCasaTech.model.VO;

public class EquipamentoVO {
	
	private Long id_equipamento;
	private String nome;
	private double peso;
	private double preco;
	private double valorTotal;
	private int quantidade;
	private int numeroDeSerie;
	private ResponsavelVO responsavel;
	private LocalVO local;
	
	public EquipamentoVO(String nome, double peso, double preco, int qtd, int nSerie, ResponsavelVO responsavel, LocalVO local)
	{
		this.setNome(nome);
		this.setPeso(peso);
		this.setPreco(preco);
		this.setQuantidade(qtd);
		this.setNumeroDeSerie(nSerie);
		this.setResponsavel(responsavel);
		this.setLocal(local);
	}
	public EquipamentoVO() {
		
	}
	
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
		if (peso <=0) {
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
		if (quantidade < 0) {
			System.out.println("Valor invalido");
		}else {
			this.quantidade = quantidade;
		}
	}
	
	public void setNumeroDeSerie(int numeroDeSerie) {
		if (quantidade <= 0) {
			System.out.println("Valor invalido");
		}else {
			this.numeroDeSerie = numeroDeSerie;
		}
	}
	
	public void setLocal(LocalVO local) {
		if(local != null) {
			this.local = local;
		}else {
			System.out.println("O valor esta nulo");
		}
	}
	
	public void setResponsavel(ResponsavelVO responsavel) {
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
	
	public LocalVO getLocal() {
		return local;
	}
	
	public ResponsavelVO getResponsavel() {
		return responsavel;
	}
	
	public String toString() {
		return
		"Nome: "+nome+"\n"+
		"Peso: "+peso+"\n"+
		"Quantidade: "+quantidade+"\n"+
		"Preço: "+preco+"\n"+
		"N° de Série: "+numeroDeSerie+"\n"+
		"Local: "+local.getCasa()+"\n"+
		"Responsável: "+responsavel.getNome()+"\n";
	}
	
	public Long getId_equipamento() {
		return id_equipamento;
	}
	public void setId_equipamento(Long id) {
		this.id_equipamento = id;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal() {
		this.valorTotal = preco * quantidade;
	}
}
