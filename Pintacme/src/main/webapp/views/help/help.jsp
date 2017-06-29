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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<!--  
<style>
#responsive{ width:100%; height:20px; margin:0 auto;}
#responsive ul{list-style:none}
#responsive ul li{display:inline; margin:0 45px 0 45px}
</style>

<div class="responsive">
<ul>
<li><a href="<c:url value="/helpClient/show.do"/>"><spring:message code="helpClient.title" /></a></li>
<li><a href="<c:url value="/helpPainter/show.do"/>"><spring:message code="helpPainter.title" /></a></li>
<li><a href="<c:url value="/helpIssue/show.do"/>"><spring:message code="helpIssue.title" /></a></li>
</ul>
-->
<div class="responsive">

<h1 align="justify">
<a  href="<c:url value="/helpClient/show.do"/>"><spring:message code="helpClient.title" /></a>
<a href="<c:url value="/helpPainter/show.do"/>"><spring:message code="helpPainter.title" /></a>
<a href="<c:url value="/helpIssue/show.do"/>"><spring:message code="helpIssue.title" /></a>
</h1>


<a href="helpClient/show.do"><img align="left" width="25%" src="images/brochita clienta guantes.png"
						alt="Pintacme" /></a>

<a href="helpPainter/show.do"><img align="center" width="25%" src="images/brochita pintora guantes.png"
						alt="Pintacme" /></a>

<a href="helpIssue/show.do"><img align="right" width="25%" src="images/brochita enfada guantes.png"
						alt="Pintacme" /></a>
</div>
<!-- 

h1   {color: blue;
padding-left: 20px;}

<h1 align="justify">
<a  href="<c:url value="/helpClient/show.do"/>"><spring:message code="helpClient.title" /></a>


<h1 align="justify">
<a href="<c:url value="/helpPainter/show.do"/>"><spring:message code="helpPainter.title" /></a>
</h1>
</h1>

<h1 align="justify" >
<a href="<c:url value="/helpIssue/show.do"/>"><spring:message code="helpIssue.title" /></a>

</h1>
-->


<!-- 


<h1 align="justify">
<a  href="<c:url value="/helpClient/show.do"/>"><spring:message code="helpClient.title" /></a>
<a href="<c:url value="/helpPainter/show.do"/>"><spring:message code="helpPainter.title" /></a>
<a href="<c:url value="/helpIssue/show.do"/>"><spring:message code="helpIssue.title" /></a>
</h1> -->