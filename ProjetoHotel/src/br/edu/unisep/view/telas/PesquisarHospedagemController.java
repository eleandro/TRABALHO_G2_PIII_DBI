package br.edu.unisep.view.telas;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import br.edu.unisep.hotel.dao.HospedagemDAO;
import br.edu.unisep.hotel.vo.HospedagemVO;
import br.edu.unisep.hotel.vo.RelatorioVO;


public class PesquisarHospedagemController implements Initializable{
	
	
	@FXML private DatePicker txtDataEntrada;
	@FXML private DatePicker txtDataSaida;
	
	@FXML private TableView <HospedagemVO> tabHospedagem;
	
	
	@FXML private TableColumn<HospedagemVO, LocalDate> colDataEntrda;
	@FXML private TableColumn<HospedagemVO, LocalDate> colDataSaida;
	@FXML private TableColumn<HospedagemVO, Integer> colHopedagem;
	
	
	private ObservableList<HospedagemVO> listaHospedagem;
	
	public void pesquisar(ActionEvent event){
		
		RelatorioVO relatorio = new RelatorioVO();
		relatorio.setDataInicial(txtDataEntrada .getValue());
		relatorio.setDataFinal(txtDataSaida.getValue());
		
				
		HospedagemDAO dao = new HospedagemDAO();
				
	
		List<HospedagemVO> pesquisar = dao.pesquisar(relatorio);
		listaHospedagem.setAll(pesquisar);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		HospedagemDAO dao = new HospedagemDAO();
		List<HospedagemVO> lista = dao.listar();		
		
		listaHospedagem = FXCollections.observableArrayList(lista);
		
		
		
		colDataEntrda.setCellValueFactory(new PropertyValueFactory<HospedagemVO, LocalDate>("dataEntrada"));
		colDataSaida.setCellValueFactory(new PropertyValueFactory<HospedagemVO, LocalDate>("dataSaida"));
		colHopedagem.setCellValueFactory(new PropertyValueFactory<HospedagemVO, Integer>("diaria"));
		
		
		tabHospedagem.setItems(listaHospedagem);
	}
}
