package com.foodapp.DBOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.Service.MyConnection;
import com.foodapp.entity.DeliveryPartner;

public class DeliveryPartnerDAO {
	public List<DeliveryPartner> findAll() throws ClassNotFoundException {
        List<DeliveryPartner> partners = new ArrayList<>();
        String sql = "SELECT * FROM delivery_partners";

        try (Connection conn = MyConnection.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                partners.add(new DeliveryPartner(
                    rs.getInt("id"),
                    rs.getString("name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partners;
    }

    public void addPartner(String name) throws ClassNotFoundException {
        String sql = "INSERT INTO delivery_partners (name) VALUES (?)";
        try (Connection conn = MyConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
