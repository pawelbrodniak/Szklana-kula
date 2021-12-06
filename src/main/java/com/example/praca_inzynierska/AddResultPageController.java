package com.example.praca_inzynierska;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.praca_inzynierska.EventBasicInfo;
import com.example.praca_inzynierska.EventService;

import java.io.IOException;
import java.util.List;

@WebServlet("/addresult")


public class AddResultPageController extends HttpServlet {
    private final CategoryService categoryService = new CategoryService();
    private EventFinallService eventFinallService = new EventFinallService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EventBasicInfo> events = eventFinallService.findAll();
        request.setAttribute("events", events);
        List<CategoryName> categories = categoryService.findAllCategoryNames();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("./WEB-INF/views/addResult.jsp").forward(request, response);
    }
}
