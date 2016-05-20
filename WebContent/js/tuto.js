$('.myTuto').click(function(event){
	tuto_id = $(this).attr("id");
	alert(tuto_id);
});

$('.tutoOwner').click(function(event){
	event.stopPropagation();
	userName = $(this).attr("id");
	$.ajax({url: 'getUser', type: 'post', data:'username='+userName, success: function(result){
		location.hash = userName;
		$(".container").html(result);
	}});

})