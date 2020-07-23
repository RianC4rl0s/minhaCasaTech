package br.com.minhaCasaTech.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import br.com.minhaCasaTech.model.BO.CaixaBO;
import br.com.minhaCasaTech.model.BO.ClienteBO;
import br.com.minhaCasaTech.model.BO.CompraBO;
import br.com.minhaCasaTech.model.BO.EquipamentoBO;
import br.com.minhaCasaTech.model.BO.LocalBO;
import br.com.minhaCasaTech.model.BO.ResponsavelBO;
import br.com.minhaCasaTech.model.BO.VendaBO;
import br.com.minhaCasaTech.model.VO.ClienteVO;
import br.com.minhaCasaTech.model.VO.CompraVO;
import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;
import br.com.minhaCasaTech.model.VO.VendaVO;
import br.com.minhaCasaTech.view.Telas;
import exception.InsertException;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class GerenciarVendaController implements Initializable {
	EquipamentoBO ebo = new EquipamentoBO();
	VendaBO vbo = new VendaBO();
	CaixaBO caixa = new CaixaBO();
	private static VendaVO venda = new VendaVO();
	
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
	@FXML private Label labelTotal;
	@FXML private Label saldoInsuficiente;
	@FXML private ComboBox<ClienteVO> clienteCB;
	@FXML private TitledPane qtdEquipamento;
	@FXML private TextField quantidade;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		iniciarTabelaEquipamentos();
		iniciarTabelaCarrinho();
		carregarCaixas();
		labelTotal.setText("R$ " + venda.getValorTotal());
	}
    
    public void iniciarTabelaEquipamentos() {
    	id_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("id_equipamento"));
    	nome_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	preco_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("preco"));
    	peso_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("peso"));
    	quantidade_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
    	ns_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("numeroDeSerie"));
	
    	local_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("local"));
    	reponsavel_coluna_tb.setCellValueFactory(new PropertyValueFactory<>("responsavel"));
    
    	tabela_equipamentos.setItems(FXCollections.observableArrayList(ebo.listar()));
    }
    
    public void iniciarTabelaCarrinho() {
    	id_carrinho.setCellValueFactory(new PropertyValueFactory<>("id_equipamento"));
    	nome_carrinho.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	preco_carrinho.setCellValueFactory(new PropertyValueFactory<>("preco"));
    	quantidade_carrinho.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
    	valorTotal_carrinho.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
    	
		tabela_carrinho.setItems(FXCollections.observableArrayList(venda.getEquipamentos()));
    }
    
    public void buscarEquipamento() {
    	
    }
    
    public void finalizarCompra() {
    	venda.setPesoTotal(0.00);
    	venda.setTotalEquip(0);
    	for(EquipamentoVO eqp : venda.getEquipamentos()) {
    		venda.setPesoTotal(venda.getPesoTotal()+eqp.getValorTotal());
    		venda.setTotalEquip(venda.getTotalEquip()+eqp.getQuantidade());
    	}
    	venda.setData();
    	
    
    	caixa.addValor(venda.getValorTotal());
    	try {
    		venda.setCliente(clienteCB.getValue());
    		venda.setTipo(0);
    		System.out.println(venda);
    		vbo.cadastrar(venda);
    		try {
    			Telas.telaPrincipal();
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	} catch (InsertException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
    
    public void carregarCaixas() {
		ClienteBO cbo = new ClienteBO();
		clienteCB.setItems(FXCollections.observableArrayList(cbo.listar()));
	}
    
    public void chamarTelaCadastrarEquipamento() {
		try {
			Telas.telaCadastrarEquipamentoVP();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
    
    public void removeEquipamento() {
    	TableViewSelectionModel<EquipamentoVO> selectionModel = tabela_carrinho.getSelectionModel();
    	if(selectionModel.getSelectedItem() != null) {
    		EquipamentoVO eqpTabelaCarrinho = selectionModel.getSelectedItem();
    		venda.setValorTotal(venda.getValorTotal()-eqpTabelaCarrinho.getValorTotal());
    		
    		EquipamentoVO eqpTabelaEquipamento = ebo.buscarPorId(eqpTabelaCarrinho);
    		eqpTabelaEquipamento.setQuantidade(eqpTabelaEquipamento.getQuantidade()+eqpTabelaCarrinho.getQuantidade());
    		ebo.editar(eqpTabelaEquipamento);
    		
    		venda.removeEquipamento(eqpTabelaCarrinho);
    		try {
    			Telas.telaGerenciarCompra();
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    	else
    		noEquipamento.setVisible(true);
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
    		if(qtd.equals("") || !qtd.matches("(.*)([1-9])(.*)"))
    			qtdInvalida.setVisible(true);
    		else {
    			qtdEquipamento.setVisible(false);
    			EquipamentoVO eqpTabela = selectionModel.getSelectedItem();
    			// BUG DE CANCELAR A COMPRA NO MEIO DA OPERAÇÃO
    			eqpTabela.setQuantidade(eqpTabela.getQuantidade()-Integer.parseInt(qtd));
    			ebo.editar(eqpTabela);
    			EquipamentoVO eqpCarrinho = eqpTabela;
    			eqpCarrinho.setQuantidade(Integer.parseInt(qtd));
    			eqpCarrinho.setValorTotal();
    			venda.addEquipamento(eqpCarrinho);
    			venda.setValorTotal(venda.getValorTotal()+eqpCarrinho.getValorTotal());
    			try {
    				Telas.telaGerenciarVenda();
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
