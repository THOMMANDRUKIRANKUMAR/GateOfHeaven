<%-- Created by IntelliJ IDEA. User: Kiran Date: 01-10-2025 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Song</title>
    <link rel="stylesheet" href="resources/style.css">
</head>
<body class="bg-light">

<%@include file="resources/navbar.html"%>

<div class="container mt-4">
    <c:if test="${not empty param.success or not empty param.exists}">
        <c:choose>
            <c:when test="${param.success eq 'true'}">
                <div class="alert alert-success alert-dismissible fade show shadow rounded-3" role="alert">
                    <h4 class="alert-heading">✅ Success!</h4>
                    <p>Your song has been <strong>saved successfully</strong> to the database.</p>
                    <hr>
                    <p class="mb-0">You can now <a href="Songs" class="alert-link">view all songs</a>.</p>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:when>

            <c:when test="${param.success eq 'false'}">
                <div class="alert alert-danger alert-dismissible fade show shadow rounded-3" role="alert">
                    <h4 class="alert-heading">❌ Oops! Something went wrong</h4>
                    <p>We couldn’t save your song. Please try again later.</p>
                    <hr>
                    <p class="mb-0">If the issue persists, <a href="contact.jsp" class="alert-link">contact support</a>.</p>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:when>

            <c:when test="${param.exists eq 'true'}">
                <div class="alert alert-warning alert-dismissible fade show shadow rounded-3" role="alert">
                    <h4 class="alert-heading">⚠️ Duplicate!</h4>
                    <p>This song already <strong>exists in the database</strong>. Try a different name.</p>
                    <hr>
                    <p class="mb-0">You can <a href="Songs" class="alert-link">browse all songs</a> instead.</p>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:when>
        </c:choose>
    </c:if>
</div>

<div class="container py-5 mt-5">
    <div class="row justify-content-center">
        <div class="col-lg-8 col-md-10">
            <div class="card shadow-lg border-0 rounded-3">
                <div class="card-header bg-primary text-white text-center">
                    <h4 class="mb-0"><i class="bi bi-music-note-beamed"></i> Add New Song</h4>
                </div>
                <div class="card-body p-4">

                    <!-- Form submits to SongServlet -->
                    <form class="needs-validation" action="Post" method="post" novalidate>

                        <!-- Song Name (Telugu only) -->
                        <div class="mb-3">
                            <label for="songName" class="form-label">Song Name (తెలుగు)</label>
                            <input type="text" class="form-control" id="songName" name="songName"
                                   placeholder="పాట పేరు" pattern="[\u0C00-\u0C7F\s]+" required>
                            <div class="invalid-feedback">
                                Please enter the song name in Telugu (only Telugu characters allowed).
                            </div>
                        </div>

                        <!-- Song Name English -->
                        <div class="mb-3">
                            <label for="songNameEnglish" class="form-label">Song Name (English)</label>
                            <input type="text" class="form-control" id="songNameEnglish" name="songNameEnglish"
                                   placeholder="Song Name in English" pattern="[A-Za-z\s]+" required>
                            <div class="invalid-feedback">
                                Please enter the song name in English (only A–Z letters allowed).
                            </div>
                        </div>

                        <!-- Song Data -->
                        <div class="mb-3">
                            <label for="songData" class="form-label">Song Data</label>
                            <textarea class="form-control" id="songData" name="songData" rows="5"
                                      placeholder="Enter the song lyrics/data here..." required></textarea>
                            <div class="invalid-feedback">
                                Please enter the song data (lyrics).
                            </div>
                        </div>

                        <!-- Song Artist -->
                        <div class="mb-3">
                            <label for="songArtist" class="form-label">Song Artist</label>
                            <input type="text" class="form-control" id="songArtist" name="songArtist"
                                   placeholder="Artist name (optional)">
                        </div>

                        <!-- Song Category -->
                        <div class="mb-3">
                            <label for="songCategory" class="form-label">Category</label>
                            <select class="form-select" id="songCategory" name="songCategory" required>
                                <option value="" selected disabled>-- Select Category --</option>
                                <option value="offerings">Offerings</option>
                                <option value="worship">Worship</option>
                                <option value="Thanks_Giving">Thanks Giving</option>
                                <option value="festival">Festival Songs</option>
                                <option value="special">Special Songs</option>
                                <option value="others">Others</option>
                            </select>
                            <div class="invalid-feedback">
                                Please select a category.
                            </div>
                        </div>

                        <!-- Song Date -->
                        <div class="mb-3">
                            <label for="songDate" class="form-label">Song Date</label>
                            <input type="date" class="form-control" id="songDate" name="songDate" required>
                            <div class="invalid-feedback">
                                Please select a valid date.
                            </div>
                        </div>

                        <!-- Submit -->
                        <div class="d-grid">
                            <button type="submit" class="btn btn-success btn-lg">
                                <i class="bi bi-check-circle"></i> Submit Song
                            </button>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<script>
    // Set default date as today
    document.getElementById('songDate').valueAsDate = new Date();

    // Bootstrap form validation
    (() => {
        'use strict'
        const forms = document.querySelectorAll('.needs-validation')
        Array.from(forms).forEach(form => {
            form.addEventListener('submit', event => {
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }
                form.classList.add('was-validated')
            }, false)
        })
    })();

    // Auto-hide alerts after 5 seconds
    document.addEventListener("DOMContentLoaded", () => {
        const alerts = document.querySelectorAll('.alert');
        if (alerts.length > 0) {
            setTimeout(() => {
                alerts.forEach(alert => {
                    const bsAlert = bootstrap.Alert.getOrCreateInstance(alert);
                    bsAlert.close();
                });
            }, 5000); // 5 seconds
        }
    });
</script>

</body>
</html>
