<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import=" javax.servlet.jsp.PageContext" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <link href="css/video-js.css" rel="stylesheet">

    <!-- If you'd like to support IE8 -->
    <script src="js/videojs-ie8.min.js"></script>
    <title>YOU GOT THE DUD</title>
</head>
<body>
    <video id="my-video" class="video-js" controls preload="auto" width="640" height="264" data-setup='{ "controls": false, "autoplay": true, "preload": "auto" , "loop": "true"}'>
        <source src="fonts/VIDEO.mp4" type='video/mp4'>
        <p class="vjs-no-js">
            To view this video please enable JavaScript, and consider upgrading to a web browser that
            <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
        </p>
    </video>
    <script src="js/video.js"></script>
</body>
</html>
