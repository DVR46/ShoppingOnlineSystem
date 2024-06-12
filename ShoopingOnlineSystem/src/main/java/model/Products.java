package model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Products {
	private int id;
	private static String image = "https://resource.logitechg.com/d_transparent.gif/content/dam/gaming/en/products/g203/g203-gallery-1.png";
	private String name;
	private String description;
	private double price;
	private Timestamp datetime;
	
	public Products() {
		
	}

	public Products( int id, String name, String description, double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Timestamp getDatetime() {
		return datetime;
	}
//	public void setDatetime() {
//		
//
//	}
	
}
