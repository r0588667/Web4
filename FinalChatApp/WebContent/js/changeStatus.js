var xHRObject = new XMLHttpRequest();

function setStatus(){
	var status = document.getElementById("setStatus").value;
	changeStatus(status);
	document.getElementById("setStatus").innerHTML = '';
}

function changeStatus(status) {
	var myid = document.getElementById("myid").value;
	xHRObject.open("POST", "ControllerServlet", true);
	var information = "action=changestatus&status="+status+"&myid="+myid;
	xHRObject.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xHRObject.send(information);
	xHRObject.onreadystatechange = change;
	
}
function change(){
	if (xHRObject.status == 200) {
		if (xHRObject.readyState == 4) {
			var status = JSON.parse(xHRObject.responseText);
			var statusDiv = document.getElementById("status");
			statusDiv.innerHTML = status;
			}
	}
}