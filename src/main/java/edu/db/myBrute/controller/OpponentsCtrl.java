package edu.db.myBrute.controller;

import edu.db.myBrute.data.UserRepo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/opponents")
public class OpponentsCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        UserRepo userRepo = UserRepo.getInstance();


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
