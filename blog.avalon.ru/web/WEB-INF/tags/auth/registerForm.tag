<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="common" tagdir="/WEB-INF/tags/common/" %>

<fmt:setBundle basename ="resources.labels"/>

<common:error/>

<form action="${pageContext.servletContext.contextPath}/register"
      method="post">

    <p class="row gap-bottom">
        <input type="email"
               name="email"
               value="${param.email}"
               placeholder=<fmt:message key="label.email"/>
               required>
    </p>
    
    <p class="row gap-bottom">
        <input type="password"
               name="password"
               placeholder=<fmt:message key="label.password"/>
               required>
    </p>
    
    <p class="row gap-bottom" >
        <input type="password"
               name="confirm"
               placeholder=<fmt:message key="label.password.confirmation"/>
               required>
    </p>
    
    <p class="row gap-bottom">
        <button class="pull-right green">
            <fmt:message key="label.registration.action"/>
        </button>
    </p>
    
</form>
