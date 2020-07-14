package br.com.minhaCasaTech.model.DAO;

import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;

public class EquipamentoDAO implements EquipamentoInterDAO {
	
	public  void cadastrar(EquipamentoVO equipamento) {
		
	}
	
	public EquipamentoVO  editar(EquipamentoVO eqpOrigem) {
		return eqpOrigem;
	}
	
	public void deletar(EquipamentoVO equipamento) {
		
	}
	
	public EquipamentoVO buscar(EquipamentoVO e) {
		return e;
	}
	
	public EquipamentoVO[] listar() {
		EquipamentoVO[] eqp = null;
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
