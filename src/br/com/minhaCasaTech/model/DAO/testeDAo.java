package br.com.minhaCasaTech.model.DAO;

import br.com.minhaCasaTech.model.BO.CaixaBO;
import br.com.minhaCasaTech.model.BO.ResponsavelBO;
import br.com.minhaCasaTech.model.VO.CaixaVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;
import exception.InsertException;

public class testeDAo {

	public static void main(String[] args) {
		CaixaVO c = new CaixaVO();
		CaixaBO b = new CaixaBO();
		
		c = b.pegarValor();
		System.out.println(c.getValor());

		ResponsavelVO resp = new ResponsavelVO("Ola","Teste","11111111111","Entrar","senhaABC123");
		ResponsavelBO<ResponsavelVO> rbo = new ResponsavelBO<>();
		try {
			rbo.cadastrar(resp);
		} catch (InsertException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
