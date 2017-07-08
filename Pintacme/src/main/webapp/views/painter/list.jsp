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

<div class="table-responsive">

<security:authorize access="hasRole('CUSTOMER')">
<h2><spring:message code="painter.explanation" /></h2>
</br>
</security:authorize>
<display:table name="painters" id="row" requestURI="${requestUri}" class="table" keepStatus="false" pagesize="5"  >
	
	<spring:message code="painter.name" var="nameColumn" ></spring:message>
	<display:column property="name" title="${nameColumn}"/>
	
	<spring:message code="painter.surname" var="surnameColumn" ></spring:message>
	<display:column property="surname" title="${surnameColumn}"/>
	
	<spring:message code="painter.averageStart" var="averageStartColumn" ></spring:message>
	<display:column title="${averageStartColumn}"><meter value="${row.averageStart}" min="0" max="5" optimum="3" low="3" high="5"></meter><br></display:column>
	
	<security:authorize access="hasRole('CUSTOMER')">
	<display:column>
		<center><a href="comment/customer/list.do?id=${row.id}">
			<spring:message code="painter.view.comments"/>
		</a></center>
	</display:column>
	
	<jstl:if test="${res}">
	<display:column>
		<center><a href="comment/customer/create.do?id=${row.id}">
			<spring:message code="painter.create.comment"/>
		</a></center>
	</display:column>
	</jstl:if>
	</security:authorize>
	
	</display:table>
</div>	