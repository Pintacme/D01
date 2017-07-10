
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<form:form action="${requestURI}" modelAttribute="request">

	<form:hidden path="id"/>
	<form:hidden path="version"/>
	<form:hidden path="moment"/>
	<form:hidden path="customer"/>
	<form:hidden path="budgets"/>
  	
  	
	<acme:inputTextMD code="request.edit.measures" path="measures"/>	
	<acme:inputTextMD code="request.edit.photos" path="photos"/>	
	<acme:inputTextMD code="request.edit.description" path="description"/>	
	<acme:inputTextMD code="request.edit.address" path="address"/>	
	<acme:inputTextMD placeHolderCode="customer.messsageWork" code="request.edit.work" path="work"/>
	
	<div class="form-group">
	<form:label path="timePreference"  class="col-md-2 control-label">
		<spring:message code="request.edit.schedule" />:</form:label>
			<div class="col-md-10">
				<form:select path="timePreference" class="form-control">
				<form:options items="${timePreference}"/>
			</form:select>
		</div>
	</div>
	
	<acme:submitMD name="save" code="request.edit.save"/>
	<acme:buttonMD href="request/customer/list.do" type="button" code="request.edit.cancel"/>

</form:form>


