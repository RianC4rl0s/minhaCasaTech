package br.com.minhaCasaTech.controller;

import br.com.minhaCasaTech.model.VO.ClienteVO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastrarClienteController {

    @FXML
    private Button cadastar_cli_btm;

    @FXML
    private TextField cpf_cliente_txf;

    @FXML
    private Button cancel_cli_btm;

    @FXML
    private Label error_lbl;

    @FXML
    private Button clear_cli_btm;

    @FXML
    private TextField nome_cliente_txf;

    @FXML
    private TextField endereco_cliente_txf;

    public void cadastrarCliente() {
    	ClienteVO c = new ClienteVO();
    	//ClienteBO b = new ClienteBO();
    }

	public void limparCampos() {
		nome_cliente_txf.setText("");
		cpf_cliente_txf.setText("");
		endereco_cliente_txf.setText("");
	}
	
	public void cancelarOperacao(){
	    Stage stage = (Stage) cancel_cli_btm.getScene().getWindow(); //Obtendo a janela atual
	    stage.close(); //Fechando o Stage
	}
}
