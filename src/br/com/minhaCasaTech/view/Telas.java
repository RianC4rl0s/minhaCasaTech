package br.com.minhaCasaTech.view;



import br.com.minhaCasaTech.controller.EditarEquipamentoController;
import br.com.minhaCasaTech.controller.EditarLocalController;
import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application {
private static Stage primaryStage;
	
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	public static void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}
	
	public static void main(String args[]) {
		launch();
		}
		
	public void start(Stage primaryStage) throws Exception {
		setPrimaryStage(primaryStage);
		primaryStage.setTitle("MinhaCasaTECH");
		primaryStage.show();
		telaLogin();
		
		
	}
	
	public static void telaLogin() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaLogin.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
	}
	public static void telaPrincipal() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaPrincipal.fxml"));
		
	    
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
		
	}
	public static void telaCadastrarEquipamento() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaCadastrarEquipamento.fxml"));
		
		Scene cena = new Scene(root);
		Stage secondarySage = new Stage();
		secondarySage.setTitle("MinhaCasaTECH");
		secondarySage.show();
		secondarySage.setScene(cena);
		
		
	}
	public static void telaGerenciarEquipamento() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaGerenciarEquipamento.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
		
	}
	public static void telaCadastrarResponsavel() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaCadastrarResponsavel.fxml"));
		Scene cena = new Scene(root);
		Stage secondarySage = new Stage();
		secondarySage.setScene(cena);
		secondarySage.setTitle("MinhaCasaTECH");
		secondarySage.show();
	
	}
	public static void telaGerenciarResponsavel() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaGerenciarResponsavel.fxml"));
		Scene cena  = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	public static void telaGerenciarCliente() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaGerenciarCliente.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	public static void telaGerenciarLocal() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaGerenciarLocal.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	public static void telaCadastrarLocal() throws Exception{

		Parent root = FXMLLoader.load(Telas.class.getResource("VE/CadastrarLocal.fxml"));
		Scene cena = new Scene(root);
		Stage secondaryStage = new Stage();
		secondaryStage.setTitle("MinaCasaTECH");
		secondaryStage.setScene(cena);
		secondaryStage.show();
	
	}	public static void telaEditarLocal(LocalVO local) throws Exception{
		 System.out.println("Tela aberta");
		FXMLLoader loader = new FXMLLoader(Telas.class.getResource("VE/EditarLocal.fxml"));
		
		 System.out.println("Loader criado");
		//	loader.setController(new EditarLocalController(local));
		 //FXMLLoader.load(Telas.class.getResource("VE/EditarLocal.fxml"));
		 FXMLLoader.load(Telas.class.getResource("VE/EditarLocal.fxml"));
		Parent root = loader.load();
		System.out.println("Loader criado");
		//EditarLocalController  controller = EditarLocalController.getMenuController();
		EditarLocalController controler = loader.getController();
		controler.setL(local);
		controler.setValores();
		Scene cena = new Scene(root);
		 System.out.println("Cena carregada");
		Stage secondaryStage = new Stage();
		secondaryStage.setTitle("MinaCasaTECH");
		secondaryStage.setScene(cena);
		secondaryStage.show();
		 System.out.println("chegou aq");
		System.out.println("Tela aberta");
	}
	public static void telaEditarEquipamento(EquipamentoVO equipamento) throws Exception{
		 System.out.println("Tela aberta");
		FXMLLoader loader = new FXMLLoader(Telas.class.getResource("VE/TelaEditarEquipamento.fxml"));
		
		 System.out.println("Loader criado");
		
		 FXMLLoader.load(Telas.class.getResource("VE/EditarLocal.fxml"));
		Parent root = loader.load();
		System.out.println("Loader criado");
		
		EditarEquipamentoController controler = loader.getController();
		controler.setE(equipamento);
		controler.setValores();
		Scene cena = new Scene(root);
		 System.out.println("Cena carregada");
		Stage secondaryStage = new Stage();
		secondaryStage.setTitle("MinaCasaTECH");
		secondaryStage.setScene(cena);
		secondaryStage.show();
		 System.out.println("chegou aq");
		System.out.println("Tela aberta");
	}
	
}
