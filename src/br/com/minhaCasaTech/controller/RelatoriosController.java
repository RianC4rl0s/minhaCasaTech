package br.com.minhaCasaTech.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Stream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.minhaCasaTech.model.BO.CompraBO;
import br.com.minhaCasaTech.model.BO.TransacaoBO;
import br.com.minhaCasaTech.model.BO.VendaBO;
import br.com.minhaCasaTech.model.VO.CompraVO;
import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.model.VO.TransacaoVO;
import br.com.minhaCasaTech.model.VO.VendaVO;
import br.com.minhaCasaTech.view.Telas;
import exception.NotFoundException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class RelatoriosController implements Initializable {
	private TransacaoBO tbo = new TransacaoBO();
	private VendaBO vbo = new VendaBO();
	private CompraBO cbo = new CompraBO();
	
	static LocalDate localDateI;
	static LocalDate localDateF;
	
	@FXML private TableView tabela_vendas;
	@FXML private TableColumn<TransacaoVO, Long> id_coluna_tb1;
	@FXML private TableColumn<TransacaoVO, Double> vt_coluna_tb1;
    @FXML private TableColumn<TransacaoVO, Double> peso_coluna_tb1;
    @FXML private TableColumn<TransacaoVO, Integer> totalEqp_coluna_tb1;
    @FXML private TableColumn<TransacaoVO, Calendar> data_coluna_tb1;
	@FXML private TableView tabela_compras;
	@FXML private TableColumn<TransacaoVO, Long> id_coluna_tb2;
	@FXML private TableColumn<TransacaoVO, Double> vt_coluna_tb2;
    @FXML private TableColumn<TransacaoVO, Double> peso_coluna_tb2;
    @FXML private TableColumn<TransacaoVO, Integer> totalEqp_coluna_tb2;
    @FXML private TableColumn<TransacaoVO, Calendar> data_coluna_tb2;
    
    @FXML private DatePicker dI;
    @FXML private DatePicker dF;
    @FXML private Button verEqps;
    @FXML private Label noEquipamento;
    @FXML private Label data;
    @FXML private Label noData;
    @FXML private Label invalidData;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		iniciarTabelaCompras();
		iniciarTabelaVendas();
		
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		if (localDateI == null || localDateF == null)
			data.setText("Relatório de Hoje");
		else 
			data.setText("De: " + localDateI.format(pattern) + " Até: " + localDateF.format(pattern));
		
		data.setVisible(true);
	}
	
	public void iniciarTabelaVendas() {
    	id_coluna_tb1.setCellValueFactory(new PropertyValueFactory<>("id_transacao"));
    	vt_coluna_tb1.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
    	peso_coluna_tb1.setCellValueFactory(new PropertyValueFactory<>("pesoTotal"));
    	totalEqp_coluna_tb1.setCellValueFactory(new PropertyValueFactory<>("totalEquip"));
    	data_coluna_tb1.setCellValueFactory(new PropertyValueFactory<>("data"));
    	data_coluna_tb1.setCellFactory(coluna -> {
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
    
    	try {
    		Calendar cI = Calendar.getInstance();
    		if (localDateI != null)
    			cI.set(localDateI.getYear(),localDateI.getMonthValue()-1,localDateI.getDayOfMonth());
    		
    		Calendar cF = Calendar.getInstance();
    		if (localDateF != null)
    			cF.set(localDateF.getYear(),localDateF.getMonthValue()-1,localDateF.getDayOfMonth());    
    		
			tabela_vendas.setItems(FXCollections.observableArrayList(vbo.gerarRelatorio(cI, cF)));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
    }
	
	public void iniciarTabelaCompras() {
		id_coluna_tb2.setCellValueFactory(new PropertyValueFactory<>("id_transacao"));
    	vt_coluna_tb2.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
    	peso_coluna_tb2.setCellValueFactory(new PropertyValueFactory<>("pesoTotal"));
    	totalEqp_coluna_tb2.setCellValueFactory(new PropertyValueFactory<>("totalEquip"));
    	data_coluna_tb2.setCellValueFactory(new PropertyValueFactory<>("data"));
    	data_coluna_tb2.setCellFactory(coluna -> {
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
    
    	try {
    		Calendar cI = Calendar.getInstance();
    		if (localDateI != null)
    			cI.set(localDateI.getYear(),localDateI.getMonthValue()-1,localDateI.getDayOfMonth());
    		
    		Calendar cF = Calendar.getInstance();
    		if (localDateF != null)
    			cF.set(localDateF.getYear(),localDateF.getMonthValue()-1,localDateF.getDayOfMonth());    		
    		
			tabela_compras.setItems(FXCollections.observableArrayList(cbo.gerarRelatorio(cI, cF)));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
    }
	
	public void gerarRelatorio() {		
		try {			
			this.localDateI = dI.getValue();
			this.localDateF = dF.getValue();
			
			if (dI.getValue() == null && dF.getValue() == null) {
				noData.setVisible(true);
				return;
			}
			
			if (localDateF.isBefore(localDateI)) {
				noData.setVisible(false);
				noEquipamento.setVisible(false);
				invalidData.setVisible(true);
				return;
			}
			
			if (localDateI.isAfter(LocalDate.now())) {
				noData.setVisible(false);
				noEquipamento.setVisible(false);
				invalidData.setVisible(true);
				return;
			}
			
			gerarPDF();
			Telas.telaRelatorio();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void iniciarTabelaEquipamentos(TransacaoVO vo){
		try {
			Telas.telaMostrarEquipamentos(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void verEquipamentos() {
		TableViewSelectionModel<TransacaoVO> selectionModelVendas = tabela_vendas.getSelectionModel();
		TableViewSelectionModel<TransacaoVO> selectionModelCompras = tabela_compras.getSelectionModel();
    	if(selectionModelVendas.getSelectedItem() != null || selectionModelCompras.getSelectedItem() != null) {
    		if (selectionModelVendas.getSelectedItem() != null) {
    			iniciarTabelaEquipamentos(selectionModelVendas.getSelectedItem());
    		}else
    		{
    			iniciarTabelaEquipamentos(selectionModelCompras.getSelectedItem());
    		}
    	} else {
    		noEquipamento.setVisible(true);
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
    
    public void gerarPDF() {
    	Calendar cI = Calendar.getInstance();
		if (localDateI != null)
			cI.set(localDateI.getYear(),localDateI.getMonthValue()-1,localDateI.getDayOfMonth());
		
		Calendar cF = Calendar.getInstance();
		if (localDateF != null)
			cF.set(localDateF.getYear(),localDateF.getMonthValue()-1,localDateF.getDayOfMonth());   
    	
    	Document document = new Document();
    	try {
    		Calendar now = Calendar.getInstance();
			PdfWriter.getInstance(document, new FileOutputStream("relatorios/"+now.getTimeInMillis()+".pdf"));
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	document.open();
    	String strI = localDateI.getDayOfMonth() +"/"+ (localDateI.getMonthValue()) +"/"+ localDateI.getYear();
    	String strF = localDateF.getDayOfMonth() +"/"+ (localDateF.getMonthValue()) +"/"+ localDateF.getYear();
    	
    	Phrase phrase0 = new Phrase("Relatório de " + strI + " até " + strF);
    	
    	Phrase phrase1 = new Phrase("\nVendas: ");
    	PdfPTable tableVendas = new PdfPTable(5);
    	List<VendaVO> Vendas = null;
    	
    	try {
			Vendas = vbo.gerarRelatorio(cI, cF);
		} catch (NotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	addTableHeader(tableVendas);
    	addRowsTV(tableVendas, Vendas);
    	
    	Phrase phrase2 = new Phrase("Compras: ");
    	PdfPTable tableCompras = new PdfPTable(5);
    	List<CompraVO> Compras = null;
    	
    	try {
			Compras = cbo.gerarRelatorio(cI, cF);
		} catch (NotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	addTableHeader(tableCompras);
    	addRowsTC(tableCompras, Compras);
    	 
    	try {
			document.add(phrase0);
			document.add(phrase1);
			document.add(tableVendas);
			document.add(phrase2);
			document.add(tableCompras);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	document.close();
    	
    }
    
	private void addTableHeader(PdfPTable table) {
	    Stream.of("ID", "Valor Total", "Peso Total", "Quantidade Equipamentos", "Data")
	      .forEach(columnTitle -> {
	        PdfPCell header = new PdfPCell();
	        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        header.setBorderWidth(2);
	        header.setPhrase(new Phrase(columnTitle));
	        table.addCell(header);
	    });
	}
	
	private void addRowsTV(PdfPTable table, List<VendaVO> transacoes) {
		for (int i = 0; i < transacoes.size(); i++) {
			table.addCell(transacoes.get(i).getId_transacao().toString());
		    table.addCell(""+transacoes.get(i).getValorTotal());
		    table.addCell(""+transacoes.get(i).getPesoTotal());
		    table.addCell(""+transacoes.get(i).getTotalEquip());
		    Date d1 = new Date(transacoes.get(i).getData().getTimeInMillis());
		    table.addCell(""+ (d1.getDay()+1) + "/" + (d1.getMonth()+1) + "/" + (d1.getYear()+1900));
		}
	}
	
	private void addRowsTC(PdfPTable table, List<CompraVO> transacoes) {
		for (int i = 0; i < transacoes.size(); i++) {
			table.addCell(transacoes.get(i).getId_transacao().toString());
		    table.addCell(""+transacoes.get(i).getValorTotal());
		    table.addCell(""+transacoes.get(i).getPesoTotal());
		    table.addCell(""+transacoes.get(i).getTotalEquip());
		    Date d1 = new Date(transacoes.get(i).getData().getTimeInMillis());
		    table.addCell(""+ (d1.getDay()+1) + "/" + (d1.getMonth()+1) + "/" + (d1.getYear()+1900));
		}
	}
}
