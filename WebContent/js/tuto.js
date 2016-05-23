$('.myTuto').click(function(event){
	tuto_id = $(this).attr("id");
	tuto_id = Number(tuto_id);
	//alert(tuto_id);
	$.ajax({
		url: 'tutoDetails', 
		type: 'post', 
		data: 'tutoId='+tuto_id, 
		success: function(result){
			//location.hash = userName;
			$(".container").html(result);
		}
	});
});

$('.tutoOwner').click(function(event){
	event.stopPropagation();
	userName = $(this).attr("id");
	$.ajax({url: 'getUser', type: 'post', data:'username='+userName, success: function(result){
		location.hash = userName;
		$(".container").html(result);
	}});
})