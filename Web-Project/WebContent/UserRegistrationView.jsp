<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>

	<div align="center">
	<%String smsg = (String) request.getAttribute("successMsg");%>
	
	<h2 style="color:green;"><%=smsg != null ? smsg : "" %></h2>
		<h1 style="color: red;">User Form</h1>
		<form action="UserRegistrationCtl" method="post">
			<table>
				<tr>
					<th>First Name:</th>
					<td><input type="text" name="firstName" value=""
						placeholder="enter FirstName"></td>
				</tr>
				<tr>
					<th>Last Name:</th>
					<td><input type="text" name="lastName" value=""
						placeholder="enter lastName"></td>
				</tr>

				<tr>
					<th>Login:</th>
					<td><input type="email" name="login" value=""
						placeholder="enter login"></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="password" name="password" value=""
						placeholder="enter password"></td>
				</tr>
				<tr>
					<th>Dob:</th>
					<td><input type="date" name="dob" value=""></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="save">
					</td>
				</tr>

			</table>

		</form>


	</div>

</body>
</html>