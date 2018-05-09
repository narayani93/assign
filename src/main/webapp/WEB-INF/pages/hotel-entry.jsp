<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel Entry Form</title>
<style>
body {
    background-color: lightblue;
}
</style>
<script type="text/javascript">
function validate(){
	var namebox = document.forms["form1"]["name"].value;
    if (namebox == "") {
        return false;
    }
}
</script>
</head>
<body>
	<h2>Hotel Entry Form</h2>
	<form name="form1" method="post" action="result" modelAttribute="hotel" onsubmit="return validate()">
    <table>
    <tr>
        <td>name</td>
        <td><input name="name"/></td>
    </tr>
    <tr>
        <td>address</td>
        <td><input name="address" type="text"/>&nbsp;(type without city)</td>
    </tr>
    <tr>
    	<td>City</td>
        <td>
        <select name="city">
		  <option value="1">Colombo</option>
		  <option value="2">Gampaha</option>
		  <option value="3">Kolpitiya</option>
		  <option value="4">Bambalapitiya</option>
		</select> 
		</td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="send"/>
        </td>
    </tr>
</table>
</form>
</body>
</html>