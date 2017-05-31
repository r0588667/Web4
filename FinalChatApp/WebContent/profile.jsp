<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="nl">
<head>
<meta charset="UTF-8">
<title>MyProfile</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<link rel="stylesheet" media="all" href="css/reset.css">
<link rel="stylesheet" media="all" href="css/project.css">
<link href='https://fonts.googleapis.com/css?family=Roboto'
	rel='stylesheet' type='text/css'>
</head>

<body onload="checkForFriends()">
<c:choose>
<c:when test="${empty id }">
<h1> You need to log in to see this page</h1>
</c:when>
<c:otherwise>
<input type="hidden" id="myid" value="${id}">
<input type="hidden" id="chatmate" value="">
<nav class="nav">
		<ul>
                        <li>
                        	<div class="HeaderItem" id="FriendOverview">
                        		<h1>My Friends</h1>
								<c:forEach var="friend" items="${friends}">
                    				<ul id="theid=${friend.id}">
                    					<li id="id">${friend.id}</li>
                    					<li id ="friendfirstName">${friend.firstName}</li>
                    					<li id="friendlastName">${friend.lastName}</li>
                    					<li>${friend.age}</li>
                    					<li id="friendstatus">${friend.status}</li>
                    				</ul>
                    			</c:forEach>
                        	</div>
                        </li>
                        <li>
                        	<div class="HeaderItem" id="startChat">
                        		<h1>StartChat</h1>
                        		<div class="ToHide">
                        		<input type="text" id="startChatID" name="startChatID" value="ID">
                        		<button id="startChat">Start Chat</button>
                        		</div>
                        	</div>
                        <li>
                        	<div class="HeaderItem" id="addFriend">
                        		<h1>Add Friend</h1>
                        		<div class="ToHide">
                        		<input type="text" id="addFriendID" name="addFriend" value="ID">
                        		<button onclick="addFriend()">Add</button>
                        		</div>
                        	</div>
                        </li>
                        <li>
                        	<div class="HeaderItem">
                        		<h1 id="status">${status}</h1>
                        		<div class="ToHide">
                        		<a onclick="changeStatus('Offline')"href="#">Offline</a>
                                <a onclick="changeStatus('Away')"href="#">Away</a>
                                <a onclick="changeStatus('Online')"href="#">Online</a>
                        		<input type="text" id="setStatus" name="setStatus" value="">
                        		<button onclick="setStatus()">Add</button>
                        		</div>
                        	</div>
                        </li>
                        <li><a href="ControllerServlet?action=Logout">Logout</a></li>
		</ul>
	</nav>
	<div class="container">
		
		<article id="chatbox">
			<h1 id="chatHeader"></h1>
            <input id="messageBox" type="text">
            <button id="sendMessage">Send Message</button>
            <div id="chatMessages">
			</div>
            </article>
		
	</div>
<button id="hide">Hide Menu</button>
	<script src="js/jquery.js"></script>
	<script src="js/addFriend.js"></script>
	<script src="js/checkFriends.js"></script>
	<script src="js/changeStatus.js"></script>
	<script src="js/JQueryChat.js"></script>
	<script src="js/hide.js"></script>
</c:otherwise>
</c:choose>
</body>
</html>