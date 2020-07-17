package br.com.minhaCasaTech.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.minhaCasaTech.model.VO.ResponsavelVO;

public class ResponsavelDAO<VO extends ResponsavelVO> extends PessoaDAO<VO> {
	
	public void cadastrar(VO pessoa) {
		super.cadastrar(pessoa);
		
		String sql = "insert into responsavel (login, senha, telefone, id_pessoa) values (?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, pessoa.getLogin());
			ptst.setString(2, pessoa.getSenha());
			ptst.setString(3, pessoa.getTelefone());
			ptst.setLong(4, pessoa.getId_pessoa());
			
			int affectedRows = ptst.executeUpdate();
			
			if (affectedRows == 0)
				throw new SQLException("O cadastro falhou");
			
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			
			if(generatedKeys.next())
				pessoa.setId_responsavel(generatedKeys.getLong(1));
			else
				throw new SQLException("O cadastro falhou");
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void editar(VO pessoa) {
		super.editar(pessoa);
		
		String sql = "update responsavel set login = ?, senha = ?, telefone = ? where id = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setString(1, pessoa.getLogin());
			ptst.setString(2, pessoa.getSenha());
			ptst.setString(3, pessoa.getTelefone());
			ptst.setLong(4, pessoa.getId_responsavel());
			
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet buscarPorId(VO pessoa) {
		String sql = "select * from pessoa, responsavel where pessoa.id = ?, responsavel.id = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setLong(1, pessoa.getId_pessoa());
			ptst.setLong(2, pessoa.getId_responsavel());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet listar() {
		String sql = "select * from pessoa, responsavel";
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
		super.deletar(pessoa);
		
		String sql = "delete from responsavel where id=?";
		PreparedStatement ptst;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setLong(1, pessoa.getId_responsavel());
			ptst.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
