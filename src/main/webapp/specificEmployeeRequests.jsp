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
    <h1>${employeeName}'s reimbursement requests</h1>

    <table>
        <thead>
            <tr>
                <th>Amount</th>
                <th>Description</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="request" items="${specificEmployeeRequests}">
                <tr>
                    <td><c:out value="${request.amount}" /></td>
                    <td><c:out value="${request.description}" /></td>
                    <td><c:out value="${request.status}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <form action="/manager-homepage">
        <input type="submit" value="Go back">
    </form>
</body>
</html>