package br.com.minhaCasaTech.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.minhaCasaTech.model.BO.ResponsavelBO;

import br.com.minhaCasaTech.model.VO.ResponsavelVO;
import br.com.minhaCasaTech.view.Telas;
import exception.InsertException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditarResponsavelController implements Initializable {
	@FXML private TextField nome;
	@FXML private TextField endereco;
	@FXML private TextField telefone;
	@FXML private TextField login;
	@FXML private PasswordField senha;
	@FXML private Button cancelar;
	@FXML private Button cadastrar;
	@FXML private Button clear;
	
	private static EditarResponsavelController editController;
	private ResponsavelVO resp = new ResponsavelVO();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setValores();
	}
	
	public void editarResponsavel() {
		
		resp.setNome(nome.getText());
		resp.setEndereco(endereco.getText());
		resp.setTelefone(telefone.getText());
		resp.setLogin(login.getText());
		resp.setSenha(senha.getText());
		
		ResponsavelBO<ResponsavelVO> bo = new ResponsavelBO();
		try {
			bo.editar(resp);
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
	
	@FXML
	private void cancelarOperacao(){
	    Stage stage = (Stage) cancelar.getScene().getWindow(); //Obtendo a janela atual
	    stage.close(); //Fechando o Stage
	}
	
	public void limparCampos() {
		nome.clear();
		endereco.clear();
		telefone.clear();
		login.clear();
		senha.clear();
	}
	
	public static EditarResponsavelController getDelController() {
		return editController;
	}

	public static void setDelController(EditarResponsavelController editController) {
		EditarResponsavelController.editController = editController;
	}

	public ResponsavelVO getResp() {
		return resp;
	}
	
	public void setResp(ResponsavelVO resp) {
		this.resp = resp;
	}
	
	public void setValores() {
		nome.setText(resp.getNome());
		endereco.setText(resp.getEndereco());
		telefone.setText(resp.getTelefone());
		login.setText(resp.getLogin());
	}
	
}
