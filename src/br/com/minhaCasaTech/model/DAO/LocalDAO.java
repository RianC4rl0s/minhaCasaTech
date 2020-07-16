package br.com.minhaCasaTech.model.DAO;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.minhaCasaTech.model.VO.LocalVO;

public class LocalDAO extends BaseDAO<LocalVO> implements LocalInterDAO{
	
	public void cadastrar(LocalVO local) {
		
		String sql = "insert into local (casa,compartimento) values (?,?)";
		
		try {
			PreparedStatement pst = getCon().prepareStatement(sql);
			pst.setString(1, local.getCasa());
			pst.setString(2, local.getCompartimento());
			pst.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public LocalVO editar(LocalVO local) {		
		return local;
	}
	
	public LocalVO buscar(LocalVO local) {
		
	
		PreparedStatement pst;
		ResultSet rs;
		String sql = "select * from local where id = ?";
		LocalVO l = new LocalVO();
		try {
			pst = getCon().prepareStatement(sql);
			pst.setLong(1, local.getId());
			rs = pst.executeQuery();
			l.setCasa(rs.getString("casa"));
			l.setCompartimento(rs.getString("compartimento"));
			l.setId(rs.getLong("id"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
	public LocalVO buscarId(Long id) {
		
		
		PreparedStatement pst;
		ResultSet rs;
		String sql = "select * from local where id = ?";
		LocalVO l = new LocalVO();
		try {
			pst = getCon().prepareStatement(sql);
			pst.setLong(1, id);
			rs = pst.executeQuery();
			l.setCasa(rs.getString("casa"));
			l.setCompartimento(rs.getString("compartimento"));
			l.setId(rs.getLong("id"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
	
	/*public LocalVO[] listar() {
		LocalVO[] l = null;
		return l;
	}*/
	public List<LocalVO> listar(){
		
		String sql = "select * from local";
		Statement  st; 
		ResultSet rs;
		List<LocalVO> locais = new ArrayList<LocalVO>();
		
		try{
			st = getCon().createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				LocalVO l = new LocalVO();
				l.setCasa(rs.getString("casa"));
				l.setCompartimento(rs.getString("compartimento"));
				l.setId(rs.getLong("id"));
				
				locais.add(l);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		
		}
		return locais;
		
	}
	public void deletar(LocalVO local) {
		
		String sql = "delete from local where id = ?";
		
		try {
			PreparedStatement pst = getCon().prepareStatement(sql);
			pst.setLong(1, local.getId());
			
			pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
