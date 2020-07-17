package br.com.minhaCasaTech.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.minhaCasaTech.model.VO.ClienteVO;

public class ClienteDAO extends PessoaDAO<ClienteVO> {
	public void cadastrar(ClienteVO pessoa) {
		super.cadastrar(pessoa);
		
		String sql = "insert into cliente (cpf, id_pessoa) values (?,?)";
		PreparedStatement ptst;
		try {
			ptst = getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, pessoa.getCpf());
			ptst.setLong(4, pessoa.getId_pessoa());
			
			int affectedRows = ptst.executeUpdate();
			
			if (affectedRows == 0)
				throw new SQLException("O cadastro falhou");
			
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			
			if(generatedKeys.next())
				pessoa.setId_cliente(generatedKeys.getLong(1));
			else
				throw new SQLException("O cadastro falhou");
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void editar(ClienteVO pessoa) {
		super.editar(pessoa);
		
		String sql = "update cliente set cpf = ? where id = ?";
		PreparedStatement ptst;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setString(1, pessoa.getCpf());
			
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet buscarPorId(ClienteVO pessoa) {
		String sql = "select * from pessoa, cliente where pessoa.id = ?, cliente.id = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setLong(1, pessoa.getId_pessoa());
			ptst.setLong(2, pessoa.getId_cliente());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet listar() {
		String sql = "select * from pessoa, cliente";
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
	
	public void deletar(ClienteVO pessoa) {
		super.deletar(pessoa);
		
		String sql = "delete from pessoa where id=?";
		PreparedStatement ptst;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setLong(1, pessoa.getId_cliente());
			ptst.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
