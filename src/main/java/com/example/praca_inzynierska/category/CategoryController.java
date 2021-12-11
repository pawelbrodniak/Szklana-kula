package com.example.praca_inzynierska.category;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.example.praca_inzynierska.event.EventBasicInfoDto;
import com.example.praca_inzynierska.event.EventService;

import java.io.IOException;
import java.util.List;

@WebServlet("/category")
public class CategoryController extends HttpServlet {
    private final CategoryService categoryService = new CategoryService();
    private final EventService eventService = new EventService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("id"));
        CategoryFullInfo category = categoryService.findById(categoryId)
                .orElseThrow();
        request.setAttribute("category", category);
        List<EventBasicInfoDto> events = eventService.findAllByCategory(categoryId);
        request.setAttribute("events", events);
        request.getRequestDispatcher("./WEB-INF/views/category.jsp").forward(request, response);
    }
}