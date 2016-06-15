$(document).ready(function(){

	$('.categoryItem').click(function(event){
		id_categoria = $(this).attr("id");
		alert(id_categoria);
		$.ajax({
			url: 'viewCategory',
			type: 'post',
			data: 'nome='+$(this).attr("id"), 
			success: function(result) {
				$(".container").html(result);
			}
		});
	})
	/*
	$.ajax({		
		url: 'lastTuto', 
		type: 'post',
		success: function(result) {
			$("#lastTuto").html(result);
		}
	});*/

});