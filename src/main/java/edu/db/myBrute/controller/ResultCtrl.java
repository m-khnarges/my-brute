package edu.db.myBrute.controller;

import edu.db.myBrute.data.UserRepo;
import edu.db.myBrute.domain.GameUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/result")
public class ResultCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserRepo userRepo = UserRepo.getInstance();

        GameUser user = userRepo.currentUser();

        if (user == null) {
            response.sendRedirect("/login");
        } else {
        request.setAttribute("winner", user);
        request.setAttribute("looser", user);

        request.getRequestDispatcher("result.jsp").forward(request, response);
        }
    }
}
