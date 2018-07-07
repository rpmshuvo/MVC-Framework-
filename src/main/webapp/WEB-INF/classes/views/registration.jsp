<%@page import="hibernate.Userinfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<BODY>
		<jsp:useBean id="user" class="model.UserBean"></jsp:useBean>
		<jsp:setProperty property="*" name="user"/>
		
		<table border="0" width ="100%" height="100%">
		<tr>
			<td height ="90%" width ="100%">
				<form method="post">
				<fieldset >
					<legend>REGISTRARION</legend>
					<table border= "0" align ="center" width="80%" height ="80%">
						
						
						<tr><td colspan ="2"><hr/></td></tr>
						<tr>
							<td><h3>User Name :</h3></td>
						   <td><input type="text" name="username"> </td>
						</tr>
						<tr><td colspan ="2"><hr/></td></tr>
						<tr>
							<td><h3>Password :</h3></td>
							<td><input type="password" name="password" ></td>
						</tr>	
						<tr><td colspan ="2"><hr/></td></tr>
						<tr>
							<td><h3>First Name :</h3></td>
						   <td><input type="text" name="firstname"> </td>
						</tr>
						<tr><td colspan ="2"><hr/></td></tr>
						<tr>
							<td><h3>Last Name :</h3></td>
						   <td><input type="text" name="lastname"> </td>
						</tr>
					</table>
					<hr/>
					<input type="submit" value="submit"/>
					<input type="reset"/>
				</fieldset>
				</form>
			</td>
		</tr>
	</table>
	</BODY>
</html>
<%
		String username=request.getParameter("username");
		String password= request.getParameter("password");
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		if(username!=null && password!=null && firstname!=null && lastname!= null){
			if(!username.trim().equals("") && !password.trim().equals("") && !firstname.trim().equals("") && !lastname.trim().equals("")){
				Userinfo.saveUser(user);
	         	response.sendRedirect("login");
			}
			
		}

// 		if(username!=null && !username.equals("")  && password!=null && !password.equals("")) {
// 	System.out.println("ok");
//         
//         }
%>