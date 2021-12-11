package com.example.praca_inzynierska.vote;

import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
        EventVoteDto eventVote = createEventVote(request);
        voteService.addVote(eventVote);
       response.sendRedirect(request.getContextPath());
    }

    private EventVoteDto createEventVote(HttpServletRequest request) {
        Integer eventId = Integer.valueOf(request.getParameter("id"));
        String voteType = request.getParameter("type");
        String username = request.getUserPrincipal().getName();
        EventVoteDto eventVote = new EventVoteDto(username, eventId, voteType);
        return eventVote;
    }
}