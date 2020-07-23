package br.com.minhaCasaTech.controller;

import java.net.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.minhaCasaTech.model.BO.ClienteBO;

import br.com.minhaCasaTech.model.VO.ClienteVO;

import br.com.minhaCasaTech.view.Telas;
import exception.InsertException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;

public class GerenciarClienteController implements Initializable{

	@FXML
    private Button sair_btm;

    @FXML
    private TableView<ClienteVO> tabela_cliente_tb;

    @FXML
    private TableColumn<ClienteVO, String> cpf_cliente_tb;

    @FXML
    private Button excluir_cliente_btm;

    @FXML
    private TableColumn<ClienteVO, String> nome_cliente_tb;

    @FXML
    private Button cadastrar_cliente_btm;

    @FXML
    private Button editar_cliente_btm;

    @FXML
    private TableColumn<ClienteVO,String > endereco_cliente_tb;

    @FXML
    private Button recarregar_btm;

    @FXML
    private Button voltar_btm;
	public void initialize(URL url, ResourceBundle rb) {
		iniciarTabela();
	}
	public void iniciarTabela() {
		List<ClienteVO> clientes = new ArrayList<>();
		nome_cliente_tb.setCellValueFactory(new PropertyValueFactory<>("nome"));
		endereco_cliente_tb.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		cpf_cliente_tb.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		ClienteBO cbo = new ClienteBO();
		clientes = cbo.listar();
		tabela_cliente_tb.setItems(FXCollections.observableArrayList(clientes));
	}
	public void chamarTelaCadastrarCliente() {
		try {
			Telas.telaCadastrarCliente();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public void excluirItem() {
			ClienteBO cbo = new ClienteBO();
			TableViewSelectionModel<ClienteVO> selectionModel = tabela_cliente_tb.getSelectionModel();
		
			try {
				cbo.deletar(selectionModel.getSelectedItem());
			} catch (InsertException e) {
				
				e.printStackTrace();
			}
		 recarregarTela();
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
			
			e.printStackTrace();
		}
	}
	   public void recarregarTela() {
				try {
					Telas.telaGerenciarCliente();
				}catch(Exception e) {
					e.printStackTrace();
				}
		    }

	    @FXML
	    private Label exception_jlb;
	   public void editarItem() {
		   try {  
				exception_jlb.setText("");
				TableViewSelectionModel<ClienteVO> selectionModel = tabela_cliente_tb.getSelectionModel();
				System.out.println(selectionModel.getSelectedItem().toString());
				chamarTelaEditarCliente(selectionModel.getSelectedItem());
			}catch(Exception e) {
				exception_jlb.setText("Nenhum item selecionado");
			}
	   }
	   public void chamarTelaEditarCliente(ClienteVO c) {
		   try {
			Telas.telaEditarCliente(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
}
