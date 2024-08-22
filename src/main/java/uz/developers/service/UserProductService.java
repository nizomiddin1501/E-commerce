package uz.developers.service;

import uz.developers.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserProductService {


    private Connection connection;
    private String query;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public UserProductService(Connection connection) {
        this.connection = connection;
    }


    public void addProductToUser(int userId, int productId) {
        try {
            query = "insert into userproduct (user_id, product_id) values (?,?)";
            preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, productId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
    }




    public List<Product> getProductsByUserId(int userId) {
        List<Product> products = new ArrayList<>();
        try {
            query = "select product.* from product inner join userproduct on product.id = userproduct.user_id where userproduct.user_id = ?";
            preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1,userId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String photo = resultSet.getString("photo");
                Double price = resultSet.getDouble("price");
                String category = resultSet.getString("category");
                products.add(new Product(id,name,photo,price,category));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }






}
