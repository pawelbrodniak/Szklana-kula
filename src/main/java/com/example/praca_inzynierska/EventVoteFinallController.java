package com.example.praca_inzynierska;

import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.praca_inzynierska.EventVoteFinall;
import com.example.praca_inzynierska.EventVoteFinallService;

import java.io.IOException;

@WebServlet("/event/votefinall")
@ServletSecurity(
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = "USER")
        }
)
public class EventVoteFinallController extends HttpServlet {
    private EventVoteFinallService votefinallService = new EventVoteFinallService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        EventVoteFinall eventVoteFinall = createEventVoteFinall(request);
        votefinallService.addVoteFinall(eventVoteFinall);
        response.sendRedirect(request.getContextPath());
    }

    private EventVoteFinall createEventVoteFinall(HttpServletRequest request) {
        Integer eventId = Integer.valueOf(request.getParameter("id"));
        String voteType = request.getParameter("type");
        String username = request.getUserPrincipal().getName();
        EventVoteFinall eventVoteFinall = new EventVoteFinall(username, eventId, voteType);
        return eventVoteFinall;
    }
}