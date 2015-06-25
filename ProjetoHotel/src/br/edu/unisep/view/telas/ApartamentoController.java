package br.edu.unisep.view.telas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import br.edu.unisep.hotel.dao.ApartamentoDAO;
import br.edu.unisep.hotel.vo.ApartamentoVO;


public class ApartamentoController implements Initializable{
	
	@FXML
	private TextField txtApartamento;
	@FXML
	private TextField txtCategoria;
	@FXML
	private TextField txtCapacidade;
		
	@FXML
	private TextArea txtAreaObs;
	
	private ApartamentoVO apartamento;
	
	
@FXML public void salvar(ActionEvent event){
	
	if(!validarCampos()){
		return;
		}
	
	ApartamentoDAO dao = new ApartamentoDAO();
	dao.Salvar(apartamento);
		
	this.apartamento = new ApartamentoVO();
	
	Bindings.bindBidirectional(txtApartamento.textProperty(), apartamento.numeroApartamentoProperty());
	Bindings.bindBidirectional(txtCategoria.textProperty(), apartamento.categoriaProperty());
	Bindings.bindBidirectional(txtCapacidade.textProperty(), apartamento.capacidadeProperty());
	Bindings.bindBidirectional(txtAreaObs.textProperty(), apartamento.observacaoProperty());
	
	
}

@FXML
public void cancelar (ActionEvent event){
	
	txtApartamento.setText("");
	txtCategoria.setText("");
	txtCapacidade.setText("");
	txtAreaObs.setText("");	
	txtApartamento.requestFocus();
}


@Override
public void initialize(URL location, ResourceBundle resources) {
	
	//configurarCamposTela();
	
}

//private void configurarCamposTela(){
	
	
//}


private boolean validarCampos(){	 
		
	if(txtApartamento.getText().trim().equals("")){
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Campos Obrigat�rio!");
		alert.setHeaderText(null);
		alert.setContentText("O Campo Apartamento � Obrigat�rio!");
		alert.showAndWait();
		txtApartamento.requestFocus();
		return false;
	}
	if(txtCategoria.getText().trim().equals("")){
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Campos Obrigat�rio!");
		alert.setHeaderText(null);
		alert.setContentText("O Campo Categoria � Obrigat�rio!");
		alert.showAndWait();
		txtCategoria.requestFocus();
		return false;
	
	}
	
	if(txtCapacidade.getText().trim().equals("")){
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Campos Obrigat�rio!");
		alert.setHeaderText(null);
		alert.setContentText("O Campo Capacidade � Obrigat�rio!");
		alert.showAndWait();
		txtCapacidade.requestFocus();
		return false;
	
	}
	return true;
   
}
	


}