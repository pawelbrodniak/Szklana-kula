package com.example.praca_inzynierska.controllers;

import com.example.praca_inzynierska.category.CategoryNameDto;
import com.example.praca_inzynierska.category.CategoryService;
import com.example.praca_inzynierska.event.EventBasicInfoDto;
import com.example.praca_inzynierska.event.EventService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("")
public class GroupController extends HttpServlet {
    private final CategoryService categoryService = new CategoryService();
    private EventService eventService = new EventService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EventBasicInfoDto> events = eventService.findAll();
        request.setAttribute("events", events);
        List<CategoryNameDto> categories = categoryService.findAllCategoryNames();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}