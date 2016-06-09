$('.myTuto').click(function(event){
	event.stopPropagation();
	tuto_id = $(this).attr("id");
	tuto_id = Number(tuto_id);
	//alert(tuto_id);

	window.location.hash = "tuto:"+tuto_id;
	
	/*$.ajax({
		url: 'faces/tutoDetails.xhtml', 
		type: 'post', 
		data: 'tutoId='+tuto_id, 
		success: function(result) {
			location.hash = "tuto:"+tuto_id;
			$("#container").html(result);
		}
	});*/
	
});

$('.tutoOwner').click(function(event){
	event.stopPropagation();
	userName = $(this).attr("id");
	window.location.hash = "user:"+userName;
	/*
	
	$.ajax({
		url: 'faces/profilePage.xhtml', 
		type: 'post', 
		data:'username='+userName, 
		success: function(result) {
			location.hash = userName;
			$("#container").html(result);
		}
	});*/
})