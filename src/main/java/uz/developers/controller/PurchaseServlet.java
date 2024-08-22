package uz.developers.controller;

import uz.developers.model.Product;
import uz.developers.model.User;
import uz.developers.service.DbConnection;
import uz.developers.service.ProductService;
import uz.developers.service.UserProductService;
import uz.developers.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/purchase")
public class PurchaseServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int productId = Integer.parseInt(request.getParameter("productId"));

        ProductService productService = new ProductService(DbConnection.getConnection());
        Product product = productService.getProductById(productId);

        UserService userService = new UserService(DbConnection.getConnection());
        BigDecimal balance = BigDecimal.valueOf(userService.getUserBalance(user.getId()));
        BigDecimal productPrice = BigDecimal.valueOf(product.getPrice());

        if (balance.compareTo(productPrice) >= 0) {
            // Hisobni yangilash
            userService.updateUserBalance(user.getId(), balance.subtract(productPrice));

            // Mahsulotni foydalanuvchi hisobiga qo'shish
            UserProductService userProductService = new UserProductService(DbConnection.getConnection());
            userProductService.addProductToUser(user.getId(), productId);

            response.sendRedirect("purchaseConfirmation.jsp");
        } else {
            // Mablag' yetarli bo'lmagan holat
            response.sendRedirect("error.jsp?message=Insufficient+funds");
        }
    }
    }

