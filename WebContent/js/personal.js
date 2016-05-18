$('body').ready(function(){


	$.ajax({url: 'myTuto.jsp', type: 'post' , success: function(result){
		
        $("#myTutoBox").html(result);
    }});


});