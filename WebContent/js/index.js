

$('body').ready(function(){


	$("#login-button").click(function(event){
		event.preventDefault();

		$('form').fadeOut(500);
		$('.wrapper').addClass('form-success');
	});	
	
	$("#myTuto").click(function(event){
		
		$.ajax({url: 'myTuto.jsp', type: 'post' , success: function(result){
			
	        $(".container").html(result);
	    }});
	});
	
	$.ajax({url: 'homeContent.jsp', type: 'post' , success: function(result){
        $(".container").html(result);
    }});
	
	



});
