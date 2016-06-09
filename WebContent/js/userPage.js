$(document).ready(function(){
	
	$('#homeButton').click(function(event){
		alert("ciao");
		window.history.pushState({url: "faces/profilePage.xhtml"+location.hash}, "", "");
		$.ajax({
			url: '/', 
			type: 'post',
			success: function(result){
				$("#container").html(result);
			}
		});
	});
	
	$('#follow').click(function(event){
		
		userNameHash = location.hash;
		userName = location.hash.substring(1,userNameHash.size);
		
		$.ajax({
			url: 'addFollowing',
			type: 'post',
			data: 'name_following='+userName,
			success: function(result) {
				$('#follow').val("- following -");
	        }
		});
		
		alert(userName);
	});
	
});