package edu.db.myBrute.controller;

import edu.db.myBrute.data.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GameService gameService = GameService.getInstance();

        try {
            if (gameService.currentUser() != null) {
                request.setAttribute("message", "You are already logged in!");

                request.getRequestDispatcher("error.jsp").forward(request, response);
            } else {
                gameService.login(request.getParameter("username"), request.getParameter("password"));

                response.sendRedirect("home");
            }
        } catch (IllegalArgumentException | SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", e.getMessage());

            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
