package br.com.minhaCasaTech.controller;

import java.net.URL;
import java.util.ResourceBundle;


import br.com.minhaCasaTech.model.BO.EquipamentoBO;
import br.com.minhaCasaTech.model.BO.LocalBO;
import br.com.minhaCasaTech.model.BO.ResponsavelBO;
import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastrarEquipamentoController implements Initializable{
    @FXML private TextField ns_equipamento_txf;
    @FXML private TextField preco_equipamento_txf;
    @FXML private ComboBox<LocalVO> select_local_cbb;
    @FXML private ComboBox<ResponsavelVO> select_responsavel_bb;
    @FXML private TextField nome_equipamento_txf;
    @FXML private Button cancelar_btm;
    @FXML private Button cadastrar_equipamento_btm;
    @FXML private TextField peso_equipamento_txf;
    @FXML private TextField quantidade_equipamento_txf;
    
    
 
    @FXML
	private void cancelarOperacao(){
	    Stage stage = (Stage) cancelar_btm.getScene().getWindow(); //Obtendo a janela atual
	    stage.close(); //Fechando o Stage
	}
    
    public void initialize(URL url, ResourceBundle rb) {
    	carregarCaixas();
    }
	public void carregarCaixas() {
		LocalBO lbo = new LocalBO();
		ResponsavelBO<ResponsavelVO> rbo = new ResponsavelBO<>();
		select_local_cbb.setItems(FXCollections.observableArrayList(lbo.listar()));
		select_responsavel_bb.setItems(FXCollections.observableArrayList(rbo.listar()));
	}

	@FXML
    private Label exception_jlb;
    public void cadastrarEquipamento() {
		EquipamentoVO e = new EquipamentoVO();
		e.setNome(nome_equipamento_txf.getText());
		e.setPeso(Double.parseDouble(peso_equipamento_txf.getText()));
		e.setPreco(Double.parseDouble(preco_equipamento_txf.getText()));
		e.setQuantidade(Integer.parseInt(quantidade_equipamento_txf.getText()));
		e.setNumeroDeSerie(Integer.parseInt(ns_equipamento_txf.getText()));
		e.setLocal(select_local_cbb.getSelectionModel().getSelectedItem());
		e.setResponsavel(select_responsavel_bb.getSelectionModel().getSelectedItem());
		
		EquipamentoBO ebo = new EquipamentoBO();
		ebo.cadastrar(e);
	}
    public void limparCampos() {
    	   ns_equipamento_txf.setText("");;
    	   preco_equipamento_txf.setText("");
    	 
    	   nome_equipamento_txf.setText("");
    	   cancelar_btm.setText("");
    	   cadastrar_equipamento_btm.setText("");
    	   peso_equipamento_txf.setText("");
    	   quantidade_equipamento_txf.setText("");
    }
}
