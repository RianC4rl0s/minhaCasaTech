package br.com.minhaCasaTech.model.DAO;

import br.com.minhaCasaTech.model.VO.LocalVO;
public class LocalDAO{
//APENAS PARA ATIVIDADE
	
	public void cadastrar(LocalVO local) {
		System.out.println(local.toString());
	}
	public LocalVO editar(LocalVO local) {
		local.setCasa("Casa2");
		local.setCompartimento("Prateleira 34");
		
		return local;
	}
	public LocalVO buscar(LocalVO local) {
		
		return local;
	}
	public LocalVO[] buscar() {
		LocalVO a = new LocalVO("Casa a","Prat 2");
		LocalVO b = new LocalVO("Casa b","Prat 5");
		LocalVO c = new LocalVO("Casa c","Prat 5");
		
		LocalVO l[] = new LocalVO[3];
		l[0] =a;
		l[1] =b;
		l[2] = c;
		return l;
	}
	public void deletar(LocalVO local) {
		local.setCasa("DELETADO");
		local.setCompartimento("DELETADO");
		
		System.out.println(local.toString());
		
	}
}
