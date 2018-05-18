package edu.db.myBrute.controller;

import edu.db.myBrute.data.UserRepo;
import edu.db.myBrute.domain.GameUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/playGame")
public class PlayGameCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserRepo userRepo = UserRepo.getInstance();
        GameUser user = userRepo.currentUser();
        GameUser opponent = userRepo.loadUserByUsername(request.getParameter("opponentUsername"));
        System.out.println(request.getParameter("opponentUsername"));
//        if (user == null) {
//            response.sendRedirect("/login");
//        } else {
            request.setAttribute("user", user);

            request.setAttribute("opponent", opponent);

            request.getRequestDispatcher("attack.jsp").forward(request, response);
//        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("playGame.jsp").forward(request, response);
    }
}
