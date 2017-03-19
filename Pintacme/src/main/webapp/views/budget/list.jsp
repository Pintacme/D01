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


<display:table name="budgets" id="row" requestURI="${budgetUri}" class="table" keepStatus="false" pagesize="5"  >
	
	<spring:message code="budget.status" var="statusColumn" ></spring:message>
	<display:column property="status" title="${statusColumn}"/>
	
	<spring:message code="budget.amount" var="amountColumn" ></spring:message>
	<display:column property="amount" title="${amountColumn}"/>
	
	
	<spring:message code="budget.description" var="descriptionColumn" ></spring:message>
	<display:column property="description" title="${descriptionColumn}"/>
	
	<display:column>
		<center><a href="material/painter/list.do?id=${row.id}">
			<spring:message code="budget.list.material"/>
		</a></center>
	</display:column>
	
	<security:authorize access="hasRole('PAINTER')">
	<display:column>
		<center><a href="budget/painter/edit.do?id=${row.id}">
			<spring:message code="budget.edit"/>
		</a></center>
	</display:column>
	</security:authorize>
	
	
	
	
	</display:table>
	
	<div>
		<a href="budget/painter/create.do"><spring:message code="budget.create"/></a>
	</div>
	
</security:authorize>