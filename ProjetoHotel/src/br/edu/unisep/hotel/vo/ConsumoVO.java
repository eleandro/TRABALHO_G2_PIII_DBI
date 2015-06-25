package br.edu.unisep.hotel.vo;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class ConsumoVO {
	
	private SimpleIntegerProperty id;
	
	private SimpleDoubleProperty valorTotalUnitario;
	
	private SimpleDoubleProperty valorTotal;
	
	private SimpleIntegerProperty quantidadeConsumo;
	
	private SimpleObjectProperty< HospedagemVO> hospedagem;
	
	private SimpleObjectProperty<ProdutosVO> produtos;
	
	public ConsumoVO(){
		this.id = new SimpleIntegerProperty();
		this.valorTotalUnitario = new SimpleDoubleProperty();
		this.valorTotal = new SimpleDoubleProperty();
		this.quantidadeConsumo = new SimpleIntegerProperty();
		this.hospedagem = new SimpleObjectProperty<>();
		this.produtos = new SimpleObjectProperty<>();
	}

	public SimpleIntegerProperty idProperty() {
		return this.id;
	}

	public int getId() {
		return this.idProperty().get();
	}

	public void setId(final int id) {
		this.idProperty().set(id);
	}

	public SimpleDoubleProperty valorTotalUnitarioProperty() {
		return this.valorTotalUnitario;
	}

	public double getValorTotalUnitario() {
		return this.valorTotalUnitarioProperty().get();
	}

	public void setValorTotalUnitario(final double valorTotalUnitario) {
		this.valorTotalUnitarioProperty().set(valorTotalUnitario);
	}

	public SimpleDoubleProperty valorTotalProperty() {
		return this.valorTotal;
	}

	public double getValorTotal() {
		return this.valorTotalProperty().get();
	}

	public void setValorTotal(final double valorTotal) {
		this.valorTotalProperty().set(valorTotal);
	}

	public SimpleIntegerProperty quantidadeConsumoProperty() {
		return this.quantidadeConsumo;
	}

	public int getQuantidadeConsumo() {
		return this.quantidadeConsumoProperty().get();
	}

	public void setQuantidadeConsumo(final int quantidadeConsumo) {
		this.quantidadeConsumoProperty().set(quantidadeConsumo);
	}

	public SimpleObjectProperty<HospedagemVO> hospedagemProperty() {
		return this.hospedagem;
	}

	public br.edu.unisep.hotel.vo.HospedagemVO getHospedagem() {
		return this.hospedagemProperty().get();
	}

	public void setHospedagem(final br.edu.unisep.hotel.vo.HospedagemVO hospedagem) {
		this.hospedagemProperty().set(hospedagem);
	}

	public SimpleObjectProperty<ProdutosVO> produtosProperty() {
		return this.produtos;
	}

	public br.edu.unisep.hotel.vo.ProdutosVO getProdutos() {
		return this.produtosProperty().get();
	}

	public void setProdutos(final br.edu.unisep.hotel.vo.ProdutosVO produtos) {
		this.produtosProperty().set(produtos);
	}

	
	

}
