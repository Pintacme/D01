<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>

<security:authorize access="hasAnyRole('CUSTOMER','PAINTER')">

<div class="table-responsive">
<display:table name="requests" id="row" requestURI="${requestUri}" class="table" keepStatus="false" pagesize="5"  >
	
	<spring:message code="request.moment" var="momentColumn" ></spring:message>
	<display:column title="${momentColumn}"><center><fmt:formatDate value="${row.moment}" pattern="dd-MM-yyyy HH:mm"/></center></display:column>
	
	<spring:message code="request.schedule" var="scheduleColumn" ></spring:message>
	<display:column property="timePreference" title="${timePreference}"/>
	
	<spring:message code="request.photos" var="photosColumn" ></spring:message>
	<display:column title="${photosColumn}">
	<jstl:forEach items="${row.photos}" var="p" >
			<A HREF="${p}"><img height="60" width="60" src="<jstl:out value="${p}"></jstl:out>"/></A>
	</jstl:forEach>
	</display:column>
		
	<spring:message code="request.measures" var="measuresColumn" ></spring:message>
	<display:column property="measures" title="${measuresColumn}"/>
	
	<spring:message code="request.work" var="workColumn" ></spring:message>
	<display:column title="${workColumn}"><center><fmt:formatDate value="${row.work}" pattern="dd-MM-yyyy HH:mm"/></center></display:column>
	
	<spring:message code="request.description" var="descriptionColumn" ></spring:message>
	<display:column property="description" title="${descriptionColumn}"/>
	
	<spring:message code="request.address" var="addressColumn" ></spring:message>
	<display:column property="address" title="${addressColumn}"/>
	
	<security:authorize access="hasRole('CUSTOMER')">
	<display:column>
	<jstl:if test="${row.budgets.isEmpty()}">
		<center><a href="request/customer/edit.do?id=${row.id}">
			<spring:message code="request.edit"/>
		</a></center>
	</jstl:if>
	</display:column>
	
	
	<display:column>
		<center><a href="budget/customer/list.do?id=${row.id}">
			<spring:message code="request.list.budget"/>
		</a></center>
	</display:column>
	</security:authorize>
	
	<security:authorize access="hasRole('PAINTER')">
	<display:column>
		<center><a href="budget/painter/create.do?id=${row.id}">
			<spring:message code="request.create.budget"/>
		</a></center>
	</display:column>
	</security:authorize>
	
	</display:table>
	
	</div>
	
	<security:authorize access="hasRole('CUSTOMER')">
	<div>
		<a href="request/customer/create.do"><spring:message code="request.create"/></a>
	</div>
	</security:authorize>
	
</security:authorize>
