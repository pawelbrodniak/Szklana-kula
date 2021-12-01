package com.example.praca_inzynierska;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.praca_inzynierska.Classification;
import com.example.praca_inzynierska.ClassificationService;

import java.io.IOException;
import java.util.List;

@WebServlet("/classification")
public class ClassificationController extends HttpServlet {
    private final ClassificationService classificationService = new ClassificationService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Classification> classifications = classificationService.findAllName();
        request.setAttribute("classifications", classifications);
        request.getRequestDispatcher("./WEB-INF/views/classification.jsp").forward(request, response);
    }

}