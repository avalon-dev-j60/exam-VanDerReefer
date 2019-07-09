package ru.avalon.blog.servlets;

import java.io.IOException;
import javax.inject.Inject;
import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import ru.avalon.blog.helpers.ServletHelper;
import ru.avalon.blog.services.AuthService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Inject AuthService authService;
    
    @Override
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
                    throws ServletException, IOException {
        if (authService.isSignedIn()) {
            ServletHelper.redirectToReferer(
                request, 
                response
            );
        } else {
            request 
                .getRequestDispatcher(
                    "/WEB-INF/pages/auth/login.jsp"
                ).forward(
                    request, 
                    response
                );
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                    throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            authService.signIn(email, password);
        } catch(AuthenticationException e) {
            request.setAttribute("error", e.getMessage());
        }
        doGet(request, response);
    }
}
