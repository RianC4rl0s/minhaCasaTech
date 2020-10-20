package br.com.minhaCasaTech.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import br.com.minhaCasaTech.model.BO.CaixaBO;
import br.com.minhaCasaTech.model.BO.TransacaoBO;
import br.com.minhaCasaTech.model.VO.CaixaVO;
import br.com.minhaCasaTech.model.VO.TransacaoVO;
import br.com.minhaCasaTech.view.Telas;
import exception.NotFoundException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
	public void chamarTelaComprar() {
		try {
			Telas.telaGerenciarCompra();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void chamarTelaVender() {
		try {
			Telas.telaGerenciarVenda();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void chamarTelaRelatorio() {
		try {
			Telas.telaRelatorio();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Tela Cadastrar local
	
	
	@FXML
    private TextField caixa_txf;
	public void initialize(URL url, ResourceBundle rb) {
		iniciarCaixa();
		preencherTabela();
	}

	public void iniciarCaixa() {
		CaixaVO c = new CaixaVO();
		CaixaBO cbo = new CaixaBO();
		c = cbo.pegarValor();
		System.out.println(c.getValor());
		caixa_txf.setText( String.valueOf(c.getValor()));
	}
	
	


    @FXML
    private Button cadastrar_equipamento_menu_btm;

    @FXML
    private Button cadastrar_responsavel_menu_btm;

    @FXML
    private Button gerenciar_local_menu_btm;

    @FXML
    private Button gerenciar_cliente_menu_btm;

   

    @FXML
    private Button gerenciar_responosavel_menu_btm;


    @FXML
    private Button nova_crompra_btm;

    @FXML
    private Button gerar_relatorio_btm;

    @FXML
    private Button sair_btm;

    @FXML
    private Button gerenciar_equipamento_menu_btm;

    @FXML
    private TableColumn<TransacaoVO, String> peso_t_tb;
    @FXML
    private TableColumn<TransacaoVO, String> totalP_t_tb;
    @FXML
    private TableColumn<TransacaoVO, String> tipo_t_tb;
	@FXML
    private TableColumn<TransacaoVO, String> valor_t_tb;
    @FXML
    private TableView<TransacaoVO> tabela_transacao_tb;

    @FXML
    private TableColumn<TransacaoVO, Calendar> data_t_tb;
    public void preencherTabela(){
		List<TransacaoVO> ts = new ArrayList<>();
		TransacaoBO tbo = new TransacaoBO();
		try {
			ts =tbo.listar();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		peso_t_tb.setCellValueFactory(new PropertyValueFactory<>("pesoTotal"));
		totalP_t_tb.setCellValueFactory(new PropertyValueFactory<>("totalEquip"));
		tipo_t_tb.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		valor_t_tb.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
		data_t_tb.setCellValueFactory(new PropertyValueFactory<>("data"));
		
		tabela_transacao_tb.setItems(FXCollections.observableArrayList(ts));
		
	}
	
}
