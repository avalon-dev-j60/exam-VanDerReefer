<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="common" tagdir="/WEB-INF/tags/common/" %>
<%@taglib prefix="auth" tagdir="/WEB-INF/tags/auth/" %>

<fmt:setBundle basename="resources.labels"/>

<common:layout>
    <jsp:attribute name="title">
        <fmt:message key="label.registration.title"/>
    </jsp:attribute>
    <jsp:body>
    <div class="one half centered">
            <h2>
                <fmt:message key="label.registration.title"/>
            </h2>
        <auth:registerForm/>
    </div>
    </jsp:body>
</common:layout>
