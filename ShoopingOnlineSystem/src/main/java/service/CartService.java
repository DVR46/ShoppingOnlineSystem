package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connect.ConnectUtils;
import model.Products;
import model.Carts;

public class CartService {
	public static ArrayList<Carts> findByUserId(int userId) {
		ArrayList<Carts> carts = new ArrayList<Carts>();
		
		try {
			Connection conn = ConnectUtils.openConnect();
			String sql = "SELECT * FROM cart WHERE userId = ? ORDER BY date DESC";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
//				carts cart = new carts(rs.getInt("id"), rs.getInt("userId"), rs.getInt("productId"));
//				carts.add(cart);
			}
			
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return carts;
	}
	
	public static ArrayList<Carts> showCart(int userId) {
		ArrayList<Carts> carts = new ArrayList<Carts>();
//		ArrayList<carts> carts = findByUserId(userId);
//		
//		for(int i = 0; i < carts.size(); i++) {
//				products.add(ProductService.findById(carts.get(i).getProductId()));
//		}
		
		
		try {
			Connection conn = ConnectUtils.openConnect();
			String sql = "SELECT c.id, productId, c.date, name, description, price FROM cart c JOIN products p ON c.productId = p.id WHERE userId = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Carts cart = new Carts();
				cart.setId(rs.getInt("id"));
				
				Products product = new Products();
				product.setId(rs.getInt("productId"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				cart.setProduct(product);
				
				carts.add(cart);
			}
			
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return carts;
	}
	
	public static void addToCart(int userId, int productId) {
		try {
			Connection conn = ConnectUtils.openConnect();
			String sql = "INSERT INTO cart(userId, productId, date) VALUE(?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userId);
			stmt.setInt(2, productId);
			java.util.Date jDate = new java.util.Date();
			java.sql.Timestamp sqlDate = new java.sql.Timestamp(jDate.getTime());
			stmt.setTimestamp(3, sqlDate);
			stmt.execute();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void deleteProduct(int cartId) {
		try {
			Connection conn = ConnectUtils.openConnect();
			String sql = "DELETE FROM cart WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cartId);
			stmt.execute();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
