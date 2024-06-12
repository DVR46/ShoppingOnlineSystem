package model;

public class Carts {
	private int id;
	private Products product;
	
	public Carts() {

	}

	public Carts(int id, Products product) {
		super();
		this.id = id;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}



	
	
	
	
}
