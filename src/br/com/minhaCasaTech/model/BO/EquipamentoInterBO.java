package br.com.minhaCasaTech.model.BO;

import java.util.List;

import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;


public interface EquipamentoInterBO {
	
	
	public void cadastrar(EquipamentoVO equipamento);
	
	public void  editar(EquipamentoVO eqpOrigem) ;
	
	public void deletar(EquipamentoVO equipamento) ;
	
	
	public List<EquipamentoVO> listar();
	
	public List<EquipamentoVO> buscarPorNome(String nome);
	
	public EquipamentoVO buscarPorNS(int ns);
	
	public EquipamentoVO buscarPorId(Long id);
	
	public EquipamentoVO buscarPorId(EquipamentoVO equipamento);
	
	public EquipamentoVO buscarPorLocal(LocalVO local);
	
	
}
