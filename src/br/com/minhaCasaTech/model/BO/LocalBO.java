package br.com.minhaCasaTech.model.BO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.minhaCasaTech.model.DAO.LocalDAO;
import br.com.minhaCasaTech.model.VO.LocalVO;
public class LocalBO implements localInterBO{

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
	public LocalVO buscarPorId(ResultSet rs) {
		
		LocalVO local = new LocalVO();
		try {
		local.setCasa(rs.getString("casa"));
		local.setCompartimento(rs.getString("compartimento"));
		local.setId(rs.getLong("id"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return local;
	}
	public LocalVO buscarPorId(LocalVO local) {
		LocalDAO dao = new LocalDAO();
		ResultSet rs = dao.buscarPorId(local);
		try {
		local.setCasa(rs.getString("casa"));
		local.setCompartimento(rs.getString("compartimento"));
		local.setId(rs.getLong("id"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return local;
	}
	
	public List<LocalVO> listar() {
		LocalDAO dao = new LocalDAO();
		ResultSet rs = dao.listar();
		List<LocalVO> locais = new ArrayList<LocalVO>();
		
		try {
			while(rs.next()) {
				LocalVO local = new LocalVO();
				local.setId(rs.getLong("id"));
				local.setCasa(rs.getString("casa"));
				local.setCompartimento((rs.getString("compartimento")));
				locais.add(local);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return locais;
	}
	
	public void deletar(LocalVO local) {
		System.out.println("Deletado");
	}
}
