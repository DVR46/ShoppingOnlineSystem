package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connect.ConnectUtils;
import model.Products;

public class HomeService {
	public static ArrayList<Products> displayProducts(int index, int displayQuantity) {
		ArrayList<Products>  products = new ArrayList<Products>();
		try {
			Connection conn = ConnectUtils.openConnect();
			String sql = "SELECT * FROM products ORDER BY date DESC LIMIT ? OFFSET ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, displayQuantity);
			stmt.setInt(2, displayQuantity*(index-1));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Products product = new Products();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				products.add(product);
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return products;
	}
	
	public static double quantityProducts(int displayQuantity) {
		int count = 0;
		try {
			Connection conn = ConnectUtils.openConnect();
			String sql = "SELECT * FROM products";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				count ++;
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		double quantity = count/(double)(1.0*displayQuantity);
		return Math.ceil(quantity);
	}
}
