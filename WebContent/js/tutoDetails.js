$(document).ready(function() {
	
	$(".editTutoButton").click(function() {
		tuto_id = $(this).attr("id");
		window.location.hash = "edit:"+tuto_id;
	});

});