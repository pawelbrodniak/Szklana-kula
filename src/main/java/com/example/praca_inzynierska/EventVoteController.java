package com.example.praca_inzynierska;

import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.praca_inzynierska.EventVote;
import com.example.praca_inzynierska.EventVoteService;

import java.io.IOException;

@WebServlet("/event/vote")
@ServletSecurity(
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = "USER")
        }
)
public class EventVoteController extends HttpServlet {
    private EventVoteService voteService = new EventVoteService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        EventVote eventVote = createEventVote(request);
        voteService.addVote(eventVote);
       response.sendRedirect(request.getContextPath());
    }

    private EventVote createEventVote(HttpServletRequest request) {
        Integer eventId = Integer.valueOf(request.getParameter("id"));
        String voteType = request.getParameter("type");
        String username = request.getUserPrincipal().getName();
        EventVote eventVote = new EventVote(username, eventId, voteType);
        return eventVote;
    }
}