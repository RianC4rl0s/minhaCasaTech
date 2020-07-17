package br.com.minhaCasaTech.model.BO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import br.com.minhaCasaTech.model.DAO.LocalDAO;
import br.com.minhaCasaTech.model.VO.LocalVO;
public class LocalBO implements localInterBO{

	public void cadastrar(LocalVO local) {
		LocalDAO dao = new LocalDAO();
		try{
			dao.cadastrar(local);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editar(LocalVO local) {
		LocalDAO dao = new LocalDAO();
		try{
			 dao.editar(local);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//return local;
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
		LocalDAO dao = new LocalDAO();
		try{
		dao.deletar(local);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Deletado");
	}
}
