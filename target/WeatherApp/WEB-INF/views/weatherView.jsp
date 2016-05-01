<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>

<title>Weather Application</title>
<script type="text/javascript">
	function cityChanged() {
		//alert($("#city").val());
		var zip = $("#city").val();
		var urlStr = "data/" + zip;
		//alert(urlStr);
		if (zip > 0) {
			$.ajax({
				url : urlStr
			}).done(function(data) {
				$("#cityname").html(data.cityName);
				$("#time").html(data.time);
				$("#weather").html(data.weather);
				$("#temperature").html(data.temperature);
				$("#wind").html(data.wind);
			});
		}
	}
</script>
</head>

<body>
	<p>
		<select name="city" id="city" onchange="cityChanged()">
			<option value=0>Please select a city</option>
			<c:forEach items="${cities}" var="city">
				<option value="${city.key}">${city.value}</option>
			</c:forEach>
		</select>
	<p>
	<table id="weatherTable" style="display: block;">
		<tr>
			<td>City</td>
			<td id="cityname" style="min-width: 100px"></td>
		</tr>
		<tr>
			<td>Updated Time</td>
			<td id="time" style="min-width: 100px"></td>
		</tr>
		<tr>
			<td>Weather</td>
			<td id=weather style="min-width: 100px"></td>
		</tr>
		<tr>
			<td>Temperature</td>
			<td id="temperature" style="min-width: 100px"></td>
		</tr>
		<tr>
			<td>Wind</td>
			<td id="wind" style="min-width: 100px"></td>
		</tr>
	</table>

</body>
</html>