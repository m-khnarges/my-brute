package edu.db.myBrute.controller;

import edu.db.myBrute.data.UserRepo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/opponents")
public class OpponentsCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserRepo userRepo = UserRepo.getInstance();

        if (userRepo.currentUser() == null) {
            response.sendRedirect("/login");
        }

        request.setAttribute("opponents", userRepo.getOpponents());
        // We can use getOpponentsFor(user) to get specific opponents for this user
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
