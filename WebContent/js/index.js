

$('body').ready(function(){


	$("#login-button").click(function(event){
		event.preventDefault();

		$('form').fadeOut(500);
		$('.wrapper').addClass('form-success');
	});	
	
	$.ajax({url: "homeContent.jsp", success: function(result){
        $(".container").html(result);
    }});


});
