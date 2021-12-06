package com.example.praca_inzynierska;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import com.example.praca_inzynierska.EventSaveRequest;
import com.example.praca_inzynierska.EventService;
import com.example.praca_inzynierska.CategoryName;
import com.example.praca_inzynierska.CategoryService;

import java.io.IOException;
import java.util.List;

@WebServlet("/group/addevent")

public class AddEventController extends HttpServlet {
    private CategoryService categoryService = new CategoryService();
    private EventService eventService = new EventService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CategoryName> categories = categoryService.findAllCategoryNames();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/WEB-INF/views/addEvent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventSaveRequest saveRequest = createSaveRequest(request);
        eventService.add(saveRequest);
        request.getRequestDispatcher("/WEB-INF/views/management.jsp").forward(request, response);
    }

    private EventSaveRequest createSaveRequest(HttpServletRequest request) {
        String loggedInUsername = request.getUserPrincipal().getName();
        return new EventSaveRequest(
                request.getParameter("teamA"),
                request.getParameter("teamB"),
                Integer.valueOf(request.getParameter("rate")),
                Integer.valueOf(request.getParameter("categoryId")),
                loggedInUsername
        );
    }
}