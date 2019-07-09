<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="common" tagdir="/WEB-INF/tags/common/" %>

<common:layout>
    <jsp:attribute name ="title">
        ${publication.title}
        
    </jsp:attribute>
    <jsp:body>
        <h2>${publication.title}</h2>
        ${publication.content}
       </jsp:body>
</common:layout>
