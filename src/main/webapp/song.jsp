<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Kiran--%>
<%--  Date: 01-10-2025--%>
<%--  Time: 09:42--%>
<%--  To change this template use File | Settings | File Templates.--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>
<html>
<head>
    <title>${song.songName} - Details</title>
    <link rel="stylesheet" href="resources/style.css">
</head>
<body>

<%@include file="resources/navbar.html"%>

<div class="container my-5 mt-3">
    <div class="card shadow-lg song-card p-4">
        <!-- Title -->
        <h2 class="mb-2 text-primary">${song.songName}</h2>
        <h5 class="text-muted mb-4">${song.songNameEnglish}</h5>

        <!-- Meta Info -->
        <div class="d-flex flex-wrap justify-content-between border-bottom pb-3 mb-3 mt-3">
            <c:if test="${not empty song.songArtist}">
                <p class="mb-2"><strong>Artist:</strong>
                    <a href="Songs?artist=${song.songArtist}" class="text-decoration-none">
                            ${song.songArtist}
                    </a>
                </p>
            </c:if>

            <p class="mb-2"><strong>Category:</strong>
                <a href="Songs?category=${song.songCategory}" class="text-decoration-none">
                    ${song.songCategory}
                </a>
            </p>

            <p class="mb-2"><strong>Date:</strong> ${song.songDate}</p>
        </div>

        <!-- Font controls -->
        <div class="mb-4 d-flex gap-2">
            <button class="btn btn-outline-secondary btn-sm" onclick="changeFontSize('increase')">A+</button>
            <button class="btn btn-outline-secondary btn-sm" onclick="changeFontSize('decrease')">A-</button>
        </div>

        <!-- Lyrics -->
        <div class="lyrics mb-4" id="lyrics">
            ${song.songData}
        </div>

        <!-- Back Button -->
        <div class="text-center">
            <a href="Songs" class="btn btn-primary">⬅ Back to All Songs</a>
        </div>
    </div>
</div>



<script>
    function changeFontSize(action) {
        const lyrics = document.getElementById("lyrics");
        let style = window.getComputedStyle(lyrics, null).getPropertyValue('font-size');
        let currentSize = parseFloat(style);
        if (action === 'increase') {
            lyrics.style.fontSize = (currentSize + 2) + 'px';
        } else if (action === 'decrease' && currentSize > 12) {
            lyrics.style.fontSize = (currentSize - 2) + 'px';
        }
    }
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous">

</body>
</html>
