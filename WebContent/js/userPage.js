
$('body').ready(function(){
	
	
	
	$('#follow').click(function(event){
		
		userNameHash = location.hash;
		userName = location.hash.substring(1,userNameHash.size);
		
		$.ajax({url: 'addFollowing', type: 'post' ,data: 'name_following='+userName , success: function(result){
			
	        $('#follow').val("- following -");
	        
	    }});
		
		alert(userName);
	});
	
	
	
	
	
});