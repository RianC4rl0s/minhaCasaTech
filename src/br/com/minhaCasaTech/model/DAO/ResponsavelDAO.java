package br.com.minhaCasaTech.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.minhaCasaTech.model.VO.PessoaVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;

public class ResponsavelDAO extends PessoaDAO {
	public void cadastrar(ResponsavelVO pessoa) {
		super.cadastrar(pessoa);
		String sql = "insert into Pessoa (nome, endereco) values (?,?)";
		PreparedStatement ptst;
		try {
			ptst = getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, pessoa.getNome());
			ptst.setString(2, pessoa.getEndereco());
			
			int affectedRows = ptst.executeUpdate();
			
			if (affectedRows == 0)
				throw new SQLException("O cadastro falhou");
			
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			
			if(generatedKeys.next())
				pessoa.setId(generatedKeys.getLong(1));
			else
				throw new SQLException("O cadastro falhou");
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void editar(PessoaVO pessoa) {
		String sql = "update Pessoa set nome = ?, endereco = ? where id = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setString(1, pessoa.getNome());
			ptst.setString(2, pessoa.getEndereco());
			ptst.setLong(3, pessoa.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet buscarPorId(Long id) {
		String sql = "select * from Pessoa where id=?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setLong(1, id);
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet buscar() {
		String sql = "select * from Pessoa";
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
	
	public void deletar(PessoaVO pessoa) {
		String sql = "delete from Pessoa where id=?";
		PreparedStatement ptst;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setLong(1, pessoa.getId());
			ptst.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
