<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Spring5 MVC Hibernate Demo</title>
    <style type="text/css">
        table {
            width: 50%;
            border-collapse: collapse;
            border-spacing: 0px;
        }

        table td {
            border: 1px solid #565454;
            padding: 20px;
        }
    </style>
</head>
<body>
<h1>Input Form</h1>
<form action="addUser" method="post" modelAttribute="user">
    <table>
        <tr>
            <td>Name</td>
        </tr>
        <tr>
            <td>Email</td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Submit</button>
            </td>
        </tr>
    </table>
</form>

<h2>Users List</h2>
<table>
    <tr>
        <td><strong>Name</strong></td>
        <td><strong>Email</strong></td>
    </tr>
</table>
</body>
</html>