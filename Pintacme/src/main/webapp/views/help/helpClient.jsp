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
.helpClientPhoto {
    background-image:url('images/ayudaCliente1.bmp');
    
    background-size:100%;
 	width:500px;
	height:425px;
	
}
</style>

<div style="padding-left:350px; font-weight: bold;">

	<div class="helpClientPhoto">					
										
		<h2 align="center" style="font-weight:bold;">
			<spring:message code="helpClient.title" />:
		</h2> 
		
			
		<h3 align="center" style="font-weight:bold;">
			<spring:message code="helpClient.1" />
		</h3>
		<h3 align="center" style="font-weight:bold;">
			<spring:message code="helpClient.2" />
		</h3>
		<h3 align="center" style="font-weight:bold;">
			<spring:message code="helpClient.3" />
		</h3>
		<h3 align="center" style="font-weight:bold;">
			<spring:message code="helpClient.4" />
		</h3>
		<h3 align="center" style="font-weight:bold;">
			<spring:message code="helpClient.5" />
		</h3>
	</div>
</div>

