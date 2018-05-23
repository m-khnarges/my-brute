package edu.db.myBrute.controller;

import edu.db.myBrute.data.UserRepo;

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
        UserRepo userRepo = UserRepo.getInstance();

        try {
            if (userRepo.currentUser() != null) {
                request.setAttribute("message", "You are already logged in!");

                request.getRequestDispatcher("error.jsp").forward(request, response);
            } else {
                userRepo.login(request.getParameter("username"), request.getParameter("password"));

                response.sendRedirect("firstPage");
            }

        } catch (IllegalArgumentException e) { // Wrong username or password
            e.printStackTrace();
            request.setAttribute("message", e.getMessage());

            request.getRequestDispatcher("error.jsp").forward(request, response);
        } catch (SQLException e) {
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
