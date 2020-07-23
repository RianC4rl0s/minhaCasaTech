package br.com.minhaCasaTech.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.minhaCasaTech.model.BO.EquipamentoBO;
import br.com.minhaCasaTech.model.BO.ResponsavelBO;
import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.FuncionarioVO;
import br.com.minhaCasaTech.model.VO.ProprietarioVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;
import br.com.minhaCasaTech.view.Telas;
import exception.InsertException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class GerenciarResponsavelController implements Initializable {

	@FXML
	private ToggleGroup grupoRadio;
	@FXML
	private Button cadastrar;
	@FXML
	private Button sair_btm;
	@FXML
	private Button excluir;
	@FXML
	private Button editar_eqp_btm;	   
	@FXML
	private Button buscar_btt;
	@FXML private RadioButton radioProp;
	@FXML private RadioButton radioFunc;
	@FXML private Label errorLabel;
	  	
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
			e.printStackTrace();
		}
	}
	
	public void initialize(URL url, ResourceBundle rb) {
		iniciarTabela();
	}
	
	@FXML
    private TableColumn<ResponsavelVO, Long> id_responsavel;
	@FXML
    private TableColumn<ResponsavelVO, String> nome;
    @FXML
	private TableColumn<ResponsavelVO, String> endereco;
	@FXML
	private TableColumn<ResponsavelVO, String> telefone;
	@FXML
	private TableView<ResponsavelVO> tabela_responsaveis;
	
	public void chamarTelaCadastrarResponsavel() {
		try {
			Telas.telaCadastrarResponsavel();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void chamarTelaEditarResponsavel() {
		
		try {
			TableViewSelectionModel<ResponsavelVO> selectedModel = tabela_responsaveis.getSelectionModel();
			Telas.telaEditarResponsavel(selectedModel.getSelectedItem());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
    public void iniciarTabela() {
    	id_responsavel.setCellValueFactory(new PropertyValueFactory<>("id_responsavel"));
		nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		telefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));    	
		    	
		ResponsavelBO rbo = new ResponsavelBO();
		tabela_responsaveis.setItems(FXCollections.observableArrayList(rbo.listar()));
	}
		    
    public void excluirResponsavel() {
    	try {
    		TableViewSelectionModel<ResponsavelVO> selectedModel = tabela_responsaveis.getSelectionModel();
			Telas.telaDeletarResponsavel(selectedModel.getSelectedItem());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
