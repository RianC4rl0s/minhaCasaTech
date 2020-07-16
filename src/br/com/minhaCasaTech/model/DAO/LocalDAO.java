package br.com.minhaCasaTech.model.DAO;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.minhaCasaTech.model.VO.LocalVO;

public class LocalDAO extends BaseDAO implements LocalInterDAO<VO>{
	
	public void cadastrar(VO local) {
		
		String sql = "insert into local (casa,compartimento) values (?,?)";
		
		try {
			PreparedStatement pst = getCon().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, local.getCasa());
			pst.setString(2, local.getCompartimento());
			
			int affectectRows = pst.executeUpdate();
			
			if(affectectRows ==0) {
				throw new SQLException("Cadastro falhou");
			}
			ResultSet key = pst.getGeneratedKeys();
			if(key.next()) {
				local.setId(key.getLong("id"));
			}
		//	pst.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public LocalVO editar(VO local) {		

		String sql = "update local set casa = ?,compartimento = ? where id = ?";
		
		try {
			PreparedStatement pst = getCon().prepareStatement(sql);
			pst.setString(1, local.getCasa());
			pst.setString(2, local.getCompartimento());
			pst.setLong(3, local.getId());
			pst.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return local;
	}
	
	public LocalVO buscar(VO local) {
		
	
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
	public LocalVO buscarPorId(Long id) {
		
		
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
	public void deletar(VO local) {
		
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
