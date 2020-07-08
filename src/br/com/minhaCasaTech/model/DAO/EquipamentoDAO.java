package br.com.minhaCasaTech.model.DAO;

import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.model.VO.Responsavel;

public class EquipamentoDAO {
	public EquipamentoVO  editar(EquipamentoVO eqpOrigem) {
		eqpOrigem.setNome("NOVO NOME");
		eqpOrigem.setQuantidade(1);
		
		return eqpOrigem;
}
public boolean deletar(EquipamentoVO equipamento) {
	
return true;
}
public void cadastrar(EquipamentoVO equipamento) {

System.out.println(equipamento.toString());
}
public EquipamentoVO buscar(EquipamentoVO e) {

return e;
}
public EquipamentoVO[] listar() {
Responsavel resp = new Responsavel("Joao","Rua 12","3420");
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

}
