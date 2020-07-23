package br.com.minhaCasaTech.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import br.com.minhaCasaTech.model.BO.EquipamentoBO;
import br.com.minhaCasaTech.model.VO.CompraVO;
import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.view.Telas;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class GerenciarCompraController implements Initializable {
	private static CompraVO compra = new CompraVO();
	@FXML private TableView tabela_equipamentos;
	@FXML private TableColumn<EquipamentoVO, Long> id_coluna_tb;
	@FXML private TableColumn<EquipamentoVO, String> quantidade_coluna_tb;
    @FXML private TableColumn<EquipamentoVO, String> ns_coluna_tb;
    @FXML private TableColumn<EquipamentoVO, String> nome_coluna_tb;
    @FXML private TableColumn<EquipamentoVO, Double> peso_coluna_tb;
    @FXML private TableColumn<EquipamentoVO, String> reponsavel_coluna_tb;
    @FXML private TableColumn<EquipamentoVO, Double> preco_coluna_tb;
    @FXML private TableColumn<EquipamentoVO, LocalVO> local_coluna_tb;
	@FXML private TableView tabela_carrinho;
	@FXML private TableColumn<EquipamentoVO, Long> id_carrinho;
	@FXML private TableColumn<EquipamentoVO, Integer> quantidade_carrinho;
    @FXML private TableColumn<EquipamentoVO, String> nome_carrinho;
    @FXML private TableColumn<EquipamentoVO, Double> preco_carrinho;
    @FXML private TableColumn<EquipamentoVO, Double> valorTotal_carrinho;
	
	@FXML private Label noEquipamento;
	@FXML private Label qtdInvalida;
	@FXML private TitledPane qtdEquipamento;
	@FXML private TextField quantidade;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		iniciarTabelaEquipamentos();
		iniciarTabelaCarrinho();
	}
    
    public void iniciarTabelaEquipamentos() {
    	id_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("id"));
    	nome_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	preco_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("preco"));
    	peso_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("peso"));
    	quantidade_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
    	ns_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("numeroDeSerie"));
	
    	local_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("local"));
    	reponsavel_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("responsavel"));
    	
    	EquipamentoBO ebo = new EquipamentoBO();
    	tabela_equipamentos.setItems(FXCollections.observableArrayList(ebo.listar()));
    }
    
    public void iniciarTabelaCarrinho() {
    	id_carrinho.setCellValueFactory(new PropertyValueFactory<>("id"));
    	nome_carrinho.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	preco_carrinho.setCellValueFactory(new PropertyValueFactory<>("preco"));
    	quantidade_carrinho.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
    	valorTotal_carrinho.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
    	
		tabela_carrinho.setItems(FXCollections.observableArrayList(compra.getEquipamentos()));
    }
    
    public void buscarEquipamento() {
    	
    }
    
    public void finalizarCompra() {
    	
    }
    
    public void removeEquipamento() {
    	
    }
    
    public void mostrarAddQuantidade() {
    	TableViewSelectionModel<EquipamentoVO> selectionModel = tabela_equipamentos.getSelectionModel();
    	if(selectionModel.getSelectedItem() == null) {
    		noEquipamento.setVisible(true);
    	} else {
    		System.out.print("Oi");
    		qtdEquipamento.toFront();
    	}
    }
    
    public void addEquipamento() {
    	TableViewSelectionModel<EquipamentoVO> selectionModel = tabela_equipamentos.getSelectionModel();
    	if(selectionModel.getSelectedItem() == null) {
    		noEquipamento.setVisible(true);
    	} else {
    		String qtd = quantidade.getText();
    		if(qtd.equals("") || !qtd.matches("(.*)([0-9])(.*)"))
    			qtdInvalida.setVisible(true);
    		else {
    			qtdEquipamento.setVisible(false);
    			EquipamentoVO eqp = selectionModel.getSelectedItem();
    			eqp.setQuantidade(Integer.parseInt(qtd));
    			eqp.setValorTotal();
    			compra.addEquipamento(eqp);
    			try {
    				Telas.telaGerenciarCompra();
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
    	}
    }
    
    public void cancelarOperacao() {
		try {
			quantidade.clear();
			qtdEquipamento.toBack();
		}catch(Exception e) {
			e.printStackTrace();
		}
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

}
