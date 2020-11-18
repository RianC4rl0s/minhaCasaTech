package br.com.minhaCasaTech.controller;


import java.net.URL;
import java.util.ResourceBundle;


import br.com.minhaCasaTech.model.BO.ResponsavelBO;

import br.com.minhaCasaTech.model.VO.FuncionarioVO;

import br.com.minhaCasaTech.model.VO.ProprietarioVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;
import br.com.minhaCasaTech.view.Telas;
import exception.InsertException;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastrarResponsavelController implements Initializable {
	@FXML private TextField nome;
	@FXML private TextField endereco;
	@FXML private TextField telefone;
	@FXML private TextField login;
	@FXML private PasswordField senha;
	@FXML private Button cancelar;
	@FXML private Button cadastrar;
	@FXML private Button clear;
	@FXML private CheckBox checkProprietario;
	     
	@FXML
	private void cancelarOperacao(){
	    Stage stage = (Stage) cancelar.getScene().getWindow(); //Obtendo a janela atual
	    stage.close(); //Fechando o Stage
	}
	    
    public void initialize(URL url, ResourceBundle rb) {
    	
	}
	    
	public void cadastrarResponsavel() {
		
		ResponsavelVO e;
		
		if (checkProprietario.isSelected())
			e = new ProprietarioVO();
		else
			e = new FuncionarioVO();
		
		e.setNome(nome.getText());
		e.setEndereco(endereco.getText());
		e.setTelefone(telefone.getText());
		e.setLogin(login.getText());
		e.setSenha(senha.getText());
		
		ResponsavelBO<ResponsavelVO> bo = new ResponsavelBO();
		try {
			bo.cadastrar(e);
		} catch (InsertException e1) {
			e1.printStackTrace();
		}
		
		Stage stage = (Stage) cadastrar.getScene().getWindow(); 
		stage.close();
		
		try {
			Telas.telaSetorProprietario();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void limparCampos() {
		nome.clear();
		endereco.clear();
		telefone.clear();
		login.clear();
		senha.clear();
		checkProprietario.setSelected(false);
	}
}
