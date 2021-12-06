package com.example.praca_inzynierska;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/deleteall")


public class DeleteAllController extends HttpServlet {
    private DeleteDao deleteDao = new DeleteDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        deleteDao.deleteVote();
        deleteDao.deleteEvent();
        deleteDao.deleteUsers_Role();
        deleteDao.deleteUsers();
        response.sendRedirect(request.getContextPath());
    }
}