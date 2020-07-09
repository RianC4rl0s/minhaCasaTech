package br.com.minhaCasaTech.model.BO;
import br.com.minhaCasaTech.model.VO.LocalVO;
public class LocalBO {

	public void cadastrar(LocalVO local) {
		if (local != null)
		{
			System.out.println("Local adicionado:\n=================="+local.toString());
		}else
			System.out.println("Local nulo!");
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
		System.out.println("Deletado");
	}
}
