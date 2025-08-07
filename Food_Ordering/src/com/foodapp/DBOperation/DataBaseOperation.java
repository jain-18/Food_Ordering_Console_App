package com.foodapp.DBOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.foodapp.Service.MyConnection;
import com.foodapp.entity.User;

public class DataBaseOperation {

	public void addUser(User user) {
	    String query = "INSERT INTO user (firstName, lastName, email, address, password, mobileno) VALUES (?, ?, ?, ?, ?, ?)";

	    try (Connection conn = MyConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(query)) {

	        ps.setString(1, user.getFirstName());
	        ps.setString(2, user.getLastName());
	        ps.setString(3, user.getEmailId());
	        ps.setString(4, user.getAddress());
	        ps.setString(5, user.getPassword());  // Ideally hashed!
	        ps.setString(6, user.getMobileNo());

	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            System.out.println("✅ User registered successfully in database.");
	        } else {
	            System.out.println("❌ Registration failed.");
	        }

	    } catch (Exception e) {
	        System.out.println("🚨 Error during registration: " + e.getMessage());
	    }
	}

	public static boolean emailExists(String email) {
	    String query = "SELECT email FROM user WHERE email = ?";

	    try (Connection conn = MyConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(query)) {

	        ps.setString(1, email);
	        ResultSet rs = ps.executeQuery();

	        // If a record is found, the email exists
	        if(rs.next()) {
	        	System.out.println("Already Email exits!!");
	        	return false;
	        }
	        return true;

	    } catch (Exception e) {
	        System.out.println("🚨 Error checking email existence: " + e.getMessage());
	        return false;  // Assume not existing if error occurs (can adjust based on policy)
	    }
	}

	public static boolean validateUser(String email, String password) {
	    String query = "SELECT * FROM user WHERE email = ? AND password = ?";

	    try (Connection conn = MyConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(query)) {

	        ps.setString(1, email);
	        ps.setString(2, password);  // 🔐 Use hashed password in production

	        ResultSet rs = ps.executeQuery();

	        // If a match is found
	        return rs.next();

	    } catch (Exception e) {
	        System.out.println("🚨 Error while validating user: " + e.getMessage());
	        return false;
	    }
	}

	public static int userId(String email, String password) {
	    String query = "SELECT userid FROM user WHERE email = ? AND password = ?";

	    try (Connection conn = MyConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(query)) {

	        ps.setString(1, email);
	        ps.setString(2, password); 

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            return rs.getInt("userid");
	        } else {
	            return -1; // User not found
	        }

	    } catch (Exception e) {
	        System.out.println("🚨 Error fetching userId: " + e.getMessage());
	        return -1; // Error occurred
	    }
	}





}
