$('body').ready(function(){


	$('.categoryItem').click(function(event){
		alert($(this).attr("id"));
		$.ajax({url: 'viewCategory', type: 'post', data: 'nome='+$(this).attr("id"), success: function(result){
	        $("#conteiner").html(result);
	    }});
	})
	
	$.ajax({url: 'lastTuto', type: 'post' , success: function(result){
        $("#lastTuto").html(result);
    }});

	

});