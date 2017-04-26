<%--
 * list.jsp
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<div class="table-responsive">
<div>
<h3><spring:message code="administrator.dashboard.avgAgeCustomer" /></h3>
</div>



		<center><jstl:out value="${avgAgeCustomer}" /></center>






<div>
<h3><spring:message code="administrator.dashboard.ratioManWoman" /></h3>
</div>
<div class="table-responsive">
<display:table name="ratioManWoman" id="row" class="table" keepStatus="false" pagesize="5"  >
	
	<spring:message code="administrator.dashboard.ratioMan" var="ratioMan" ></spring:message>
	<display:column  title="${ratioMan}"><jstl:out value="${row[0]}" /></display:column>
	
	<spring:message code="administrator.dashboard.ratioWoman" var="ratioWoman" ></spring:message>
	<display:column  title="${ratioWoman}"><jstl:out value="${row[1]}" /></display:column>
	
</display:table>
</div>






<div>
<h3><spring:message code="administrator.dashboard.getPaintersOrderByAverageStart" /></h3>
</div>
<div class="table-responsive">
<display:table name="getPaintersOrderByAverageStart" id="row" class="table" keepStatus="false" pagesize="5"  >
	
	<spring:message code="actor.name" var="nameColumn" ></spring:message>
	<display:column property="name" title="${nameColumn}"/>
	
	<spring:message code="actor.surname" var="surnameColumn" ></spring:message>
	<display:column property="surname" title="${surnameColumn}"/>
	
	<spring:message code="painter.averageStart" var="averageStartColumn" ></spring:message>
	<display:column title="${averageStartColumn}"><meter value="${row.averageStart}" min="0" max="5" optimum="3" low="3" high="5"></meter><br></display:column>
	
</display:table>
</div>	
</div>	