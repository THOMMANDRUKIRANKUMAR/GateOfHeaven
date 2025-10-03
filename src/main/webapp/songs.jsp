<%--
  Created by IntelliJ IDEA.
  User: Kiran
  Date: 01-10-2025
  Time: 09:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<html>

    <head>
        <title>Songs</title>
        <link href="resources/style.css" rel="stylesheet">
    </head>

<body>

    <%@include file="resources/navbar.html"%>

    <div class="col-11 col-md-10 col-lg-8 m-auto">
        <table class="table table-striped table-hover table-border">
            <thead>
                <tr>
                    <th>Song Name (Telugu)</th>
                    <th>Song Name (English)</th>
                    <th>Artist</th>
                    <th>Category</th>
                    <th>View</th>
                </tr>
            </thead>
            <tbody class="table-group-divider">
            <c:forEach var="song" items="${allSongsList}">
                <tr>

                    <td class="text-wrap">${song.songName}</td>
                    <td class="text-wrap">${song.songNameEnglish}</td>
                    <td class="text-wrap"><a href="Songs?artist=${song.songArtist}" class="link-underline-opacity-0 link-underline-opacity-100-hover">${song.songArtist}</a></td>
                    <td class="text-wrap"><a href="Songs?category=${song.songCategory}" class="link-underline-opacity-0 link-underline-opacity-100-hover">${song.songCategory}</a></td>
                    <td class="text-wrap"><a href="Songs?id=${song.serialNumber}" class="btn btn-primary btn-sm sh-1">View</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous">
</script>
</body>
</html>