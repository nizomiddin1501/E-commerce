package uz.developers.service;

import uz.developers.model.User;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserService {


    private Connection connection;
    private String query;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public UserService(Connection connection) {
        this.connection = connection;
    }



    public User userLogin(String email, String password) {
        User user = null;
        try {
            query = "select * from users where email=? and password=?";
            preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                email = resultSet.getString(3);
                password = resultSet.getString(4);

                user = new User(id, name, email, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        return user;
    }


    public Double getUserBalance(int userId) {
        Double balance = Double.valueOf(0);
        try {
            query = "select balance from users where id = ?";
            preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                balance = resultSet.getDouble("balance");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        return balance;
    }


    public void updateUserBalance(int userId, BigDecimal newBalance) {
        try {
            query = "update users set balance = ? where id = ?";
            preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setBigDecimal(1, newBalance);
            preparedStatement.setInt(2, userId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
    }












}
