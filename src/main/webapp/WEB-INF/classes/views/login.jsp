<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	<title>logIn</title>
	
	</head>
	<body>
	
	<table border="0" width ="100%" height="100%">
		<tr>
			<td height ="90%" width ="100%">
				<form action="login" method="post">
					<fieldset>
						<legend>LOGIN</legend>
						<table border="0">
							<tr>
								<td><h3>User Name :</h3></td>
								<td><input type="text" name="username" value="<% 
										String value = request.getParameter("username");
										if(value == null)
											out.println("");
										else
											out.println(value);
											%>"></input></td>
								
							</tr>
							<tr>
								<td><h3> Password :</h3></td>
								<td><input type="password" name="password"/></td>
							</tr>
						</table>
						<hr/>
						
						</br>
						<input type ="submit" value="Submit"></input>
						
						 <a href="registration">go for registration</a>
					</fieldset>
				</form>
			</td>
		</tr>
	</table>
	</body>
</html>
