package br.edu.unisep.hotel.vo;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProdutosVO {
	
	private SimpleIntegerProperty id;
	
	private SimpleStringProperty produto;
	
	private SimpleDoubleProperty valorUnitarioProduto;
	
	private SimpleIntegerProperty quantidadeProduto;
	
	private SimpleObjectProperty<CategoriaProdutosVO> catProdutos;
	 
	public ProdutosVO(){
		this.id = new SimpleIntegerProperty();
		this.produto = new SimpleStringProperty();
		this.valorUnitarioProduto = new SimpleDoubleProperty();
		this.quantidadeProduto = new SimpleIntegerProperty();
		this.catProdutos = new SimpleObjectProperty<>();
	}
	
	public String toString(){
		return produto.get();
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

	public SimpleStringProperty produtoProperty() {
		return this.produto;
	}

	public java.lang.String getProduto() {
		return this.produtoProperty().get();
	}

	public void setProduto(final java.lang.String produto) {
		this.produtoProperty().set(produto);
	}

	public SimpleDoubleProperty valorUnitarioProdutoProperty() {
		return this.valorUnitarioProduto;
	}

	public double getValorUnitarioProduto() {
		return this.valorUnitarioProdutoProperty().get();
	}

	public void setValorUnitarioProduto(final double valorUnitarioProduto) {
		this.valorUnitarioProdutoProperty().set(valorUnitarioProduto);
	}

	public SimpleIntegerProperty quantidadeProdutoProperty() {
		return this.quantidadeProduto;
	}

	public int getQuantidadeProduto() {
		return this.quantidadeProdutoProperty().get();
	}

	public void setQuantidadeProduto(final int quantidadeProduto) {
		this.quantidadeProdutoProperty().set(quantidadeProduto);
	}

	public SimpleObjectProperty<CategoriaProdutosVO> catProdutosProperty() {
		return this.catProdutos;
	}

	public br.edu.unisep.hotel.vo.CategoriaProdutosVO getCatProdutos() {
		return this.catProdutosProperty().get();
	}

	public void setCatProdutos(
			final br.edu.unisep.hotel.vo.CategoriaProdutosVO catProdutos) {
		this.catProdutosProperty().set(catProdutos);
	}
	
	
	
	
}
