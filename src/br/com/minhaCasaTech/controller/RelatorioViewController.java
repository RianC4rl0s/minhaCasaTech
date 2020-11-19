package br.com.minhaCasaTech.controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.minhaCasaTech.model.DAO.TransacaoDAO;
import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;
import br.com.minhaCasaTech.model.VO.TransacaoVO;
import br.com.minhaCasaTech.view.Telas;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RelatorioViewController implements Initializable {
    @FXML private TableView tabela_equipamentos;
	@FXML private TableColumn<EquipamentoVO, String> nome_coluna_tb;
    @FXML private TableColumn<EquipamentoVO, String> local_coluna_tb;

    @FXML private Button voltar_btm;
    
    private static RelatorioEquipamentosController eqpController;
	private TransacaoDAO ts = new TransacaoDAO();
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		iniciarTabelaEquipamentos();
	}
	
	public void iniciarTabelaEquipamentos() {
		nome_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("nome"));
		local_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("local"));
		
		List<EquipamentoVO> lst = new ArrayList<>();
		ResultSet rs;
		try {
			rs = ts.mostrarView();
			while (rs.next()) {
				EquipamentoVO eqp = new EquipamentoVO();
				LocalVO lcl = new LocalVO();
				eqp.setNome(rs.getString("nome"));
				lcl.setCasa(rs.getString("casa"));
				eqp.setLocal(lcl);
				lst.add(eqp);
			}
			System.out.println(lst);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    	tabela_equipamentos.setItems(FXCollections.observableArrayList(lst));
	}
	
	public void voltar() {
		Stage stage = (Stage) voltar_btm.getScene().getWindow(); //Obtendo a janela atual
	    stage.close(); //Fechando o Stage
	}
}
