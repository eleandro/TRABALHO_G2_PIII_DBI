package br.edu.unisep.view.telas;


import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import br.edu.unisep.hotel.dao.CategoriasProdutosDAO;
import br.edu.unisep.hotel.dao.ProdutosDAO;
import br.edu.unisep.hotel.vo.CategoriaProdutosVO;
import br.edu.unisep.hotel.vo.ProdutosVO;

public class ProdutosController implements Initializable {
	
	public void abrirCategoriasProdutos(ActionEvent event) {
		Stage janela = new Stage();
		
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("CategoriaProdutos.fxml"));

			Scene scene = new Scene(root );
			janela.setScene(scene);			
			janela.setResizable(false);
			janela.setTitle("Categorias de Produtos");
			janela.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private TextField txtProduto;
	
	@FXML
	private TextField txtQuantidade;
	
	@FXML
	private TextField txtValorUnitario;
	
	@FXML
	private ComboBox<CategoriaProdutosVO> cmbCategoria;
	
	private ObservableList<CategoriaProdutosVO>listaCategorias;
	
	private ProdutosVO produto;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		oberteCategorias();
				
	}
	
	
	private void oberteCategorias(){
		CategoriasProdutosDAO dao = new CategoriasProdutosDAO();
 		List<CategoriaProdutosVO>lista = dao.listar();
 		
 		listaCategorias= FXCollections.observableArrayList();
 		listaCategorias.setAll(lista);
 		
 		cmbCategoria.setItems(listaCategorias);
 		
 	}

	
	@FXML public void salvar(ActionEvent event){
		
		if(!validarCampos()){
			return;
		}
		
		ProdutosDAO dao = new ProdutosDAO();
 		dao.incluir(produto);
					
 		this.produto =  new ProdutosVO();
		
		Bindings.bindBidirectional(txtProduto.textProperty(), produto.produtoProperty());
		Bindings.bindBidirectional(cmbCategoria.valueProperty(), produto.catProdutosProperty());
		
		try{
			NumberFormat nf = NumberFormat.getInstance();
			Bindings.bindBidirectional(txtQuantidade.textProperty(), produto.quantidadeProdutoProperty(),nf);
		}catch(NumberFormatException EX){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setContentText("Este Valor " + "'"+ txtQuantidade.getText() + "'" + " Não é Valido!");
			alert.showAndWait();
			txtQuantidade.requestFocus();
			return;			
		}
		
		try{
			DecimalFormat df = new DecimalFormat();		
			Bindings.bindBidirectional(txtValorUnitario.textProperty(), produto.valorUnitarioProdutoProperty(),df);
			
		}catch(NumberFormatException EX){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setContentText("Este Valor " + "'"+ txtValorUnitario.getText() + "'" + " Não é Valido!");
			alert.showAndWait();
			txtValorUnitario.requestFocus();
			return;			
		}
		
	}
	
	@FXML public void cancelar(ActionEvent event){
		txtProduto.setText("");
 		txtQuantidade.setText("");
 		txtValorUnitario.setText("");
 		cmbCategoria.setValue(null);
	}
	
	private boolean validarCampos(){
		if(txtProduto.getText().trim().equals("")){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Campos Obrigatório!");
			alert.setHeaderText(null);
			alert.setContentText("O Campo Nome é Obrigatório!");
			alert.showAndWait();
			txtProduto.requestFocus();
			return false; 
		}		
		 
		if(txtQuantidade.getText().trim().equals("")){
			
			txtQuantidade.requestFocus();
 			return false;
		}
		
		if(txtValorUnitario.getText().trim().equals("")){
			
 			txtValorUnitario.requestFocus();
 			return false;
		}
		return true;
			
	}
}
