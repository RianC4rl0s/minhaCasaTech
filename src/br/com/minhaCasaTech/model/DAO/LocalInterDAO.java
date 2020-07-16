package br.com.minhaCasaTech.model.DAO;

import java.util.List;

import br.com.minhaCasaTech.model.VO.LocalVO;

public interface LocalInterDAO {
    public void cadastrar(LocalVO local);
	
	public LocalVO editar(LocalVO local);
	
	public LocalVO buscar(LocalVO local);
	
	//public LocalVO[] listar();
	
	public LocalVO buscarId(Long id);
	
	public List<LocalVO> listar();
	
	public void deletar(LocalVO local);
}
