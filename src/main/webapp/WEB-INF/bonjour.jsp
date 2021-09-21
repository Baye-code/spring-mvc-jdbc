<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Test</title>
</head>
<body>
    <form method="post" action="bonjour">
        <p>
            <label for="lastName">LastName : </label>
            <input type="text" name="lastName" id="lastName" />
        </p>
        <p>
            <label for="firstName">FirstName : </label>
            <input type="text" name="firstName" id="firstName" />
        </p>
        <p>
            <label for="email">Email : </label>
            <input type="text" name="email" id="email" />
        </p>
        <p>
            <label for="gender">Gender : </label>
            <input type="text" name="gender" id="gender" />
        </p>
        <p>
            <label for="yearScholar">YearScholar : </label>
            <input type="text" name="yearScholar" id="yearScholar" />
        </p>
        
        <input type="submit" />
    </form>
    
    <ul>
        <c:forEach var="student" items="${ students }">
            <li><c:out value="${ student.firstName }" /> <c:out value="${ student.lastName }" /></li>
            <li><c:out value="${ student.email }" /></li>
            <li><c:out value="${ student.gender }" /></li>
            <li><c:out value="${ student.yearScholar }" /></li>
        </c:forEach>
    </ul>    
</body>
</html>