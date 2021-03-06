package edu.db.myBrute.controller;

import edu.db.myBrute.data.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/signUp")
public class SignUpCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GameService gameService = GameService.getInstance();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (!password.equals(confirmPassword)) {
            request.setAttribute("message", "Passwords not match!");

            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

        try {
            gameService.signUp(username, password);

            response.sendRedirect("login");
        } catch (SQLException e) {
            e.printStackTrace();

            request.setAttribute("message", e.getMessage());

            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("signUp.jsp").forward(request, response);
    }
}
