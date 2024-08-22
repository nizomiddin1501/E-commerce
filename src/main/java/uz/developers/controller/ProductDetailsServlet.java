package uz.developers.controller;

import uz.developers.model.Product;
import uz.developers.service.DbConnection;
import uz.developers.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/productDetails")
public class ProductDetailsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));
        ProductService productDao = new ProductService(DbConnection.getConnection());
        Product product = productDao.getProductById(productId);

        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("productDetails.jsp");
        dispatcher.forward(request, response);
    }

}
