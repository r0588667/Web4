var xHRObject = new XMLHttpRequest();
var webSocket
var path = "ws://localhost:8082/FinalChatApp/HandlerEndPoint";
window.onunload = closeSocket

function openSocket(){
	webSocket = new WebSocket(path);
	
	 webSocket.onopen = function(event){
     };
     webSocket.onmessage = function(event){
    	writeResponse(event.data);
     }
}

function writeResponse(event){
	var test = JSON.parse(event);
	var nickName = test.name;
	var response = test.text;
	var article = test.article;
	var table = document.getElementsByTagName("table");
	var tr = document.createElement("tr");
	var th = document.createElement("th");
	th.innerHTML= nickName;
	var td = document.createElement("td");
	td.innerHTML = response;
	tr.appendChild(th);
	tr.appendChild(td);
	table[article].appendChild(tr);
	
}

function closeSocket(){
    webSocket.onclose = function(event){
    };
    webSocket.close();
}

function addComment(article){
	var arrayNickNames = document.getElementsByClassName("nickName");
	var nickname = arrayNickNames[article].value;
	var arraytext = document.getElementsByClassName("response");
	var text = arraytext[article].value;
	var myObj = { "action":"addComment", "name": nickname, "text":text, "article":article};
	var myJSON = JSON.stringify(myObj);
	if(nickname != "" && text != ""){
		webSocket.send(myJSON);
	}
	else {
		alert("Invalid Comment");
	}
}