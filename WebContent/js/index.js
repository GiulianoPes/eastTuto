

$('body').ready(function(){

	if(location.hash!="#personal"){
		$.ajax({url: 'homeContent.jsp', type: 'post' , success: function(result){
			$(".container").html(result);
		}});
	}else if (location.hash=="#personal"){
		$.ajax({url: 'personalPage.jsp', type: 'post' , success: function(result){

			$(".container").html(result);
			location.hash = 'personal';
		}});
	}


	$("#login-button").click(function(event){
		event.preventDefault();

		$('form').fadeOut(500);
		$('.wrapper').addClass('form-success');
	});	

	$("#personalPage").click(function(event){

		$.ajax({url: 'personalPage.jsp', type: 'post' , success: function(result){

			$(".container").html(result);
			location.hash = 'personal';
		}});
	});







});
