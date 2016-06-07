$('body').ready(function(){

	userNameHash = location.hash;
	userName = location.hash.substring(1,userNameHash.size);

	if(userName!=""){
		$.ajax({
			url: 'getUser', 
			type: 'post',
			data:'username='+userName, 
			success: function(result){
				$(".container").html(result);
			}
		});
	}else{
		$.ajax({
			url: 'homeContent.jsp',
			type: 'post',
			success: function(result){
				$("#container").html(result);
			}
		});
	}
	
	$("#login-button").click(function(event){
		event.preventDefault();

		$('form').fadeOut(500);
		$('.wrapper').addClass('form-success');
	});	

	$("#personalPage").click(function(event){
		alert("ciao");
		$.ajax({
			url: 'getUser', 
			type: 'post',
			data:'username='+$("#personalPage").attr("value"), 
			success: function(result){
				$(".container").html(result);
				location.hash = $("#personalPage").attr("value");
			}
		});
		
	});
	
	/*
	$('#easyTutoLogo').click(function(event){
		 window.location.href='';
	});
	*/
	
});