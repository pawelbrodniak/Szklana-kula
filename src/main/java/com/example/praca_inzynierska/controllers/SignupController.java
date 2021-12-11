package com.example.praca_inzynierska.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.example.praca_inzynierska.user.UserRegistrationDto;
import com.example.praca_inzynierska.user.UserService;

import java.io.IOException;

@WebServlet("/signup")
public class SignupController extends HttpServlet {
    private final UserService userDTO = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserRegistrationDto userRegistration = getUserData(request);
        userDTO.register(userRegistration);
        response.sendRedirect(request.getContextPath());
    }

    private UserRegistrationDto getUserData(HttpServletRequest request) {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        return new UserRegistrationDto(username, email, password);
    }
}