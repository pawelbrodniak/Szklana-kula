package com.example.praca_inzynierska.eventfinal;

import com.example.praca_inzynierska.category.CategoryNameDto;
import com.example.praca_inzynierska.category.CategoryService;
import com.example.praca_inzynierska.event.EventBasicInfoDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/event/votefinall")

public class EventVoteFinallController extends HttpServlet {
    private EventVoteFinallService votefinallService = new EventVoteFinallService();
    private final CategoryService categoryService = new CategoryService();
    private EventFinallService eventFinallService = new EventFinallService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EventVoteFinallDto eventVoteFinall = createEventVoteFinall(request);
        votefinallService.addVoteFinall(eventVoteFinall);
        List<EventBasicInfoDto> events = eventFinallService.findAll();
        request.setAttribute("events", events);
        List<CategoryNameDto> categories = categoryService.findAllCategoryNames();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/WEB-INF/views/addResult.jsp").forward(request, response);
    }

    private EventVoteFinallDto createEventVoteFinall(HttpServletRequest request) {
        Integer eventId = Integer.valueOf(request.getParameter("id"));
        String voteType = request.getParameter("type");
        String username = request.getUserPrincipal().getName();
        EventVoteFinallDto eventVoteFinall = new EventVoteFinallDto(username, eventId, voteType);
        return eventVoteFinall;
    }
}