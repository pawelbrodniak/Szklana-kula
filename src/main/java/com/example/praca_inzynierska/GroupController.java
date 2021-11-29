package com.example.praca_inzynierska;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.praca_inzynierska.EventBasicInfo;
import com.example.praca_inzynierska.EventService;

import java.io.IOException;
import java.util.List;

@WebServlet("")
public class GroupController extends HttpServlet {
    private final CategoryService categoryService = new CategoryService();
    private EventService eventService = new EventService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EventBasicInfo> events = eventService.findAll();
        request.setAttribute("events", events);
        List<CategoryName> categories = categoryService.findAllCategoryNames();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}