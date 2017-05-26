var hidden = false;
$(function(){
	$("#hide").click(function(){
		if(hidden){
			$(".ToHide").show();
			hidden = false;
		}
		else {
			$(".ToHide").hide();
			hidden = true;
		}
	});
	
});