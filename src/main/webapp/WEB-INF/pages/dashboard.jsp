
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Dashboard</title>
  <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/student-icon.png" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css">
</head>
<body>
	<h1 class="welcome" id="welcomeMessage" style="margin:1rem;">Welcome, ${username}</h1>
	
  <header class="topbar">
    <div class="logo">
      <span class="brand">Acade<span class="highlight">mix</span></span>
    </div>
    <nav class="nav-links">
      <a href="#">Home</a>
      <a href="#">All Course</a>
      <a href="#">Pages</a>
      <a href="#">Blog</a>
      <a href="#">Contact</a>
    </nav>
    <div class="hamburger" onclick="toggleMenu()">&#9776;</div>

<div id="dropdownMenu" class="dropdown-content">
  <a href="${pageContext.request.contextPath}/students/studentForm">Update Profile</a>

  <form action="${pageContext.request.contextPath}/students/delete" method="post" onsubmit="return confirm('Are you sure you want to delete your account?');">
    <button type="submit" class="delete-btn">Delete Account</button>
  </form>

  <a href="${pageContext.request.contextPath}/students/logout" class="logout-link">Logout</a>
</div>
  </header>
  
  <section class="course-section">
    <h2><span class="highlight">All Courses</span> of Academix</h2>
    <div class="course-filters">
      <button>UI/UX Design</button>
      <button>Development</button>
      <button>Data Science</button>
      <button>Business</button>
      <button>Financial</button>
    </div>

    <div class="course-grid">
      <div class="course-card">
        <img src="${pageContext.request.contextPath}/images/course1.jpeg" alt="Course 1">
        <div class="course-info">
          <p class="instructor">Jason Williams <span class="tag">Science</span></p>
          <h3>Data Science and Machine Learning with Python – Hands On!</h3>
          <p class="meta">⏱️ 8h 15 mins • 📘 29 Lectures</p>
          <p class="price">$385.00 <del>$440.00</del> <span class="rating">4.9 ★</span></p>
        </div>
      </div>

      <div class="course-card">
        <img src="${pageContext.request.contextPath}/images/couse2.jpeg" alt="Course 2" >
        <div class="course-info">
          <p class="instructor">Pamela Foster <span class="tag">Science</span></p>
          <h3>Create Amazing Color Schemes for Your UX Design Projects</h3>
          <p class="meta">⏱️ 8h 15 mins • 📘 29 Lectures</p>
          <p class="price">$420.00 <span class="rating">4.9 ★</span></p>
        </div>
      </div>

      <div class="course-card">
        <img src="${pageContext.request.contextPath}/images/course3.jpeg" alt="Course 3" >
        <div class="course-info">
          <p class="instructor">Rose Simmons <span class="tag">Science</span></p>
          <h3>Culture & Leadership: Strategies for a Successful Business</h3>
          <p class="meta">⏱️ 8h 15 mins • 📘 29 Lectures</p>
          <p class="price">$295.00 <del>$340.00</del> <span class="rating">4.9 ★</span></p>
        </div>
      </div>


    </div>
  </section>

<script>


function toggleMenu() {
	  const menu = document.getElementById("dropdownMenu");
	  menu.style.display = (menu.style.display === "block") ? "none" : "block";
	}

</script>
</body>
</html>

