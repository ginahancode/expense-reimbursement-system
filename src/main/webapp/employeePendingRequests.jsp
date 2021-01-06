<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
    <h1>Your pending requests</h1>

    <table>
        <thead>
            <tr>
                <th>Amount</th>
                <th>Description</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="pendingRequest" items="${pendingRequests}">
                <tr>
                    <td><c:out value="${pendingRequest.amount}" /></td>
                    <td><c:out value="${pendingRequest.description}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <br>
    <br>
    <h1>Your resolved requests</h1>

    <table>
        <thead>
            <tr>
                <th>Amount</th>
                <th>Description</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="resolvedRequest" items="${resolvedRequests}">
                <tr>
                    <td><c:out value="${resolvedRequest.amount}" /></td>
                    <td><c:out value="${resolvedRequest.description}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <br>
    <form action="/employee-homepage">
        <input type="submit" value="Go back">
    </form>
</body>
</html>