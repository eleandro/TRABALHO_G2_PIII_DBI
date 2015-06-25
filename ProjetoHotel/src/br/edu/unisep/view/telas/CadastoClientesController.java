package br.edu.unisep.view.telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import br.edu.unisep.hotel.dao.ClientesDAO;
import br.edu.unisep.hotel.vo.ClientesVO;

public class CadastoClientesController {
	
    @FXML private TextField txtNome;
	
	@FXML private TextField txtCPF;
	
	@FXML private TextField txtRG;
	
	@FXML private TextField txtEndereco;
	
	@FXML private TextField txtCidade;
	
	@FXML private TextField txtTelefone;
	
	@FXML private TextField txtEmail;
	
	@FXML
	public void salvar(ActionEvent event){
		

		if(!validarCampos()){
			return;
		}
		
		ClientesVO cliente = new ClientesVO();
		
		cliente.setNome(txtNome.getText());
		cliente.setCPF(txtCPF.getText());
		cliente.setRG(txtRG.getText());
		cliente.setEndereco(txtEndereco.getText());
		cliente.setCidade(txtCidade.getText());
		cliente.setTelefone(txtTelefone.getText());
		cliente.setEmail(txtEmail.getText());
		
		ClientesDAO dao = new ClientesDAO();
		dao.incluir(cliente);
		
		txtNome.setText("");
		txtCPF.setText("");
		txtRG.setText("");
		txtEndereco.setText("");
		txtCidade.setText("");
		txtTelefone.setText("");
		txtEmail.setText("");
		
		
	}
	
	@FXML
	public void cancelar (ActionEvent event){
		
		txtNome.setText("");
		txtCPF.setText("");
		txtRG.setText("");
		txtEndereco.setText("");
		txtCidade.setText("");
		txtTelefone.setText("");
		txtEmail.setText("");	
		txtNome.requestFocus();
	}
	
private boolean validarCampos(){
				                            
		if(txtNome.getText().trim().equals("")){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Campos Obrigatório!");
			alert.setHeaderText(null);
			alert.setContentText("O Campo Nome é Obrigatório!");
			alert.showAndWait();
			txtNome.requestFocus();
			return false; 
		}		
		 
		if(txtCPF.getText().trim().equals("")){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Campos Obrigatório!");
			alert.setHeaderText(null);
			alert.setContentText("O Campo CPF é Obrigatório!");
			alert.showAndWait();
			txtCPF.requestFocus();
			return false;
		}				
		if(txtTelefone.getText().trim().equals("")){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Campos Obrigatório!");
			alert.setHeaderText(null);
			alert.setContentText("O Campo  Telefone é Obrigatório!");
			alert.showAndWait();
			txtTelefone.requestFocus();
			return false;
		}				
		if(txtCidade.getText().trim().equals("")){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Campos Obrigatório!");
			alert.setHeaderText(null);
			alert.setContentText("O Campo Cidade é Obrigatório!");
			alert.showAndWait();
			txtCidade.requestFocus();
			return false;
		}
		return true;
	}
	
	
}


