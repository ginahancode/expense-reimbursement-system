<!DOCTYPE html>
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
    <h1>Welcome, ${employeeName}!</h1>
    <h3>What would you like to do?</h3>

    <form action="/submit-request">
        <input type="submit" value="Submit a reimbursement request">
    </form>

    <form action="/requests">
        <input type="submit" value="View your pending and resolved reimbursement requests">
    </form>

    <form action="/update-information">
        <input type="submit" value="View and update your information">
    </form>

    <form action="/">
        <input type="submit" value="Logout">
    </form>
</body>
</html>