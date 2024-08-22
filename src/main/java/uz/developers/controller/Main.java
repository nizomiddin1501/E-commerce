package uz.developers.controller;

import uz.developers.service.DbConnection;
import uz.developers.service.ProductService;

public class Main {
    public static void main(String[] args) {

        ProductService productService = new ProductService(DbConnection.getConnection());
        System.out.println(productService.getAllProduct());














    }
}
