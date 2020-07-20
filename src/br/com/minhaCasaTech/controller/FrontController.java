package br.com.minhaCasaTech.controller;




import java.net.URL;
import java.util.ResourceBundle;

import br.com.minhaCasaTech.model.BO.LocalBO;
import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.view.Telas;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
public class FrontController {
	
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
	//Tela login
		@FXML TextField login_txf;
		@FXML TextField senha_pf;
		@FXML Label erro_login_lb;
		@FXML Label error_senha_lb;
		
		public void autenticar(){
			try {
				Telas.telaPrincipal();
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
	//Tela Gerenciar local
	/*public void initialize(URL url, ResourceBundle rb) {
		initTable();
	}*/
	@FXML TableView<LocalVO> tabela_locais;
    @FXML TableColumn<LocalVO,String> local_casa;
    @FXML TableColumn<LocalVO, String> local_compartimento;
    public void initTable(){
    	local_casa.setCellValueFactory(new PropertyValueFactory<>("Casa"));
    	local_compartimento.setCellValueFactory(new PropertyValueFactory<>("Compartimento"));
    	
    	LocalBO lbo = new LocalBO();
    	tabela_locais.setItems(FXCollections.observableArrayList(lbo.listar()));
    }

	
	public void chamarTelaCadastrarLocal() {
		try {
			Telas.telaCadastrarLocal();
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
		stage.close(); //Fechando o Stage
	}
	//Tela Cadastrar equipamento
	@FXML Button cadastrar_equipamento_btm;
	
	@FXML TextField nome_equipamento_txf;
	@FXML TextField peso_equipamento_txf;
	@FXML TextField preco_equipamento_txf;
	@FXML TextField ns_equipamento_txf;
	@FXML TextField quantidade_equipamento_txf;
	@FXML ComboBox select_local_cbb;
	@FXML ComboBox select_responsavel_bb;
	public void cadastrarEquipamento() {
		EquipamentoVO e = new EquipamentoVO();
		e.setNome(nome_equipamento_txf.getText());
		e.setPeso(Double.parseDouble(peso_equipamento_txf.getText()));
		e.setPreco(Double.parseDouble(preco_equipamento_txf.getText()));
		e.setQuantidade(Integer.parseInt(quantidade_equipamento_txf.getText()));
		e.setNumeroDeSerie(Integer.parseInt(ns_equipamento_txf.getText()));
		/*e.setLocal(local);
		e.setResponsavel(responsavel);*/
		
		
		
		Stage stage = (Stage) cadastrar_equipamento_btm.getScene().getWindow(); 
		stage.close(); 
	}
}
