package edu.db.myBrute.controller;

import edu.db.myBrute.data.UserRepo;
import edu.db.myBrute.domain.GameUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/opponents")
public class OpponentsCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserRepo userRepo = UserRepo.getInstance();
        GameUser user = userRepo.currentUser();

        if (user == null) {
            response.sendRedirect("/login");
        } else {
            request.setAttribute("user", user);

            try {
                request.setAttribute("opponents", userRepo.getOpponents());
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            request.getRequestDispatcher("opponents.jsp").forward(request, response);
        }
    }
}
