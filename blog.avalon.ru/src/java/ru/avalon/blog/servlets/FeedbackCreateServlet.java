package ru.avalon.blog.servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.avalon.blog.entities.Feedback;
import ru.avalon.blog.entities.User;
import ru.avalon.blog.exceptions.RequiredDataException;
import static ru.avalon.blog.helpers.ServletHelper.*;
import ru.avalon.blog.services.AuthService;
import ru.avalon.blog.services.FeedbackService;

@WebServlet("/feedback/create")
public class FeedbackCreateServlet extends HttpServlet {

    private static final String JSP
            = "/WEB-INF/pages/reviews/createreview.jsp";
    
    @Inject
    AuthService authService;
    @EJB
    FeedbackService FeedbackService;

    @Override
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
            throws ServletException, IOException {
        
        if (authService.isSignedIn()) {
            request.getRequestDispatcher(JSP)
                    .forward(request, response);
        } else {
            redirectToReferer(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        try {
            if (title == null || title.trim().isEmpty()) {
                throw new RequiredDataException("error.title.required");
            }
            if (content == null || content.trim().isEmpty()) {
                throw new RequiredDataException("error.content.required");
            }
            User user = authService.getUser();
            Feedback feedback = new Feedback(
                    user, title, content);
            FeedbackService.create(feedback);
            redirect(request, response, request.getContextPath());
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            doGet(request, response);
        }
    }
}