package br.com.minhaCasaTech.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.minhaCasaTech.model.BO.CaixaBO;
import br.com.minhaCasaTech.model.BO.LocalBO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.view.Telas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class PrincipalController implements Initializable{
	
	@FXML Button cancelar_btm = new Button();
	
	@FXML
	private void cancelarOperacao(){
	    Stage stage = (Stage) cancelar_btm.getScene().getWindow(); //Obtendo a janela atual
	    stage.close(); //Fechando o Stage
	}
	public void voltarInicio() {
		try {
			Telas.telaPrincipal();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void sair() {
		try {
			Telas.telaLogin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

		
	//Telap principal	
	public void chamarTelaGerenciarEquipamento() {
		try {
			Telas.telaGerenciarEquipamento();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void chamarTelaCadastrarEquipamento() {
		try {
			Telas.telaCadastrarEquipamento();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void chamarTelaGerenciarResponsavel() {
		try {
			Telas.telaGerenciarResponsavel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void chamarTelaCadastrarResponsavel() {
		try {
			Telas.telaCadastrarResponsavel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void chamarTelaGerenciarClientes() {
		try {
			Telas.telaGerenciarCliente();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void chamarTelaGerenciarLocal() {
		try {
			Telas.telaGerenciarLocal();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void chamarTelaGerarRelatorio() {
		try {
			Telas.telaCadastrarEquipamento();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Tela Cadastrar local
	
	@FXML TextField casa_cad_txf;
	@FXML TextField compartimento_cad_txf;
	@FXML Button cadastar_local_btm;
	public void cadastrarLocal() {
		LocalVO l = new LocalVO(casa_cad_txf.getText(),compartimento_cad_txf.getText());
		LocalBO lbo = new LocalBO(); 
		lbo.cadastrar(l);
		Stage stage = (Stage) cadastar_local_btm.getScene().getWindow(); //Obtendo a janela atual
		try {
			Telas.telaGerenciarLocal();
		} catch (Exception e) {
			
		}
		stage.close(); //Fechando o Stage
		
	}
	public void limparCampos() {
		compartimento_cad_txf.setText("");
		casa_cad_txf.setText("");
	}
	@FXML
    private TextField caixa_txf;
	public void initialize(URL url, ResourceBundle rb) {
		iniciarCaixa();
	}
	public void iniciarCaixa() {
		CaixaBO cbo = new CaixaBO();
		System.out.println(cbo.pegarValor());
		caixa_txf.setText( String.valueOf(cbo.pegarValor()));
		System.out.println(cbo.pegarValor());
	}
	
}
