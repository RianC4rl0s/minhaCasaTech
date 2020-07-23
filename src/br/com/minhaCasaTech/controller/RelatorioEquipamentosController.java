package br.com.minhaCasaTech.controller;

import java.net.URL;
import java.util.ResourceBundle;

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

public class RelatorioEquipamentosController implements Initializable {
    @FXML private TableView tabela_equipamentos;
	@FXML private TableColumn<EquipamentoVO, Long> id_coluna_tb;
	@FXML private TableColumn<EquipamentoVO, String> quantidade_coluna_tb;
    @FXML private TableColumn<EquipamentoVO, String> ns_coluna_tb;
    @FXML private TableColumn<EquipamentoVO, String> nome_coluna_tb;
    @FXML private TableColumn<EquipamentoVO, Double> peso_coluna_tb;
    @FXML private TableColumn<EquipamentoVO, String> reponsavel_coluna_tb;
    @FXML private TableColumn<EquipamentoVO, Double> preco_coluna_tb;
    @FXML private TableColumn<EquipamentoVO, LocalVO> local_coluna_tb;

    @FXML private Button voltar_btm;
    
    private static RelatorioEquipamentosController eqpController;
	private TransacaoVO ts = new TransacaoVO();
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
	
	public void iniciarTabelaEquipamentos(TransacaoVO ts) {
		id_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("id_equipamento"));
    	nome_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	preco_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("preco"));
    	peso_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("peso"));
    	quantidade_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
    	ns_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("numeroDeSerie"));
	
    	local_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("local"));
    	reponsavel_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("responsavel"));
    
    	tabela_equipamentos.setItems(FXCollections.observableArrayList(ts.getEquipamentos()));
	}
	
	public void voltar() {
		Stage stage = (Stage) voltar_btm.getScene().getWindow(); //Obtendo a janela atual
	    stage.close(); //Fechando o Stage
	}
	
	public static RelatorioEquipamentosController getDelController() {
		return eqpController;
	}

	public static void setDelController(RelatorioEquipamentosController eqpController) {
		RelatorioEquipamentosController.eqpController = eqpController;
	}

	public TransacaoVO getResp() {
		return ts;
	}
	
	public void setResp(TransacaoVO resp) {
		ts = resp;
		iniciarTabelaEquipamentos(ts);
	}
}
