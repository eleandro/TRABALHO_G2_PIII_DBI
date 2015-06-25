package br.edu.unisep;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController implements Initializable {
	@FXML
	private Label lblMenssagem;
	@FXML
	private TextField txtNome;
	@FXML
	private PasswordField txtSenha;
	
	
	@FXML
	private void login(ActionEvent event){
		if(txtNome.getText().equals("admin") && txtSenha.getText().equals("admin")){
			((Node) (event.getSource())).getScene().getWindow().hide();
			try{
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("view/TelaPrincipalHotel.fxml"));
			Scene scene = new Scene(root);
			
			Stage janela = new Stage();
			janela.setScene(scene);
			janela.setMaximized(true);
			janela.setTitle("Sistema Hotel");
			janela.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		}else{
			lblMenssagem.setText("USUARIO OU SENHA INVALIDO!");
		}
		
	}
	
	   

	
	@FXML
	private void cancelar(ActionEvent event){
		txtNome.setText("");
		txtSenha.setText("");
	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
	
	
}
