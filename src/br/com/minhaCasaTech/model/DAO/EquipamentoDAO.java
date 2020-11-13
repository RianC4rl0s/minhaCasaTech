package br.com.minhaCasaTech.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




import br.com.minhaCasaTech.model.VO.EquipamentoVO;




public class EquipamentoDAO extends BaseDAO<EquipamentoVO> {
	
	public  void cadastrar(EquipamentoVO equipamento) {
		
		String sql = "insert into equipamento (nome,peso,preco,quantidade,numero_de_serie,id_local,id_responsavel) values (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pst = getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1,equipamento.getNome());
			pst.setDouble(2, equipamento.getPeso());
			pst.setDouble(3, equipamento.getPreco());
			pst.setInt(4, equipamento.getQuantidade());
			pst.setInt(5, equipamento.getNumeroDeSerie());
			pst.setLong(6, equipamento.getLocal().getId());
			pst.setLong(7, equipamento.getResponsavel().getId_responsavel());
			int affectedRows = pst.executeUpdate();
			if(affectedRows ==0) {
				throw new SQLException("Cadastro falhou");
			}
			ResultSet key = pst.getGeneratedKeys();
			if(key.next()) {
				equipamento.setId_equipamento(key.getLong("id"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editar(EquipamentoVO eqpOrigem) {
		String sql ="update equipamento set nome = ?, peso = ?, preco = ? , quantidade = ?, numero_de_serie = ? where id = ?";
		try {
			PreparedStatement pst = getCon().prepareStatement(sql);
			pst.setString(1,eqpOrigem.getNome());
			pst.setDouble(2, eqpOrigem.getPeso());
			pst.setDouble(3, eqpOrigem.getPreco());
			pst.setInt(4, eqpOrigem.getQuantidade());
			pst.setInt(5, eqpOrigem.getNumeroDeSerie());
			pst.setLong(6, eqpOrigem.getId_equipamento());
			pst.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void deletar(EquipamentoVO equipamento) throws SQLException{
		
		String sql = "delete from equipamento where id = ?";
		
		try {
			PreparedStatement pst = getCon().prepareStatement(sql);
			pst.setLong(1, equipamento.getId_equipamento());
			pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public ResultSet listar(){
		
		String sql = "select * from equipamento";
		Statement st;
		ResultSet rs = null;
		
		try {
			st = getCon().createStatement();
			rs = st.executeQuery(sql);
			/*while(rs.next()) {
			EquipamentoVO eqp = new EquipamentoVO();	
			eqp.setId_equipamento(rs.getLong("id"));
			}*/
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet buscarPorNome(String nome) {
		
		String sql = "select * from equipamento where nome like ?";
		PreparedStatement pst;
		ResultSet rs = null;
		
		try {
			pst = getCon().prepareStatement(sql);
			pst.setString(1,"%"+nome+"%");
			rs = pst.executeQuery();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet buscarPorNS(int ns) {
		
		
		String sql = "select * from equipamento where numero_de_serie = ?";
		PreparedStatement pst;
		ResultSet rs = null;
		
		try {
			pst = getCon().prepareStatement(sql);
			pst.setInt(1, ns);
			rs = pst.executeQuery();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
public ResultSet buscarPorId(Long id) {
		
		
		String sql = "select * from equipamento where id = ?";
		PreparedStatement pst;
		ResultSet rs = null;
		try {
			pst = getCon().prepareStatement(sql);
			pst.setLong(1, id);
			rs = pst.executeQuery();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	public ResultSet buscarPorId(EquipamentoVO equipamento) {
		
		
		String sql = "select * from equipamento where id = ?";
		PreparedStatement pst;
		ResultSet rs = null;
		
		try {
			pst = getCon().prepareStatement(sql);
			pst.setLong(1, equipamento.getId_equipamento());
			rs = pst.executeQuery();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}

	public ResultSet buscarPorLocal(String local) {
	
		
		String sql = "SELECT * FROM equipamento where id_local in(SELECT id FROM local where casa LIKE ? or compartimento like ?)";
		PreparedStatement pst;
		ResultSet rs = null;
		try {
			pst = getCon().prepareStatement(sql);
			pst.setString(1,"%"+local+"%");
			pst.setString(2,"%"+local+"%");
			rs = pst.executeQuery();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	public ResultSet buscarPorResponsavel(String responsavel) {
		String sql = "select * from equipamento where id_local = ?";
		PreparedStatement pst;
		ResultSet rs = null;
		
		try {
			pst = getCon().prepareStatement(sql);
			pst.setString(1,responsavel);
			rs = pst.executeQuery();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	public ResultSet buscarGenerico(String campo) {
		ResultSet rs = null;
		String sql ="select * from equipamento e where nome like ? or"
				+ " e.id_local in(select l2.id from `local` l2 where casa LIKE ? or compartimento LIKE ?)"
				+ "OR e.id_responsavel in " 
				+ "(SELECT resp.id FROM responsavel resp" + 
				"	INNER JOIN pessoa ON resp.id_pessoa = pessoa.id and pessoa.nome like ?)";
		PreparedStatement pst;
		
		try {
			pst = getCon().prepareStatement(sql);
			pst.setString(1,"%"+campo+"%");
			pst.setString(2,"%"+campo+"%");
			pst.setString(3,"%"+campo+"%");
			pst.setString(4,"%"+campo+"%");
			rs = pst.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
		
	}
}
