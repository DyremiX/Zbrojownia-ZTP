<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1, h2 {
            color: #333;
        }

        form {
            margin-bottom: 20px;
        }

        input[type="text"], input[type="submit"] {
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        tr:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
<h1>Employee Management System</h1>

<h2>Add Employee</h2>
<form action="employee" method="post">
    <input type="hidden" name="action" value="add">
    First Name: <input type="text" name="firstName"><br>
    Last Name: <input type="text" name="lastName"><br>
    Position: <input type="text" name="position"><br>
    <input type="submit" value="Add Employee">
</form>

<h2>Modify Employee</h2>
<form action="employee" method="post">
    <input type="hidden" name="action" value="modify">
    Employee ID: <input type="text" name="id"><br>
    First Name: <input type="text" name="firstName"><br>
    Last Name: <input type="text" name="lastName"><br>
    Position: <input type="text" name="position"><br>
    <input type="submit" value="Modify Employee">
</form>

<h2>Get Employee</h2>
<form action="employee" method="get">
    Employee ID: <input type="text" name="id"><br>
    <input type="submit" value="Get Employee">
</form>

<h2>Get All Employees</h2>
<form action="employee" method="get">
    <input type="submit" value="Get All Employees">
</form>
</body>
</html>
