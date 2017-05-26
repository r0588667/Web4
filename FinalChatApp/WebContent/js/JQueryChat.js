$(function(){
	startChat();
	sendMessage();
	getMessage();
});


function startChat(){
	$("#startChat").click(function(){
		var myid = $("#startChatID").val();
		var chatmate = $("#startChatID").val();
		$.ajax({
			url: "http://localhost:8082/FinalChatApp/ControllerServlet?action=startChat",
			type: "POST",
			data : "myid="+myid+"&chatmate="+chatmate,
			success:function(){
				$("#chatmate").val(chatmate);
				$("#chatHeader").text("Sending Message to: "+chatmate);
			}
		})
	});
}

function sendMessage(){
	$("#sendMessage").click(function(){
		var sender = $("#startChatID").val();
		var receiver = $("#startChatID").val();
		var message = $("#messageBox").val();
		$.ajax({
			url: "http://localhost:8082/FinalChatApp/ControllerServlet?action=sendMessage",
			type: "POST",
			data : "sender="+sender+"&receiver="+receiver+"&message="+message,
			success:function(){
				$("#chatbox").append("<p>"+sender+" :"+message+" </p>");
				$("#messageBox").val('');
			}
		})
	});
}
function getMessage(){
	$.ajax({
		url: "http://localhost:8082/FinalChatApp/ControllerServlet?action=getMessage",
		data : "myid="+$("#myid").val(),
		type: "POST",
		datatype : "JSON",
		success:function(data){
			data = JSON.parse(data);
			for(var i = 0; i < data.length;i++){
				$("#chatbox").append("<p>"+data[i].sender+": "+data[i].message+"</p>");
			}
		}
	})
	setTimeout("getMessage()","5000");
}
