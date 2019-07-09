<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="common"
          tagdir="/WEB-INF/tags/common/"%>

<%@taglib prefix="articles"
          tagdir="/WEB-INF/tags/articles/"%>

<fmt:setBundle basename="resources.labels"/>

<common:layout>
    <jsp:attribute name="title">
        <fmt:message key="label.publication.create"/>
    </jsp:attribute> 
    <jsp:body>
        <h2>
            <fmt:message key="label.publication.create"/>
        </h2>
        <articles:create/>
    </jsp:body>             
</common:layout>