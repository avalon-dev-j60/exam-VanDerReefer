<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="common" tagdir="/WEB-INF/tags/common/"  %>

<fmt:setBundle basename ="resources.labels"/>

<common:layout title = "Blog">
    <c:set var="context"
           value="${pageContext.servletContext.contextPath}"/>
    <c:if test="${not empty sessionScope.user}">
        <a href="${context}/feedback/create"
           class="button green">
            <fmt:message key="label.create"/>
        </a>   
    </c:if>
    <c:choose>
        <c:when test = "${empty items}">
            <center>
                <h3>
                    <fmt:message key="label.reviews.empty"/> 
                </h3>
            </c:when>  
            <c:otherwise>

                <c:forEach items="${items}" var="item">
                    <div class="row gap-bottom">
                        <h3>
                            <a
                                href="${context}/feedback?id=${item.id}">
                                ${item.title}
                            </a> 
                        </h3>
                    </div>        
                </c:forEach>
            </c:otherwise>

        </c:choose>

    </common:layout>
