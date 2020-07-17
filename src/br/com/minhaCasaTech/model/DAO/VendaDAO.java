package br.com.minhaCasaTech.model.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.VendaVO;

public class VendaDAO extends TransacaoDAO<VendaVO> {
	public void cadastrar(VendaVO transacao) {
		super.cadastrar(transacao);
		
		String sql = "insert into venda (id_cliente, id_transacao) values (?,?)";
		PreparedStatement ptst;
		try {
			ptst = getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setDouble(1, transacao.getCliente().getId_cliente());
			ptst.setDouble(2, transacao.getId_transacao());
			
			int affectedRows = ptst.executeUpdate();
			
			if (affectedRows == 0)
				throw new SQLException("A venda falhou");
			
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			
			if(generatedKeys.next()) {
				transacao.setId_venda(generatedKeys.getLong(1));
			}else
				throw new SQLException("A venda falhou");
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public ResultSet buscarPorId(VendaVO transacao) {
		String sql = "select * from venda, transacao, transacao_equipamentos where venda.id=? and transacao.id=? and transacao_equipamentos.id_transacao=?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setLong(1, transacao.getId_venda());
			ptst.setLong(2, transacao.getId_transacao());
			ptst.setLong(3, transacao.getId_transacao());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet buscar() {
		String sql = "select * from venda, transacao where (tipo = 0)";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getCon().prepareStatement(sql);
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}
