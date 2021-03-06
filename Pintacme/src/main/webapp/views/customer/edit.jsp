
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<form:form action="customer/create.do" modelAttribute="customerForm">

	
	<acme:inputTextMD code="customer.username" path="username"/>	
	<acme:inputPassMD code="customer.password" path="password"/>
	<acme:inputPassMD code="customer.passRepeated" path="repeatedPassword"/>		
  	
	<acme:inputTextMD code="customer.name" path="name"/>	
	<acme:inputTextMD code="customer.surname" path="surname"/>	
	<acme:inputTextMD code="customer.postalCode" path="postalCode"/>	
	<acme:inputTextMD code="customer.email" path="email"/>	
	<acme:inputTextMD  placeHolderCode="customer.messsagePhone" code="customer.phone" path="phone"/>
	<acme:inputTextMD placeHolderCode="customer.messsageDni" code="customer.dni" path="dni"/>
	<acme:inputTextMD code="customer.age" path="age"/>

	<div class="form-group">
	<form:label path="genre"  class="col-md-2 control-label">
		<spring:message code="customer.genre" />:</form:label>
			<div class="col-md-10">
				<form:select path="genre" class="form-control">
				<form:options items="${genre}"/>
			</form:select>
		</div>
	</div>
	<form:checkbox path="hasAccepted"></form:checkbox>
	<spring:message code="customer.hasAccepted"/>
	
	</br>
		
	
	<acme:submitMD name="save" code="customer.save" withButtonCancel="true"
					codeButtonCancel="customer.cancel" />
	

</form:form>


