package br.com.minhaCasaTech.model.DAO;

import java.util.ArrayList;
import java.util.List;

import br.com.minhaCasaTech.model.BO.CaixaBO;
import br.com.minhaCasaTech.model.BO.ClienteBO;
import br.com.minhaCasaTech.model.BO.EquipamentoBO;
import br.com.minhaCasaTech.model.BO.LocalBO;
import br.com.minhaCasaTech.model.BO.ResponsavelBO;
import br.com.minhaCasaTech.model.VO.CaixaVO;
import br.com.minhaCasaTech.model.VO.ClienteVO;
import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.model.VO.ProprietarioVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;
import exception.InsertException;

public class testeDAo {

	public static void main(String[] args) {
		/*CaixaVO c = new CaixaVO();
		CaixaBO b = new CaixaBO();
		
		c = b.pegarValor();
		System.out.println(c.getValor());

		ResponsavelVO resp = new ProprietarioVO("Resp3","sdfsdf","21131111111","Entrar","senhaABC123");
		ResponsavelBO<ResponsavelVO> rbo = new ResponsavelBO<>();
		try {
			rbo.cadastrar(resp);
		} catch (InsertException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LocalBO lbo = new LocalBO();
		LocalVO l = new LocalVO();
		l = lbo.buscarPorId((long) 8);
		System.out.println(l.getCasa());
		System.out.println(l.getCompartimento());
		*/
		ClienteVO eqp = new ClienteVO();
		ClienteBO ebo = new ClienteBO();
		List<ClienteVO> eqpL = new ArrayList<>();
		eqpL = ebo.listar();
		for (int i = 0; i < eqpL.size(); i++) {
			System.out.println(eqpL.get(i).getNome());
		}
	}

}
