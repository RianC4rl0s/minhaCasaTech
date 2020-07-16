package br.com.minhaCasaTech.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;

public class EquipamentoDAO extends BaseDAO implements EquipamentoInterDAO {
	
	public  void cadastrar(EquipamentoVO equipamento) {
		con = getCon();
		String sql = "insert into equipamento (nome,peso,preco,quantidade,numero_de_serie,local) values (?,?,?,?,?,?)";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,equipamento.getNome());
			pst.setDouble(2, equipamento.getPeso());
			pst.setDouble(3, equipamento.getPreco());
			pst.setInt(4, equipamento.getQuantidade());
			pst.setInt(5, equipamento.getNumeroDeSerie());
			pst.setLong(6, equipamento.getLocal().getId());
			pst.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public EquipamentoVO  editar(EquipamentoVO eqpOrigem) {
		return eqpOrigem;
	}
	
	public void deletar(EquipamentoVO equipamento) {
		con = getCon();
		String sql = "delete from equipamento where id = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setLong(1, equipamento.getId());
			pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public EquipamentoVO buscar(EquipamentoVO e) {
		return e;
	}
	
	/*public EquipamentoVO[] listar() {
		EquipamentoVO[] eqp = null;
		return eqp;
	}*/
	
	public List<EquipamentoVO> listar(){
		con = getCon();
		String sql = "select * from equipamento";
		Statement st;
		ResultSet rs;
		List<EquipamentoVO> equipamentoList = new ArrayList<EquipamentoVO>();
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
			EquipamentoVO eqp = new EquipamentoVO();	
			eqp.setId(rs.getLong("id"));
			eqp.setNome(rs.getString("nome"));
			eqp.setPeso(rs.getDouble("peso"));
			eqp.setPreco(rs.getDouble("preco"));
			eqp.setQuantidade(rs.getInt("quantidade"));
			eqp.setNumeroDeSerie(rs.getInt("numero_de_serie"));
			
			equipamentoList.add(eqp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return equipamentoList;
	}
	public EquipamentoVO buscarPorNome(String nome) {
		con = getCon();
		String sql = "select * from equipamento where nome = ?";
		PreparedStatement pst;
		ResultSet rs = null;
		EquipamentoVO eqp = new EquipamentoVO();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, nome);
			rs = pst.executeQuery();
			eqp.setId(rs.getLong("id"));
			eqp.setNome(rs.getString("nome"));
			eqp.setPeso(rs.getDouble("peso"));
			eqp.setPreco(rs.getDouble("preco"));
			eqp.setQuantidade(rs.getInt("quantidade"));
			eqp.setNumeroDeSerie(rs.getInt("numero_de_serie"));
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return eqp;
	}
	
	public EquipamentoVO buscarPorNS(int ns) {
		
		con = getCon();
		String sql = "select * from equipamento where nome = ?";
		PreparedStatement pst;
		ResultSet rs = null;
		EquipamentoVO eqp = new EquipamentoVO();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, ns);
			rs = pst.executeQuery();
			eqp.setId(rs.getLong("id"));
			eqp.setNome(rs.getString("nome"));
			eqp.setPeso(rs.getDouble("peso"));
			eqp.setPreco(rs.getDouble("preco"));
			eqp.setQuantidade(rs.getInt("quantidade"));
			eqp.setNumeroDeSerie(rs.getInt("numero_de_serie"));
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return eqp;
	}
	
	public EquipamentoVO buscarPorLocal(LocalVO local) {
	
		EquipamentoVO eqp = null;
		
		return eqp;
	}
	
	public ResponsavelVO adicionnarResponsavel(ResponsavelVO responsael) {
		ResponsavelVO rep =null;
		return rep;
	}
	
	public LocalVO adicionarLocal(LocalVO local) {
		LocalVO lo = null;
		return lo;
	}
}
