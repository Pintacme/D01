<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<style type="text/css">
.helpIssuePhoto {
    background-image:url('images/ayudaDisputa1.bmp');
    
    background-size:100%;
 	width:100%;
	height:100%;
}
</style>


<div class="helpIssuePhoto">	

<h2 align="center">
<spring:message code="helpIssue.title" />:
</h2>

<h3 align="center">
<spring:message code="helpIssue.1" />
</h3>

<h3 align="center">
<spring:message code="helpIssue.2" />
</h3>

</div>
<!--  
<div class="responsive">

<a href="#"><img align="left" width="25%" src="images/brochita enfada guantes.png"
						alt="Pintacme" /></a>

<h2 align="left">
<spring:message code="helpIssue.title" />:
</h2>

<h3 align="left">
<spring:message code="helpIssue.1" />
</h3>

<h3 align="left">
<spring:message code="helpIssue.2" />
</h3>

</div>

-->