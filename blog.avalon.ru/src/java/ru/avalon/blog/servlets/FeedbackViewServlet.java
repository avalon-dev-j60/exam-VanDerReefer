package ru.avalon.blog.servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.avalon.blog.entities.Feedback;
import static ru.avalon.blog.helpers.ServletHelper.*;
import ru.avalon.blog.services.FeedbackService;

@WebServlet("/feedback")
public class FeedbackViewServlet extends HttpServlet {
    
    private static final String JSP =
            "/WEB-INF/pages/reviews/viewreview.jsp";
    
    @EJB FeedbackService  feedbackService; 

    @Override
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
            throws ServletException, IOException {
       String id = request.getParameter("id");
       if(id!=null) {
           long lid=Long.parseLong(id);
           Feedback feedback = feedbackService.find(lid);
           if (feedback!=null){
               request.setAttribute("feedback", feedback);
               request.getRequestDispatcher(JSP).forward(request, response);
           } else {response.sendError(HttpServletResponse.SC_NOT_FOUND);
           }
           
       } else {
           redirectToReferer(request, response);
       }
    } 
}