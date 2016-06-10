$(document).ready(function(){

	userNameHash = location.hash;
	userName = location.hash.substring(1,userNameHash.size);


	$('#follow').click(function(event){

		userNameHash = location.hash;
		userName = location.hash.substring(6,userNameHash.size);
		//alert(userName);
		
		$.ajax({
			url: 'followCall.xhtml',
			type: 'post',
			data: 'name_following='+userName,
			success: function(result){
				$('#follow').val("- following -");

			}
		});
		
	});
	$('.follower').click(function(event){
		window.location.hash = "user:"+$(this).attr("id");
	});
	
});