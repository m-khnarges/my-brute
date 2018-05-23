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

@WebServlet("/play")
public class PlayCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        GameService gameService = GameService.getInstance();

        try {
            GameUser currentUser = gameService.currentUser();

            if (currentUser == null) {
                response.sendRedirect("login");
            } else {
                GameUser opponent = gameService.loadUserByUsername(request.getParameter("opponentUsername"));

                request.setAttribute("user", currentUser);

                request.setAttribute("opponent", opponent);

                request.getRequestDispatcher("play.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();

            request.setAttribute("message", e.getMessage());

            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
