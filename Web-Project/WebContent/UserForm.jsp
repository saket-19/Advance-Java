<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br><br><br><br><br>

<div align="center">
<h1 style=color:brown;> User Form </h1>
<form action="">
<table>
<tr>
<th>First Name:</th>
<td><input type="text" name="FirstName" value=""
          placeholder="enter FirstName">
          </td>
          </tr>
 <tr>
<th>Last Name:</th>
<td><input type="text" name="LastName" value=""
          placeholder="enter lastName">
          </td>
          </tr>
          
<tr>
<th>Login:</th>
<td><input type="email" name="login" value=""
          placeholder="enter login">
          </td>
          </tr>
<tr>
<th>Password:</th>
<td><input type="Password" name="password" value=""
          placeholder="enter password">
          </td>
          </tr>
<tr>
<th>Dob:</th>
<td><input type="Date" name="dob" value=""
          >
          </td>
          </tr>
          
<tr><th></th><td><input type="submit" name="operation" value="save">
</td>
</tr>

</table>

</form>


</div>

</body>
</html>