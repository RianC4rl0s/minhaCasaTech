package br.com.minhaCasaTech.model.BO;
import br.com.minhaCasaTech.model.VO.EquipamentoVO;
//import br.com.minhaCasaTech.model.VO.Local;
//import br.com.minhaCasaTech.model.VO.Responsavel;
public class EquipamentoBO {
	
	public EquipamentoVO  editar(EquipamentoVO eqpOrigem,EquipamentoVO eqpEdt) {
				eqpOrigem = eqpEdt;
				//EquipamentoDAO eDao = new EquipamentoDAO();
				//eDao.editarEquipamento(equipOrigem);
				return eqpOrigem;
	}
	public void remover(EquipamentoVO equipamento) {
			//EquipamentoDAO eDao = new EquipamentoDAO();
			//eDao.removerEquipamento(equipamento);
		
	}
	public void cadastrar(EquipamentoVO equipamento) {
		
		System.out.println(equipamento.toString());
	}
	
	
	
	//public void cadastrar(String nome, double peso, double preco, int quantidade, int numeroDeSerie,Responsavel responsavel, Local local) {
		//EquipamentoVO equipamento = new EquipamentoVO(nome,peso,preco,quantidade,numeroDeSerie,responsavel,local);
		//EquipamentoDAO eDao = new EquipamentoDAO();
		//eDao.cadastrarEquipamento(equipamento);
		
		
	//}
	//public EquipamentoVO buscar(String busca) {
		
		
	//}
}
