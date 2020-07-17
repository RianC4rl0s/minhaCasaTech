package br.com.minhaCasaTech.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.minhaCasaTech.model.VO.PessoaVO;
import br.com.minhaCasaTech.model.VO.TransacaoVO;

/*public class TransacaoDAO<VO extends TransacaoVO> extends BaseDAO<VO>{
	
	public void cadastrar(VO transacao) {
		String sql = "insert into transacao (valorTotal, pesoTotal, totalEquip, data, equipamentos) values (?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setDouble(1, transacao.getValorTotal());
			ptst.setDouble(2, transacao.getPesoTotal());
			ptst.setInt(3, transacao.getTotalEquip());
			ptst.setDate(4, (java.sql.Date) new Date());
			
			int affectedRows = ptst.executeUpdate();
			
			if (affectedRows == 0)
				throw new SQLException("O cadastro falhou");
			
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			
			if(generatedKeys.next())
				pessoa.setId_pessoa(generatedKeys.getLong(1));
			else
				throw new SQLException("O cadastro falhou");
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void editar(VO pessoa) {
		String sql = "update pessoa set nome = ?, endereco = ? where id = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setString(1, pessoa.getNome());
			ptst.setString(2, pessoa.getEndereco());
			ptst.setLong(3, pessoa.getId_pessoa());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet buscarPorId(PessoaVO pessoa) {
		String sql = "select * from pessoa where id=?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setLong(1, pessoa.getId_pessoa());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet buscar() {
		String sql = "select * from pessoa";
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
	
	public void deletar(VO pessoa) {
		String sql = "delete from pessoa where id=?";
		PreparedStatement ptst;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setLong(1, pessoa.getId_pessoa());
			ptst.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public TransacaoVO[] gerarRelatorio(Calendar dataInicio, Calendar dataFim, int tipo) {
		TransacaoVO transacoes[] = null;
		return transacoes;
	}
}*/
