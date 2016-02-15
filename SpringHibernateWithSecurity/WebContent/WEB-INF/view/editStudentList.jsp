<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Spring hibernate with Security</title>
    </head>
    <body>
    <h2>Employee Management Screen </h2>
    <form:form method="post" action="add" commandName="student">
        <table>
        <tr>
            <td><form:label path="name"><spring:message code="label.name"/></form:label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="address"><spring:message code="label.address"/></form:label></td>
            <td><form:input path="address" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message code="label.add"/>"/>
            </td>
        </tr>
    </table> 
    </form:form>
    <h3>Employees</h3>
    <c:if  test="${!empty studentList}">
    <table class="data">
    <tr>
    	<th>ID</th>
        <th>Name</th>
        <th>Address</th>
    </tr>
    <c:forEach items="${studentList}" var="std">
        <tr>
        	<td>${std.id }</td>
            <td>${std.name}</td>
            <td>${std.address}</td>
        </tr>
    </c:forEach>
    </table>
    </c:if>
    </body>
</html>