<%--
 * index.jsp
 *
 * Copyright (C) 2014 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>




<div class="table-responsive">
<display:table name="discussions" id="row" requestURI="${requestUri}" class="table" keepStatus="true" pagesize="5" >
	
	<spring:message code="discussion.customer" var="painterColumn" ></spring:message>
	<display:column property="request.customer.name" title="${painterColumn}"/>
	
	<spring:message code="discussion.painter" var="painterColumn" ></spring:message>
	<display:column property="painter.name" title="${painterColumn}"/>
	
	<spring:message code="discussion.description" var="descriptionColumn" ></spring:message>
	<display:column property="description" title="${descriptionColumn}"/>
	
	<spring:message code="discussion.resolution" var="resolutionColumn" ></spring:message>
	<display:column property="resolution" title="${resolutionColumn}"/>
	
	<spring:message code="discussion.pictures" var="picturesColumn" ></spring:message>
	<display:column title="${picturesColumn}">
	<jstl:forEach items="${row.pictures}" var="p" >
			<A HREF="${p}"><IMG HEIGHT=50 WIDTH=50 SRC="${p}"></A>
	</jstl:forEach>
	</display:column>
	
	<spring:message code="discussion.moment" var="momentColumn" ></spring:message>
	<display:column title="${momentColumn}"><center><fmt:formatDate value="${row.moment}" pattern="dd-MM-yyyy HH:mm"/></center></display:column>
	
	<security:authorize access="hasRole('ADMINISTRATOR')">
		<display:column>
		<jstl:if test="${row.resolution=='PENDING'}">
			<center><a href="discussion/administrator/accept.do?discussionId=${row.id}">
				<spring:message code="discussion.resolution.accept"/>
			</a></center>
		</jstl:if>
		</display:column>
		<display:column>
			<jstl:if test="${row.resolution=='PENDING'}">
				<center><a href="discussion/administrator/denied.do?discussionId=${row.id}">
					<spring:message code="discussion.resolution.denied"/>
				</a></center>
			</jstl:if>
		</display:column>
	</security:authorize>
	
</display:table>

</div>

