<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<security:authorize access="hasRole('ADMINISTRATOR')">

<h2><b><spring:message code="levelc"></spring:message></b></h2>

<b><spring:message code="c1"></spring:message> : <jstl:out value="${c1}"/></b>
</br>
</br>
<b><spring:message code="c2"></spring:message> : <jstl:out value="${c2}"/></b>
</br>
</br>

<b><spring:message code="c3"></spring:message> : <jstl:out value="${c3a}, ${c3b}, ${c3c}, ${c3d}"/></b>
</br>
</br>

<b><spring:message code="c4"></spring:message> : <jstl:out value="${c4}"/></b>
</br>
</br>

<b><spring:message code="c5"></spring:message> : <jstl:out value="${c5a}, ${c5b}"/></b>
</br>
</br>

<b><spring:message code="c6"></spring:message> : <jstl:out value="${c6a}, ${c6b}"/></b>
</br>
</br>

<b><spring:message code="c7"></spring:message> : <jstl:out value="${c7a}, ${c7b}"/></b>
</br>
</br>

<h2><b><spring:message code="levelb"></spring:message></b></h2>

<b><spring:message code="b1"></spring:message> : <jstl:out value="${b1}"/></b>
</br>
</br>

<b><spring:message code="b2"></spring:message> : <jstl:out value="${b2a}, ${b2b}, ${b2c}, ${b2d}"/></b>
</br>
</br>

<h2><b><spring:message code="levela"></spring:message></b></h2>

<b><spring:message code="a1"></spring:message> : <jstl:out value="${a1a}, ${a1b}"/></b>
</br>
</br>

<b><spring:message code="a2"></spring:message> : <jstl:out value="${a2a}, ${a2b}"/></b>
</br>
</br>

<b><spring:message code="a3"></spring:message> : <jstl:out value="${a3a}, ${a3b}"/></b>
</br>
</br>

<b><spring:message code="a4"></spring:message> : <jstl:out value="${a4}"/></b>
</br>
</br>




</security:authorize>
