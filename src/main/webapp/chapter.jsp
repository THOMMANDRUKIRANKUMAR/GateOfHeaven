<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${bookName} - Chapter ${chapterNumber}</title>

    <link rel="stylesheet" href="resources/style.css">

</head>
<body>
<%@ include file="resources/navbar.html" %>

<div class="container py-4">
    <!-- Title + Page Font Controls -->
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h2 class="mb-0">${bookName} - ${chapterNumber} - అధ్యాయం </h2>
        <div>
            <button class="btn btn-sm btn-outline-secondary me-2" id="pageFontDecrease">A-</button>
            <button class="btn btn-sm btn-outline-secondary" id="pageFontIncrease">A+</button>
        </div>
    </div>

    <!-- Verse List -->
    <ol class="list-group list-group-flush" id="versesContainer">
        <c:forEach var="verse" items="${versesList}">
            <li class="list-group-item verse-item" data-verse-number="${verse.verseNumber}">
                <span class="verse-number fw-bold">${verse.verseNumber}</span>
                <span class="verse-short">${fn:escapeXml(verse.verse)}</span>
                <!-- hidden full text -->
                <span class="verse-full d-none">${fn:escapeXml(verse.verse)}</span>
            </li>
        </c:forEach>
    </ol>
</div>

<!-- Fullscreen Offcanvas -->
<div class="offcanvas offcanvas-top offcanvas-fullscreen" tabindex="-1" id="verseOffcanvas">
    <div class="offcanvas-header bg-primary text-white">
        <h5 class="offcanvas-title" id="verseTitle">${bookName} - ${chapterNumber} - అధ్యాయం </h5>
        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas"></button>
    </div>
    <div class="offcanvas-body">
        <div class="d-flex justify-content-end mb-3">
            <button class="btn btn-sm btn-outline-secondary me-2" id="fontDecrease">A-</button>
            <button class="btn btn-sm btn-outline-secondary" id="fontIncrease">A+</button>
        </div>
        <p id="verseText"></p>
    </div>
</div>

<!-- Go to Top Button -->
<button id="goTopBtn" class="btn btn-primary">↑</button>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script>
    const versesContainer = document.getElementById("versesContainer");
    const verseTitle = document.getElementById("verseTitle");
    const verseText = document.getElementById("verseText");
    const offcanvasEl = document.getElementById("verseOffcanvas");
    const offcanvas = new bootstrap.Offcanvas(offcanvasEl);

    // Font sizes
    let verseFont = 1.6;
    let pageFont = 1.0;

    // Verse click handler
    versesContainer.addEventListener("click", e => {
        const li = e.target.closest(".verse-item");
        if (!li) return;
        const num = li.dataset.verseNumber;
        const full = li.querySelector(".verse-full").textContent;

        verseTitle.innerText = "Verse " + num;
        verseText.innerText = full;
        verseText.style.fontSize = verseFont + "rem";

        offcanvas.show();
    });

    // Offcanvas font controls
    document.getElementById("fontIncrease").addEventListener("click", () => {
        verseFont += 0.2;
        verseText.style.fontSize = verseFont + "rem";
    });
    document.getElementById("fontDecrease").addEventListener("click", () => {
        if (verseFont > 0.8) verseFont -= 0.2;
        verseText.style.fontSize = verseFont + "rem";
    });

    // Page font controls
    document.getElementById("pageFontIncrease").addEventListener("click", () => {
        pageFont += 0.1;
        versesContainer.style.fontSize = pageFont + "rem";
    });
    document.getElementById("pageFontDecrease").addEventListener("click", () => {
        if (pageFont > 0.6) pageFont -= 0.1;
        versesContainer.style.fontSize = pageFont + "rem";
    });

    // Go to top
    document.getElementById("goTopBtn").addEventListener("click", () => {
        window.scrollTo({top: 0, behavior: "smooth"});
    });
</script>
</body>
</html>
