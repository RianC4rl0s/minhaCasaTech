package br.com.minhaCasaTech.model.BO;

import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.FuncionarioVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;


public class EquipamentoBO implements EquipamentoInterBO{
	
	public void cadastrar(EquipamentoVO equipamento) {
		if (equipamento != null)
		{
			System.out.println("Equipamento adicionado:\n==================\n"+equipamento);
		}else
			System.out.println("Equipamento nulo!");		
	}
	
	public EquipamentoVO  editar(EquipamentoVO eqpOrigem) {
		eqpOrigem.setNome("NOVO NOME");
		eqpOrigem.setQuantidade(1);
				
		return eqpOrigem;
	}
	
	public void deletar(EquipamentoVO equipamento) {
		System.out.println("Deletado");
	}
	
	public EquipamentoVO buscar(EquipamentoVO e) {
		return e;
	}
	
	public EquipamentoVO[] listar() {
		ResponsavelVO resp = new FuncionarioVO("Joao","Rua 12","3420","user","senha");
		LocalVO l = new LocalVO("Centro","Prateleira A-23");
		EquipamentoVO a = new EquipamentoVO("Mouse", 0.5, 200, 255, 464565, resp, l);
		EquipamentoVO b = new EquipamentoVO("teclado", 1, 500, 2030, 56456465, resp, l);
		EquipamentoVO c = new EquipamentoVO("Monitor", 2.5, 2000, 2000, 45456465, resp, l);
		
		EquipamentoVO eqp[] = new EquipamentoVO[3];
		eqp[0] = a;
		eqp[1] = b;
		eqp[2] = c;
		return eqp;
	}
	
	public EquipamentoVO buscarPorNome(String nome) {
		
		EquipamentoVO eqp = null;
		
		return eqp;
	}
	
	public EquipamentoVO buscarPorNS(int ns) {
		
		EquipamentoVO eqp =  null;
		
		return eqp;
	}
	
	public EquipamentoVO buscarPorLocal(LocalVO local) {
	
		EquipamentoVO eqp = null;
		
		return eqp;
	}
	
	public ResponsavelVO adicionnarResponsavel(ResponsavelVO responsael) {
		ResponsavelVO rep =null;
		return rep;
	}
	
	public LocalVO adicionarLocal(LocalVO local) {
		LocalVO lo = null;
		return lo;
	}
}
