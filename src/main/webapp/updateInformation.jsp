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
    <h1>Your Information</h1>

    <form action="" method="post">
        <label>Email:</label><br>
        <input type="email" name="email" value="${employee.email}"><br>

        <label>First name:</label><br>
        <input type="text" name="firstName" value="${employee.firstName}"><br>

        <label>Last name:</label><br>
        <input type="text" name="lastName" value="${employee.lastName}"><br>

        <label>Street:</label><br>
        <input type="text" name="street" value="${employee.street}"><br>

        <label>City:</label><br>
        <input type="text" name="city" value="${employee.city}"><br>

        <label>Zipcode:</label><br>
        <input type="text" name="zipcode" value="${employee.zipcode}"><br>

        <label>Phone:</label><br>
        <input type="number" name="phone" value="${employee.phone}"><br>

        <input type="submit" value="Update">
    </form>

    <form action="/employee-homepage">
        <input type="submit" value="Go back">
    </form>
</body>
</html>