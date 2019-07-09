package ru.avalon.blog.helpers;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public final class ServletHelper {
    
    private ServletHelper() {}
    
    public static void redirect(
            HttpServletRequest request,
            HttpServletResponse response,
            String location
    ) throws ServletException, IOException {
        response.setHeader("Location", location);
        response.setStatus(HttpServletResponse.SC_FOUND);
    }
    
    public static void redirectToReferer(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String referer = request.getHeader("Referer");
        String requestUrl = request.getRequestURL()
                                   .toString();
        if (referer == null || referer.equals(requestUrl)) {
            referer = request.getContextPath();
        }
        redirect(request, response, referer);
    }
}
