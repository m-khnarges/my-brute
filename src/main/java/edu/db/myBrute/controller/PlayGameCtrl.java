package edu.db.myBrute.controller;

import edu.db.myBrute.data.UserRepo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/playGame")
public class PlayGameCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        UserRepo userRepo = UserRepo.userRepo();
    }
}
