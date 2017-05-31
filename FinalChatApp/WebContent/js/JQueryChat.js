var path = "http://localhost:8082/FinalChatApp/ControllerServlet?";
$(function(){
	startChat();
	sendMessage();
	getMessage();
});


function startChat(){
	$("#startChat").click(function(){
		var myid = $("#myid").val();
		var chatmate = $("#startChatID").val();
		if(myid == chatmate){
			alert("You can't chat with yourself");
		}
		else {
		$.ajax({
			url: path+"action=startChat",
			type: "POST",
			data : "myid="+myid+"&chatmate="+chatmate,
			success:function(){
				$("#chatmate").val(chatmate);
				$("#chatHeader").text("Sending Message to: "+chatmate);
				$("#chatMessages").empty();
			}
		})
		}
	});
}

function sendMessage(){
	$("#sendMessage").click(function(){
		var sender = $("#myid").val();
		var receiver = $("#startChatID").val();
		var message = $("#messageBox").val();
		$.ajax({
			url: path+"action=sendMessage",
			type: "POST",
			data : "sender="+sender+"&receiver="+receiver+"&message="+message,
			success:function(){
				$("#chatMessages").append("<p>"+sender+" :"+message+" </p>");
				$("#messageBox").val('');
			}
		})
	});
}
function getMessage(){
	$.ajax({
		url: path+"action=getMessage",
		data : "myid="+$("#myid").val(),
		type: "POST",
		datatype : "JSON",
		success:function(data){
			data = JSON.parse(data);
			for(var i = 0; i < data.length;i++){
				$("#chatMessages").append("<p>"+data[i].sender+": "+data[i].message+"</p>");
			}
		}
	})
	setTimeout("getMessage()","5000");
}