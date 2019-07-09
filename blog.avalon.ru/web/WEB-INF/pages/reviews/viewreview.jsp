<%-- 
    Document   : viewreview
    Created on : 07.07.2019, 12:42:09
    Author     : Alexander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="common" tagdir="/WEB-INF/tags/common/" %>

<common:layout>
    <jsp:attribute name ="title">
        ${feedback.title}
        
    </jsp:attribute>
    <jsp:body>
        <h2>${feedback.title}</h2>
        ${feedback.content}
       </jsp:body>
</common:layout>
