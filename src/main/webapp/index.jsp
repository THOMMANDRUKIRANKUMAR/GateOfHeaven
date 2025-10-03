<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="resources/style.css" rel="stylesheet">
</head>

<body>
    <%@include file="resources/navbar.html"%>
<h1><%= "Hello World!" %>
</h1>
<br/>

<a href="hello-servlet">Hello Servlet</a>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous">
</script>
</body>
</html>