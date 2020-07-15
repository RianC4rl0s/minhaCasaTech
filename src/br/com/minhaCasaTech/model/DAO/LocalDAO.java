package br.com.minhaCasaTech.model.DAO;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.minhaCasaTech.model.VO.LocalVO;

public class LocalDAO extends BaseDAO implements LocalInterDAO{
	
	public void cadastrar(LocalVO local) {
		con = getCon();
		String sql = "insert into local (casa,compartimento) values (?,?)";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
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
		con = getCon();
		String sql = "select * from local where id = ?";
		ResultSet rs;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setLong(1, local.getId());
			pst.execute();
			rs = pst.getResultSet();
			local.setId(rs.getLong("id"));
			local.setCasa(rs.getString("casa"));
			local.setCompartimento(rs.getString("compartimento"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return local;
	}
	
	/*public LocalVO[] listar() {
		LocalVO[] l = null;
		return l;
	}*/
	public List<LocalVO> listar(){
		con = getCon();
		String sql = "select * from local";
		Statement  st; 
		ResultSet rs;
		List<LocalVO> locais = new ArrayList<LocalVO>();
		
		try{
			st = con.createStatement();
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
		con = getCon();
		String sql = "delete from local where id = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setLong(1, local.getId());
			
			pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
