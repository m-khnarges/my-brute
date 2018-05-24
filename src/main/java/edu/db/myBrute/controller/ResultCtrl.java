package edu.db.myBrute.controller;

import edu.db.myBrute.data.GameService;
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
        GameService gameService = GameService.getInstance();


        try {
            GameUser user = gameService.currentUser();
            GameUser opponent;
            GameUser winner;

            if (user == null) {
                response.sendRedirect("login");
            } else {

                gameService.attackTo(request.getParameter("opponentUsername"));

                opponent = gameService.loadUserByUsername(request.getParameter("opponentUsername"));
                winner = gameService.getWinner();

                request.setAttribute("winner", winner);
                request.setAttribute("looser", user.getUsername().equals(winner.getUsername()) ? opponent : user);

                request.getRequestDispatcher("result.jsp").forward(request, response);
            }
        } catch (SQLException | NullPointerException  e) {
            e.printStackTrace();

            request.setAttribute("message", e.getMessage());

            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
