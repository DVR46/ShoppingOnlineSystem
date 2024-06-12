package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectUtils;
import model.Products;

public class ProductService {
	public static ArrayList<Products> findAll(){
		ArrayList<Products>  products = new ArrayList<Products>();
		
		try {
			Connection conn = ConnectUtils.openConnect();
			String sql = "select * from products";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Products product = new Products();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				
				products.add(product);
				
//				System.out.println(rs.getInt("Prd_ID") + "  " + rs.getString("Prd_Name") + "  " + rs.getString("Prd_Description")  + "  " + rs.getDouble("Price"));
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return products;
	}
	
	
	
	public static Products findById(int id) {
		Products product = new Products();
		
		try {
			Connection conn = ConnectUtils.openConnect();
			String sql = "select * from products where id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return product;
	}
	
public static void removeById(int id) {
	try {
		Connection conn = ConnectUtils.openConnect();
		String sql = "DELETE FROM products WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
		
		conn.close();
	} catch (Exception ex) {
		ex.printStackTrace();
	}

	}

	public static void addProduct(String name, String description, double price) {
		
		try {
			Connection conn = ConnectUtils.openConnect();
			String sql = "INSERT INTO products(name, description, price, date) VALUE(?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, description);
			stmt.setDouble(3, price);
			java.util.Date jDate = new java.util.Date();
			java.sql.Timestamp sqlDate = new java.sql.Timestamp(jDate.getTime());
			stmt.setTimestamp(4, sqlDate);
			stmt.execute();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void editProduct(int id, String name, String description, double price) {
		try {
			Connection conn = ConnectUtils.openConnect();
			String sql = "UPDATE products SET name = ?, description = ?, price = ? WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, description);
			stmt.setDouble(3, price);
			stmt.setInt(4, id);
			stmt.execute();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		
		}
	}
	
	public static ArrayList<Products> searchProduct(String name) {
		ArrayList<Products>  products = new ArrayList<Products>();
		
		try {
			Connection conn = ConnectUtils.openConnect();
			String sql = "select * from products WHERE name LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + name + "%");
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
	

	
	
}
	
	


