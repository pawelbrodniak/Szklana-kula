package com.example.praca_inzynierska;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/delete")


public class DeleteController extends HttpServlet {
    private DeleteDao deleteDao = new DeleteDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        deleteDao.deleteVote();
        deleteDao.deleteEvent();
        deleteDao.deletePoints();
        response.sendRedirect(request.getContextPath());
    }
}