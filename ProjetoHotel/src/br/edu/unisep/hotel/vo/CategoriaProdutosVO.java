package br.edu.unisep.hotel.vo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CategoriaProdutosVO {
	
	private SimpleIntegerProperty id;
	
	private SimpleStringProperty categoria;
	
	
	public CategoriaProdutosVO(){
		this.id = new SimpleIntegerProperty();
		this.categoria = new SimpleStringProperty();
	}
	
	public String toString(){
		return categoria.get();
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

	public SimpleStringProperty categoriaProperty() {
		return this.categoria;
	}

	public java.lang.String getCategoria() {
		return this.categoriaProperty().get();
	}

	public void setCategoria(final java.lang.String categoria) {
		this.categoriaProperty().set(categoria);
	}


	
}
