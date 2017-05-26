var xHRObject = new XMLHttpRequest();

function addFriend() {
	var myid = document.getElementById("myid").value;
	var id = document.getElementById("addFriendID").value;
	xHRObject.open("POST", "ControllerServlet", true);
	var information = "action=addFriend&id="+id+"&myid="+myid;
	xHRObject.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xHRObject.send(information);
}