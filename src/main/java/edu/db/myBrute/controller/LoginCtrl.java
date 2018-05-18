package edu.db.myBrute.controller;

import edu.db.myBrute.data.UserRepo;
import edu.db.myBrute.domain.GameUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserRepo userRepo = UserRepo.userRepo();

        try {
            GameUser user = userRepo.login(request.getParameter("username"), request.getParameter("password"));

            request.getRequestDispatcher("opponents.jsp").forward(request, response);
        } catch (IllegalArgumentException e) { // Wrong username or password
            request.setAttribute("message", e.getMessage());

            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
