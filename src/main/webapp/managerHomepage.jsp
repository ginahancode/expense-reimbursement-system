<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manager Homepage</title>

    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
    <h1>Welcome, ${managerName}!</h1>
    <h3>What would you like to do?</h3>

    <form action="/update-pending-requests">
        <input type="submit" value="View and update pending reimbursement requests">
    </form>

    <form action="/resolved-requests">
        <input type="submit" value="View resolved reimbursement requests">
    </form>

    <form action="/view-employees">
        <input type="submit" value="View reimbursement requests for a specific employee">
    </form>

    <form action="/">
        <input type="submit" value="Logout">
    </form>
</body>
</html>