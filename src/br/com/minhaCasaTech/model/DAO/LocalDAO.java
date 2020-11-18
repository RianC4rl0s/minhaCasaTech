package br.com.minhaCasaTech.model.DAO;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.minhaCasaTech.model.VO.LocalVO;

public class LocalDAO extends BaseDAO<LocalVO>{
	
	public void cadastrar(LocalVO local) {
		
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
	
	public void editar(LocalVO local) {		

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
	}
	/*
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
	}*/
	
public ResultSet buscarPorId(Long id) {
		
		
		PreparedStatement pst;
		ResultSet rs = null;
		String sql = "select * from local where id = ?";
		try {
			pst = getCon().prepareStatement(sql);
			pst.setLong(1,id);
			rs = pst.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet buscarPorId(LocalVO local) {
		
		
		PreparedStatement pst;
		ResultSet rs = null;
		String sql = "select * from local where id = ?";
		
		try {
			pst = getCon().prepareStatement(sql);
			pst.setLong(1,local.getId());
			rs = pst.executeQuery();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet listar(){
		
		String sql = "select * from local";
		Statement  st; 
		ResultSet rs  = null;
		//List<LocalVO> locais = new ArrayList<LocalVO>();
		
		try{
			st = getCon().createStatement();
			rs = st.executeQuery(sql);
			/*while(rs.next()) {
				LocalVO l = new LocalVO();
				l.setCasa(rs.getString("casa"));
				l.setCompartimento(rs.getString("compartimento"));
				l.setId(rs.getLong("id"));
				
				locais.add(l);
			}*/
		}catch(SQLException e) {
			e.printStackTrace();
		
		}
		return rs;
		
	}
	
	/*public ResultSet buscar(){
		
		String sql = "select * from local";
		Statement  st; 
		ResultSet rs  = null;
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
		return rs;
		
	}
	*/
	public void deletar(LocalVO local) throws SQLException {
		
		String sql = "delete from local where id = ?";
		
		//try {
			PreparedStatement pst = getCon().prepareStatement(sql);
			pst.setLong(1, local.getId());
			
			pst.executeUpdate();
		/*}catch(SQLException e) {
			e.printStackTrace();
		}*/
	}
}
