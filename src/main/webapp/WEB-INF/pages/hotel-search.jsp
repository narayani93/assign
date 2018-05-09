<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Hotels</title>
<style>
body {
    background-color: pink;
}
</style>

</head>
<body onload="tablec()">
<h2>Search Hotels</h2>
<form method="post" action="hotel-search">
    <table>
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
            <input type="submit" value="search"/>
        </td>
    </tr>
    </table>
</form>
<div><a href="index.jsp">Go Home</a></div>
</body>
<script type="text/javascript">
function tablec(){
	var hotels = [];
	<c:forEach items="${result}" var="temp">
		var hotel = [];
		hotel.push("${temp.name}");
		hotel.push("${temp.address}");
		hotels.push(hotel);
	</c:forEach>
	hotels.sort(function(a, b){
	    if(a[0].toLowerCase() < b[0].toLowerCase()) return -1;
	    if(a[0].toLowerCase() > b[0].toLowerCase()) return 1;
	    return 0;
	});
	var table = document.createElement('table');
	table.setAttribute('border', "1");
	table.setAttribute('width', "500px");
	var row = document.createElement('tr');
	var cell = document.createElement('td');
	var content = document.createElement('b');
	content.textContent = 'Name';
	cell.appendChild(content);
	row.appendChild(cell);
	var cell = document.createElement('td');
	var content = document.createElement('b');
	content.textContent = 'Address';
	cell.appendChild(content);
	row.appendChild(cell);
	table.appendChild(row);
	for (var i = 0; i < hotels.length; i++) {
		var row = document.createElement('tr');
		var cell = document.createElement('td');
		cell.textContent = hotels[i][0];
		row.appendChild(cell);
		var cell = document.createElement('td');
		cell.textContent = hotels[i][1];
        row.appendChild(cell);
        table.appendChild(row);
	}
	document.body.appendChild(table);
}
</script>
</html>