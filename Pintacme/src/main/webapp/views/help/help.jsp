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

<h1>
<a href="<c:url value="/helpClient/show.do"/>"><spring:message code="helpClient.title" /></a>
</h1>

<h1>
<a href="<c:url value="/helpPainter/show.do"/>"><spring:message code="helpPainter.title" /></a>
</h1>

<h1>
<a href="<c:url value="/helpIssue/show.do"/>"><spring:message code="helpIssue.title" /></a>

</h1>