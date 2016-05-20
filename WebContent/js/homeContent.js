$('body').ready(function(){


	$('.categoryItem').click(function(event){
		alert($(this).attr("id"));
	})
	
	$.ajax({url: 'lastTuto', type: 'post' , success: function(result){
        $("#lastTuto").html(result);
    }});

	

});