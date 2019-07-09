<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename ="resources.labels"/>

<c:set var="context" 
       value="${pageContext.servletContext.contextPath}"/>

<nav title="Software development blog">
    <ul>
        <li>
            <a href="${context}">
                <fmt:message key="label.blog"/>
            </a>
        </li>
        <li>
            <a href="${context}/author.jsp">
                 <fmt:message key="label.author"/>
            </a>
        </li>
        <li>
            <a href="${context}/contacts.jsp">
                <fmt:message key="label.contacts"/>
            </a>
        </li>
        <li>
            <a href="${context}/feedback/allreviews">
                <fmt:message key="label.feedback"/>
            </a>
        </li>
        <li class="pull-right">
            <c:choose>
                <c:when test="${empty sessionScope.user}">
                    <a href="${context}/login">
                        <fmt:message key="label.sign-in.action"/>
                    </a>
                </c:when>
                <c:otherwise>
                    <a href="${context}/logout">
                        <fmt:message key="label.sign-out.action"/>
                    </a>
                </c:otherwise>
            </c:choose>
        </li>
    </ul>
</nav>