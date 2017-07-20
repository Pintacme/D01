
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<form:form action="${requestURI}" modelAttribute="discussion">

	<form:hidden path="id"/>
	<form:hidden path="version"/>
	<form:hidden path="moment"/>
	<form:hidden path="resolution"/>
	<form:hidden path="painter"/>
	<form:hidden path="request"/>
	  		
	<acme:inputTextMD code="discussion.edit.pictures" path="pictures"/>	
	<acme:textareaMD code="discussion.edit.description" path="description"/>


	
	<acme:submitMD name="save" code="discussion.edit.save" withButtonCancel="true"
					codeButtonCancel="discussion.edit.cancel" />
	

</form:form>


