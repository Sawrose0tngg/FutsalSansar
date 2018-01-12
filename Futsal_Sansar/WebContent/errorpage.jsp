<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<input type="hidden" value="${message}" id="msg1">
	<input type="hidden" value="${url}" id="msg2">
	<script type="text/javascript">
		var mes = document.getElementById("msg1").value;
		var link = document.getElementById("msg2").value;
		alert(mes);
		window.location.replace(link);
	</script>

</body>
</html>