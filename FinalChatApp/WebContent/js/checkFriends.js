var xHRObject
var myid = 0;
function checkForFriends(){
	var myid = document.getElementById("myid").value;
	xHRObject = new XMLHttpRequest();
	xHRObject.open("GET", "ControllerServlet?action=checkFriendList&myid="+myid, true);
	xHRObject.send(null);
	xHRObject.onreadystatechange = function () {
		if(xHRObject.readyState === XMLHttpRequest.DONE && xHRObject.status == 200){
			writeResponse();
		}
	}
}

function writeResponse(){
	setTimeout("checkForFriends()", 10000);
	if (xHRObject.status == 200) {
		if (xHRObject.readyState == 4){
			var friendarray = xHRObject.responseText;
				updateFriendList(friendarray);
			}
	}	
}	

function updateFriendList(friendarray){
	var array = JSON.parse(friendarray);
	for(i = 0; i < array.length;i++){
		var theid = array[i].id;
		var status = array[i].status;
		var ul = document.getElementById("theid="+theid);
		if (ul != null){
			var lis = ul.children;
			var friendstatus = lis[3];
			friendstatus.innerHTML = status;
		}
		else {
			var friendOverview = document.getElementById("FriendOverview");
			var newul = document.createElement("ul");
			newul.id = "theid="+theid;
			var litheid = document.createElement("li");
			litheid.innerHTML = theid;
			var lifirstName = document.createElement("li");
			lifirstName.innerHTML = array[i].firstName;
			var lilastName = document.createElement("li");
			lilastName.innerHTML = array[i].lastName;
			var listatus = document.createElement("li");
			listatus.innerHTML = status;
			newul.appendChild(litheid);
			newul.appendChild(lifirstName);
			newul.appendChild(lilastName);
			newul.appendChild(listatus);
			friendOverview.appendChild(newul);
		}
	}
}