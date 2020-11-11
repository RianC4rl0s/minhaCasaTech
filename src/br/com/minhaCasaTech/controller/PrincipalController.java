package br.com.minhaCasaTech.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
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
import javafx.scene.control.TableCell;
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
    //DECLARA AS COLUNAS
    @FXML
    private TableColumn<TransacaoVO, String> peso_t_tb;
    @FXML
    private TableColumn<TransacaoVO, String> totalP_t_tb;
    @FXML
    private TableColumn<TransacaoVO, String> tipo_t_tb;
	@FXML
    private TableColumn<TransacaoVO, String> valor_t_tb;
    //DECLARA A TABELA
	@FXML
    private TableView<TransacaoVO> tabela_transacao_tb;
	
	//COLUNA DO PROBLEMA
    @FXML
    private TableColumn<TransacaoVO, Calendar> data_t_tb;
    //FUN�AO A SER CHAMADA QUANDO INICIALIAR A TELA(TIPO UM MAIN)
    public void preencherTabela(){
		//LISTA
    	List<TransacaoVO> ts = new ArrayList<>();
		//CONEC��O  DO BANCCO
    	TransacaoBO tbo = new TransacaoBO();
		
		try {
			ts =tbo.listarPrincipal();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ISSO � PARA TESTAR O FORMATO DA DATA
		//int day =  ts.get(1).getData().get(Calendar.DAY_OF_MONTH);
		/*for(int i = 0; i < ts.size();i++) {
			System.out.println(ts.get(i));
		}*/
		//AQ � EU DEFINOQ QUAIS COLUNAS Q V�O RECEBER AS PROPRIEDADES DAS VARIAVEI COM OS NOME SMAIS A DIREITA
		peso_t_tb.setCellValueFactory(new PropertyValueFactory<>("pesoTotal"));
		totalP_t_tb.setCellValueFactory(new PropertyValueFactory<>("totalEquip"));
		tipo_t_tb.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		
		valor_t_tb.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
		//BO TA AQ
		data_t_tb.setCellValueFactory(new PropertyValueFactory<>("data"));
		data_t_tb.setCellFactory(coluna -> {
			return new TableCell<TransacaoVO,Calendar>(){
				//CRIA UM FORMATO
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				@Override
				protected void updateItem(Calendar item, boolean empty) {
					super.updateItem(item, empty);
					if(item == null||empty) {
						setText(null);
					}else {
						//.GETTIME RETORNA UM DATE POR ISSO O SIMPLEDATEFORMAT FUNCIONA
						setText(formato.format(item.getTime()));
					}
				}
			};
		});
		//AQ EU PEGO AQUELE ARRAYLIST E A FUN��O SETA ELE AUTOMATICAMENTE NA TABELA
		tabela_transacao_tb.setItems(FXCollections.observableArrayList(ts));
		
	}
	
}
