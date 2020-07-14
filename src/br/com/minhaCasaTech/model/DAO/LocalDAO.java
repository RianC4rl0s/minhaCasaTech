package br.com.minhaCasaTech.model.DAO;

import br.com.minhaCasaTech.model.VO.LocalVO;

public class LocalDAO implements LocalInterDAO{
	
	public void cadastrar(LocalVO local) {
	
	}
	
	public LocalVO editar(LocalVO local) {		
		return local;
	}
	
	public LocalVO buscar(LocalVO local) {
		return local;
	}
	
	public LocalVO[] listar() {
		LocalVO[] l = null;
		return l;
	}
	
	public void deletar(LocalVO local) {
		
	}
}
