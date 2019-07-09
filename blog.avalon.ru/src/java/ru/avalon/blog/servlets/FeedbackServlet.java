package ru.avalon.blog.servlets;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.avalon.blog.entities.Feedback;
import ru.avalon.blog.services.FeedbackService;

@WebServlet("/feedback/allreviews")
public class FeedbackServlet extends HttpServlet {
        
    private static final String JSP = "/WEB-INF/pages/reviews/allreviews.jsp";
    @EJB FeedbackService feedbackService;

    @Override
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<Feedback>items = feedbackService.all();
        request.setAttribute("items", items);
        request.getRequestDispatcher(JSP).forward(request, response);
    }
}