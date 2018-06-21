<%-- 
    Document   : menu
    Created on : Mar 27, 2016, 7:51:56 PM
    Author     : 1041737
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<input type="hidden" value="${contextPath}" name="contextPath" id="contextpath"/>

<c:if test="${empty sessionScope.Role}">
    <canvas id="pixie"></canvas>
</c:if>

<div class="pagehead">
    <div class="container">
        <h1 class="head-heading pull-left"><a href="${contextPath}">Tcs Mail<sup> &beta;</sup></a></h1>
        <c:if test="${sessionScope.Role=='User'}">
            <ul class="menu user-menu pull-left">
                <li>
                    <a href="CoursesLanding.html">Course</a>
                </li>
                <li>
                    <a href="AssignmentsLanding.html">Assignment</a>
                </li>
                <li>
                    <a href="ExamLanding.html">Exam</a>
                </li>
            </ul>
        </c:if>
        <c:if test="${sessionScope.Role=='Ta'}">
            <%--<ul class="menu user-menu pull-left">
                <li>
                    <a href="CoursesLanding.html">Course</a>
                </li>
                <li>
                    <a href="AssignmentsLanding.html">Assignment</a>
                </li>
            </ul>--%>
<!--            <ul class="menu user-menu pull-left">
                <li>
                    <a href="CoursesLanding.html">Course</a>
                </li>
                <li>
                    <a href="AssignmentsLanding.html">Assignment</a>
                </li>
            </ul>   -->
        </c:if>
        <ul class="menu pull-right">
            <%--if not logged in--%>
            <c:if test="${empty sessionScope.Role}">
<!--                <li>
                    <a href="#">About</a>
                </li>-->
            </c:if>
            <c:if test="${sessionScope.Role=='admin'}">
                <li>
                    <a href="#">Admin</a>
                </li>
            </c:if>
            <c:if test="${sessionScope.Role=='user'}">
                <li>
                    <a data-email="${sessionScope.PrimaryEmail}" href="#">${sessionScope.UserName}</a>
                </li>
            </c:if>
            <c:if test="${sessionScope.Role=='ta'}">
                  <li>
                    <a data-email="${sessionScope.PrimaryEmail}" href="#">${sessionScope.UserName}</a>
                </li>
            </c:if>
            <c:if test="${not empty sessionScope.Role}">
                <li>
                    <a href="${contextPath}/Logout">Logout</a>
                </li>
            </c:if>
        </ul>
    </div>
</div>