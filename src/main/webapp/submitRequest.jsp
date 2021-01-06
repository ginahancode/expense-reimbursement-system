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
    <h1>Submit a Reimbursement Request</h1>

    <form action="submit-request" method="post">
        <label>Amount:</label><br>
        <input type="number" min="0" step="0.01" name="amount"><br>

        <label>Description:</label><br>
        <textarea rows="5" cols="33" maxlength="250" name="description"></textarea><br>

        <input type="submit" value="Submit">
    </form>

    <form action="/employee-homepage">
        <input type="submit" value="Go back">
    </form>
</body>
</html>