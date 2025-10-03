<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Telugu Bible</title>
    <link rel="stylesheet" href="resources/style.css">
    <style>
        .accordion-button:focus,
        .accordion-button:active,
        .btn:focus,
        .btn:active {
            outline: none !important;
            box-shadow: none !important;
        }
    </style>
</head>
<body class="bg-light">

<!-- Navbar -->
<%@include file="resources/navbar.html"%>

<div class="container py-4">
    <div class="m-2 p-2">
        <h1 class="text-center">బైబిల్ గ్రంథము</h1>
    </div>

    <div class="d-flex flex-column flex-lg-row gap-4">
        <!-- Old Testament -->
        <div class="flex-fill" id="OT">
            <h3 class="text-center fw-bold mb-3">పాత నిబంధన</h3>
            <div class="accordion" id="OTAccordion">
                <c:forEach var="book" items="${OT}" varStatus="loop">
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="OTheading${loop.index}">
                            <button class="accordion-button collapsed" type="button"
                                    data-bs-toggle="collapse"
                                    data-bs-target="#OTcollapse${loop.index}"
                                    aria-expanded="false"
                                    aria-controls="OTcollapse${loop.index}">
                                    ${book.telugu} - (${book.name})
                            </button>
                        </h2>
                        <div id="OTcollapse${loop.index}" class="accordion-collapse collapse"
                             aria-labelledby="OTheading${loop.index}" data-bs-parent="#OTAccordion">
                            <div class="accordion-body d-flex flex-wrap">
                                <c:forEach begin="1" end="${book.chapters}" var="i">
                                    <a href="ChapterView?book=${book.name}&chapter=${i}"
                                       class="btn btn-outline-primary m-1">${i}</a>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <!-- New Testament -->
        <div class="flex-fill" id="NT">
            <h3 class="text-center fw-bold mb-3">కొత్త నిబంధన</h3>
            <div class="accordion" id="NTAccordion">
                <c:forEach var="book" items="${NT}" varStatus="loop">
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="NTheading${loop.index}">
                            <button class="accordion-button collapsed" type="button"
                                    data-bs-toggle="collapse"
                                    data-bs-target="#NTcollapse${loop.index}"
                                    aria-expanded="false"
                                    aria-controls="NTcollapse${loop.index}">
                                    ${book.telugu} - (${book.name})
                            </button>
                        </h2>
                        <div id="NTcollapse${loop.index}" class="accordion-collapse collapse"
                             aria-labelledby="NTheading${loop.index}" data-bs-parent="#NTAccordion">
                            <div class="accordion-body d-flex flex-wrap">
                                <c:forEach begin="1" end="${book.chapters}" var="i">
                                    <a href="ChapterView?book=${book.name}&chapter=${i}"
                                       class="btn btn-outline-primary m-1">${i}</a>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
