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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import br.edu.unisep.hotel.dao.ConsumoDAO;
import br.edu.unisep.hotel.dao.HospedagemDAO;
import br.edu.unisep.hotel.dao.ProdutosDAO;
import br.edu.unisep.hotel.vo.ConsumoVO;
import br.edu.unisep.hotel.vo.HospedagemVO;
import br.edu.unisep.hotel.vo.ProdutosVO;


public class ConsumoController implements Initializable{
	
	@FXML
	private ComboBox<ProdutosVO> cmbProduto;
	@FXML
	private ComboBox<HospedagemVO> cmbHospedagem;
	@FXML
	private TextField txtValorUnitario;
	@FXML
	private TextField txtTotalProdutos;
	@FXML
	private TextField txtQuantidade;
	@FXML
	private TextField txtTotalConsumo;
	
	@FXML private TableView <ConsumoVO> tabConsumo;
	
	
	@FXML private TableColumn<ConsumoVO, String> colProduto;
	@FXML private TableColumn<ConsumoVO, Integer> colQuantidade;
	@FXML private TableColumn<ConsumoVO, Double> colvalorUnitario;
	@FXML private TableColumn<ConsumoVO, Double> colValorTotal;
	
	private ObservableList<ProdutosVO> listaProdutos;
	private ObservableList<HospedagemVO> listaHospedagem;
	private ObservableList<ConsumoVO> listaConsumo;
	
	private ConsumoVO consumo;
	
	private void obetertListaProdutos(){
		ProdutosDAO dao = new ProdutosDAO();
		List< ProdutosVO>lista = dao.listar();
		
		listaProdutos = FXCollections.observableArrayList();
		listaProdutos.setAll(lista);
		
		cmbProduto.setItems(listaProdutos);
	}
	
	private void obeterListaHospedagem(){
		HospedagemDAO dao = new HospedagemDAO();
		List<HospedagemVO> lista = dao.listar();
		
		listaHospedagem = FXCollections.observableArrayList();
		listaHospedagem.setAll(lista);
		
		cmbHospedagem.setItems(listaHospedagem);
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		configurarCamposTela(); 
		obetertListaProdutos();
		obeterListaHospedagem();
		listarProdutos(); 
			
		 
	}
	
	@FXML
	public void finalizar(ActionEvent event){
		this.consumo = new ConsumoVO();
		
		ConsumoDAO dao = new ConsumoDAO();
		dao.atualizarConsumo(consumo);
		
			
		
	}
				
	public void incluirProdutos(ActionEvent event){
		if(!validarCampos()){
			return;
		}
		ConsumoDAO dao = new ConsumoDAO();
		dao.salvar(consumo);
		
		configurarCamposTela();
		
		listarProdutos();
		
	}
	
	@FXML
	public void cancelar(ActionEvent event){
		cmbHospedagem.setValue(null);
		cmbProduto.setValue(null);
		txtQuantidade.setText("");
		txtValorUnitario.setText("");
		txtTotalConsumo.setText("");
	}
	
	
		
	
	@FXML
	public void excluir(ActionEvent event){		
	
		
		ConsumoVO consumo = tabConsumo.getSelectionModel().getSelectedItem();
		
		if(consumo != null){
			ConsumoDAO dao = new ConsumoDAO();
			dao.excluir(consumo);
			
			List<ConsumoVO> lista = dao.listar();
			listaConsumo.setAll(lista);
		}
	}

	public void configurarCamposTela(){
		this.consumo = new ConsumoVO();
		
		Bindings.bindBidirectional(cmbHospedagem.valueProperty(),consumo.hospedagemProperty());
		Bindings.bindBidirectional(cmbProduto.valueProperty(), consumo.produtosProperty());
		try{
			NumberFormat nf = NumberFormat.getInstance();
			Bindings.bindBidirectional(txtQuantidade.textProperty(), consumo.quantidadeConsumoProperty(),nf);
		}catch(NumberFormatException ex){
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
			Bindings.bindBidirectional(txtValorUnitario.textProperty(), consumo.valorTotalUnitarioProperty(), df);
		}catch(NumberFormatException EX){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setContentText("Este Valor " + "'"+ txtValorUnitario.getText() + "'" + " Não é Valido!");
			alert.showAndWait();
			txtValorUnitario.requestFocus();
			return;			
		}
		
		try{
			DecimalFormat df = new DecimalFormat();		
			Bindings.bindBidirectional(txtTotalProdutos.textProperty(), consumo.valorTotalProperty(), df);
		}catch(NumberFormatException EX){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setContentText("Este Valor " + "'"+ txtTotalProdutos.getText() + "'" + " Não é Valido!");
			alert.showAndWait();
			txtTotalProdutos.requestFocus();
			return;			
		}
		
		
		
	}
	
	public void listarProdutos() {
		ConsumoDAO dao = new ConsumoDAO();
		List<ConsumoVO> lista = dao.listar();		
		
		listaConsumo = FXCollections.observableArrayList(lista);
		
		colProduto.setCellValueFactory(new PropertyValueFactory<ConsumoVO, String>("produtos"));
		colQuantidade.setCellValueFactory(new PropertyValueFactory<ConsumoVO, Integer>("quantidadeConsumo"));
		colvalorUnitario.setCellValueFactory(new PropertyValueFactory<ConsumoVO, Double>("valorTotalUnitario"));
		colValorTotal.setCellValueFactory(new PropertyValueFactory<ConsumoVO, Double>("valorTotal"));
		
		tabConsumo.setItems(listaConsumo);
	}
	
	
	private boolean validarCampos(){
		if(txtQuantidade.getText().trim().equals("")){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Campos Obrigatório!");
			alert.setHeaderText(null);
			alert.setContentText("O Campo Quantidade é Obrigatório!");
			alert.showAndWait();
 			txtQuantidade.requestFocus();
 			return false;
 		}
		
		if(txtValorUnitario.getText().trim().equals("")){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Campos Obrigatório!");
			alert.setHeaderText(null);
			alert.setContentText("O Campo Valor Unitario é Obrigatório!");
			alert.showAndWait();
 			txtValorUnitario.requestFocus();
 			return false;
 		}
		
		
		return true;
	}
}
