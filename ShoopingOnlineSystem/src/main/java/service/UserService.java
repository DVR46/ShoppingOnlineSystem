package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectUtils;
import model.Products;
import model.users;

public class UserService {
	public static int findId(String userName, String password, int role) {
		int id = 0;
		try {
			Connection conn = ConnectUtils.openConnect();
			String sql = "select * from users where userName = ? and password = ? and role = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, userName);
			stmt.setString(2, password);
			stmt.setInt(3, role);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt("id");
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return id;
	}
	
	public static users findById(int id, int role) {
		users user = new users();
		
		try {
			Connection conn = ConnectUtils.openConnect();
			String sql = "select * from users where id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("userName"));
				user.setPassword("");
				user.setRole(role);
			}
			conn.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return user;
	}
	
	public static boolean createAccount(String userName, String password) {
		boolean check = true;
			try {
				Connection conn = ConnectUtils.openConnect();
				String sql = "INSERT INTO users(userName, password) VALUE (?, ?)";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, userName);
				stmt.setString(2, password);
				boolean rsCheck = stmt.execute();
				System.out.println(rsCheck);
//				if(stmt.execute() == false) {
//					check = false;
//				}
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return check;
	}
	
	
}
