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

	<security:authorize access="hasRole('CUSTOMER')">


<display:table name="requests" id="row" requestURI="${requestUri}" class="table" keepStatus="false" pagesize="5"  >
	
	<spring:message code="request.priority" var="priorityColumn" ></spring:message>
	<display:column property="priority" title="${priorityColumn}"/>
	
	<spring:message code="request.moment" var="momentColumn" ></spring:message>
	<display:column title="${momentColumn}"><center><fmt:formatDate value="${row.moment}" pattern="dd-MM-yyyy HH:mm"/></center></display:column>
	
	<spring:message code="request.schedule" var="scheduleColumn" ></spring:message>
	<display:column property="schedule" title="${scheduleColumn}"/>
	
	<spring:message code="request.measures" var="measuresColumn" ></spring:message>
	<display:column property="measures" title="${measuresColumn}"/>
	
	<spring:message code="request.work" var="workColumn" ></spring:message>
	<display:column property="work" title="${workColumn}"/>
	
	<spring:message code="request.description" var="descriptionColumn" ></spring:message>
	<display:column property="description" title="${descriptionColumn}"/>
	
	<spring:message code="request.address" var="addressColumn" ></spring:message>
	<display:column property="address" title="${addressColumn}"/>
	
	<security:authorize access="hasRole('CUSTOMER')">
	<display:column>
		<center><a href="request/customer/edit.do?id=${row.id}">
			<spring:message code="request.edit"/>
		</a></center>
	</display:column>
	</security:authorize>
	
	<display:column>
		<center><a href="budget/customer/list.do?id=${row.id}">
			<spring:message code="request.list.budget"/>
		</a></center>
	</display:column>
	
	
	</display:table>
	
	<div>
		<a href="request/customer/create.do"><spring:message code="request.create"/></a>
	</div>
	
</security:authorize>