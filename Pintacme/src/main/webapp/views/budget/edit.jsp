
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<form:form action="budget/painter/edit.do" modelAttribute="budget">

	<form:hidden path="id"/>
	<form:hidden path="version"/>
	<form:hidden path="materials"/>
	<form:hidden path="request"/>

	<div class="form-group">
	<form:label path="status" class="col-md-2 control-label">
		<spring:message code="budget.edit.status" />
	</form:label>
	<div class="col-md-10">
		<form:select class="form-control" path="status">
    <form:options class="col-md-2 control-label" items="${priorities}" />
  	</form:select>
  	</div>
	
  	</div>
  	
	<acme:inputTextMD code="budget.edit.amount" path="amount"/>	
	<acme:textareaMD code="budget.edit.description" path="description"/>	
	
	
	<acme:submitMD name="save" code="budget.edit.save" withButtonCancel="true"
					codeButtonCancel="budget.edit.cancel" />
	
	<jstl:if test="${budget.id!=0}">
		<acme:submitMD name="delete" code="budget.edit.delete"/>
	</jstl:if>
	
	

</form:form>


