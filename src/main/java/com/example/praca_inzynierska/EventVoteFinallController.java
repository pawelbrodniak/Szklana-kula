package com.example.praca_inzynierska;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.praca_inzynierska.EventVoteFinall;
import com.example.praca_inzynierska.EventVoteFinallService;

import java.io.IOException;
import java.util.List;

@WebServlet("/event/votefinall")

public class EventVoteFinallController extends HttpServlet {
    private EventVoteFinallService votefinallService = new EventVoteFinallService();
    private final CategoryService categoryService = new CategoryService();
    private EventFinallService eventFinallService = new EventFinallService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EventVoteFinall eventVoteFinall = createEventVoteFinall(request);
        votefinallService.addVoteFinall(eventVoteFinall);
        List<EventBasicInfo> events = eventFinallService.findAll();
        request.setAttribute("events", events);
        List<CategoryName> categories = categoryService.findAllCategoryNames();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/WEB-INF/views/addResult.jsp").forward(request, response);
    }

    private EventVoteFinall createEventVoteFinall(HttpServletRequest request) {
        Integer eventId = Integer.valueOf(request.getParameter("id"));
        String voteType = request.getParameter("type");
        String username = request.getUserPrincipal().getName();
        EventVoteFinall eventVoteFinall = new EventVoteFinall(username, eventId, voteType);
        return eventVoteFinall;
    }
}