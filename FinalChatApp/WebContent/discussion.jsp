<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" media="all" href="css/reset.css">
<link rel="stylesheet" media="all" href="css/project.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Discussion Page</title>
</head>
<body onload="openSocket()">

<c:forEach var="discussion" items="${discussions}">
<article id="DiscussionArticle">
<div class="TopicBody">
<h1 id="title">${discussion.title}</h1>
<p>${discussion.text}</p>
</div>
<div class="Comments">
<h1>Comments: </h1>
<table>
<c:forEach var="comment" items="${discussion.comments}">
<tr>
<th>
${comment.name}
</th>
<td>${comment.text}</td>
</tr>
</c:forEach>
</table>
</div>
<div name="ResponseBody" class="ResponseBody">
NickName:
<input class="nickName" name="nickName" type="text">
Response:
<input class="response" name="Response" type="text">
<button onclick="addComment(${discussion.counter})">Click</button>
</div>
</article>
</c:forEach>
<script type="text/javascript" src="js/commentHandler.js"></script>
</body>
</html>