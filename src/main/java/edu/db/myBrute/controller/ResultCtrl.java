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

@WebServlet("/result")
public class ResultCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserRepo userRepo = UserRepo.getInstance();
        GameUser user = userRepo.currentUser();
        GameUser opponent;
        GameUser winner;

        if (user == null) {
            response.sendRedirect("login");
        } else {
            try {
                opponent = userRepo.loadUserByUsername(request.getParameter("opponentUsername"));
                winner = userRepo.getWinner();

                request.setAttribute("winner", winner);
                request.setAttribute("looser", user.getUsername().equals(winner.getUsername()) ? opponent : user);

                request.getRequestDispatcher("result.jsp").forward(request, response);
            } catch (SQLException e) {
                request.setAttribute("message", e.getMessage());

                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }
    }
}
