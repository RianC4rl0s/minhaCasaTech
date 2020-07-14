package br.com.minhaCasaTech.model.DAO;

import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;

public interface EquipamentoInterDAO {
	public  void cadastrar(EquipamentoVO equipamento);
	
	public EquipamentoVO  editar(EquipamentoVO eqpOrigem) ;
	
	public void deletar(EquipamentoVO equipamento) ;
	
	public EquipamentoVO buscar(EquipamentoVO e); 
	
	public EquipamentoVO[] listar();
	
	public EquipamentoVO buscarPorNome(String nome);
	
	public EquipamentoVO buscarPorNS(int ns);
	
	public EquipamentoVO buscarPorLocal(LocalVO local);
	
	public ResponsavelVO adicionnarResponsavel(ResponsavelVO responsael);
	
	public LocalVO adicionarLocal(LocalVO local);
	
}
