
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<form:form action="customer/register.do" modelAttribute="customerForm">

	
	<acme:inputTextMD code="customer.username" path="username"/>	
	<acme:inputTextMD code="customer.password" path="password"/>	
  	
	<acme:inputTextMD code="customer.name" path="name"/>	
	<acme:inputTextMD code="customer.surname" path="surname"/>	
	<acme:inputTextMD code="customer.postalCode" path="postalCode"/>	
	<acme:inputTextMD code="customer.email" path="email"/>	
	<acme:inputTextMD code="customer.phone" path="phone"/>
	<acme:inputTextMD code="customer.dni" path="dni"/>
	
		
	
	<acme:submitMD name="save" code="customer.save" withButtonCancel="true"
					codeButtonCancel="customer.cancel" />
	
	
	

</form:form>


