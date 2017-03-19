
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<form:form action="request/customer/edit.do" modelAttribute="request">

	<form:hidden path="id"/>
	<form:hidden path="version"/>
	<form:hidden path="moment"/>
	<form:hidden path="customer"/>
	<form:hidden path="budgets"/>

	<div class="form-group">
	<form:label path="priority" class="col-md-2 control-label">
		<spring:message code="request.edit.priority" />
	</form:label>
	<div class="col-md-10">
		<form:select class="form-control" path="priority">
    <form:options class="col-md-2 control-label" items="${priorities}" />
  	</form:select>
  	</div>
	
  	</div>
  	
	<acme:inputTextMD code="request.edit.schedule" path="schedule"/>	
	<acme:inputTextMD code="request.edit.measures" path="measures"/>	
	<acme:textareaMD code="request.edit.description" path="description"/>	
	<acme:inputTextMD code="request.edit.address" path="address"/>	
	<acme:inputTextMD code="request.edit.work" path="work"/>	
	
	<acme:submitMD name="save" code="request.edit.save" withButtonCancel="true"
					codeButtonCancel="request.edit.cancel" />
	
	<jstl:if test="${request.id!=0}">
		<acme:submitMD name="delete" code="request.edit.delete"/>
	</jstl:if>
	
	

</form:form>


