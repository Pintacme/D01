<%--
 * list.jsp
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>


<div>
<h3><spring:message code="administrator.dashboard.avgAgeCustomer" /></h3>
</div>
<display:table name="avgAgeCustomer" id="row">
	<spring:message code="administrator.dashboard.avgAgeCustomer" var="avgAgeCustomer"/>
	<display:column title="${avgAgeCustomer}"> 
		<jstl:out value="${row}" />
	</display:column>
</display:table>


<div>
<h3><spring:message code="administrator.dashboard.ratioManWoman" /></h3>
</div>
<display:table name="ratioManWoman" id="row">
	
	<spring:message code="administrator.dashboard.ratioMan" var="ratioMan"/>
	<display:column title="${ratioMan}"> 
		<jstl:out value="${row[0]}" />
	</display:column>

	<spring:message code="administrator.dashboard.ratioWoman" var="ratioWoman"/>
	<display:column title="${ratioWoman}"> 
		<jstl:out value="${row[1]}" />
	</display:column>
</display:table>

<div>
<h3><spring:message code="administrator.dashboard.getPaintersOrderByAverageStart" /></h3>
</div>

<display:table name="getPaintersOrderByAverageStart" id="row">

	<spring:message code="actor.name" var="nameHeader"/>
	<display:column title="${nameHeader}"> 
		<jstl:out value="${row.name}" />
	</display:column>
	
	<spring:message code="actor.surname" var="surnameHeader"/>
	<display:column title="${surnameHeader}"> 
		<jstl:out value="${row.surname}" />
	</display:column>
	
</display:table>