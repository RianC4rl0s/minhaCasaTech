package br.com.minhaCasaTech.model.BO;

import br.com.minhaCasaTech.model.VO.CaixaVO;

public class teste {

	public static void main(String[] args) {
		CaixaVO caixa = new CaixaVO();
		CaixaBO cbo = new CaixaBO();
		caixa = cbo.pegarValor();
		
		System.out.println(caixa.getValor());
		
		cbo.addValor(200.00);
		
		System.out.println(" Add valor");
		
		caixa = cbo.pegarValor();
		
		System.out.println(caixa.getValor());

	}

}
