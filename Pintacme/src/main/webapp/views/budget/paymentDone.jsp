
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<form:form action="budget/customer/paymentDone.do" modelAttribute="budget">

	<form:hidden path="id"/>
	<form:hidden path="version"/>
	<form:hidden path="materials"/>
	<form:hidden path="request"/>
	<form:hidden path="status"/>
	<form:hidden path="painter"/>
	<form:hidden path="amount"/>
	<form:hidden path="description"/>

<h1><spring:message code="customer.paymentDone"/></h1>

<h2><spring:message code="customer.profesional"/></h2>

<h3><spring:message code="customer.thanks"/></h3>

<input type="button" name="cancel" class="button"
		value="<spring:message code="budget.main" />"
		onclick="javascript: window.location.replace('/Pintacme/welcome/index.do');" />
	<br />

</form:form>