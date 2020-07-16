package br.com.minhaCasaTech.model.DAO;

import java.util.List;

import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;


public interface EquipamentoInterDAO<VO> {
	public  void cadastrar(VO equipamento);
	
	public EquipamentoVO  editar(VO eqpOrigem) ;
	
	public void deletar(VO equipamento) ;
	
	public EquipamentoVO buscar(VO e); 
	
	//public EquipamentoVO[] listar();
	
	public List<EquipamentoVO> listar();
	
	public EquipamentoVO buscarPorNome(String nome);
	
	public EquipamentoVO buscarPorNS(int ns);
	
	public EquipamentoVO buscarPorId(Long id);
	
	public EquipamentoVO buscarPorLocal(LocalVO local);
	
	
	
}
