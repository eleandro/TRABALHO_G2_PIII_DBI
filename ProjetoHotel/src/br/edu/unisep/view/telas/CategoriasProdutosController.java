package br.edu.unisep.view.telas;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import br.edu.unisep.hotel.dao.CategoriasProdutosDAO;
import br.edu.unisep.hotel.vo.CategoriaProdutosVO;


public class CategoriasProdutosController implements Initializable{ 
	
	@FXML
	private TableView<CategoriaProdutosVO> tabCategoria;
	

	@FXML
	private TableColumn<CategoriaProdutosVO, String> colCategoria;
	
	@FXML
	private TextField txtCategorias;
	
	private ObservableList<CategoriaProdutosVO>listaCategorias;
	
	private CategoriaProdutosVO categoriaProduto;
	
	@FXML
	public void salvar(ActionEvent event){
		if(validarCampos()){
			
		
		CategoriasProdutosDAO dao = new CategoriasProdutosDAO();
 		dao.salvar(categoriaProduto);
 		
		configurarCamposTela();
		
		
 		
 		List<CategoriaProdutosVO> lista = dao.listar();
 		listaCategorias.setAll(lista);
	}
	
		
		return;
	}
	@FXML
	public void excluir(ActionEvent event){		
	
		
		CategoriaProdutosVO categorias = tabCategoria.getSelectionModel().getSelectedItem();
		
		if(categorias != null){
			CategoriasProdutosDAO dao = new CategoriasProdutosDAO();
			dao.excluir(categorias);
			
			List<CategoriaProdutosVO > lista = dao.listar();
			listaCategorias.setAll(lista);
		}
	}
	
	private boolean validarCampos(){

		
		if(txtCategorias.getText().trim().equals("")){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Campos Obrigatório!");
			alert.setHeaderText(null);
			alert.setContentText("O Campo Categoria é Obrigatório!");
			alert.showAndWait();
			txtCategorias.requestFocus();
			return false;
		}
		return true;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		configurarCamposTela();
		
		CategoriasProdutosDAO dao = new CategoriasProdutosDAO();		
		List<CategoriaProdutosVO> lista = dao.listar();
		
		listaCategorias = FXCollections.observableArrayList(lista);
		
		colCategoria.setCellValueFactory(new PropertyValueFactory<CategoriaProdutosVO, String>("categoria"));
		
		tabCategoria.setItems(listaCategorias);
	}
	
	private void configurarCamposTela(){
		
		this.categoriaProduto = new CategoriaProdutosVO();
		
		Bindings.bindBidirectional(txtCategorias.textProperty(), categoriaProduto.categoriaProperty());
		
	}
}
