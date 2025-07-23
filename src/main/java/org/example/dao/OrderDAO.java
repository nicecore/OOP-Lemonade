package org.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.lemonadestand.model.Order;

public class OrderDAO {
    public OrderDAO () {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to find PostgreSQL Driver. Please ensure it is imported with Maven.");
        }

    
    }
 
    private Connection getDBConnection() throws SQLException {
        // Looks for a Driver already created in memory (that we created above)
        // Uses the Driver to make a connection, we pass it the name/pw
        return DriverManager.getConnection("jdbc:postgresql:localhost:5432/postgres", "postgres", "bondstone");
    }

    public Order getOrder(int id) {
        try {
            Connection connection = getDBConnection();
            PreparedStatement preparedStatement = getDBConnection().prepareStatement("SELECT * FROM order_table WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Order order = null;
            while (resultSet.next()) {
                order = new Order(resultSet.getInt("id"), resultSet.getDouble("total"));
                PreparedStatement customerStatement = connection.prepareStatement("SELECT * FROM customer WHERE id=?");
                customerStatement.setInt(1, resultSet.getInt("customer_id"));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        } 


    }
}
