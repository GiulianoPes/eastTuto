$(document).ready(function(){

	userNameHash = location.hash;
	userName = location.hash.substring(1,userNameHash.size);

	if(userName!=""){
		$.ajax({
			url: 'faces/profilePage.xhtml', 
			type: 'post',
			data:'username='+userName, 
			success: function(result){
				$("#container").html(result);
			}
		});
	}else{
		$.ajax({
			url: 'faces/homeContent.xhtml',
			type: 'post',
			success: function(result){
				$("#container").html(result);
			}
		});
	}
	
	$("#login-button").click(function(event){
		event.preventDefault();

		$('form').fadeOut(500);
		$('.wrapper').addClass('form-success');
	});	

	$("#personalPageButton").click(function(event){
		alert(location);
		//window.history.pushState({url: "" + targetUrl + ""}, "", "");
		$.ajax({
			url: 'faces/profilePage.xhtml', 
			type: 'post',
			data:'username='+$("#personalPageButton").attr("value"), 
			success: function(result){
				$("#container").html(result);
				location.hash = $("#personalPageButton").attr("value");
			}
		});
		
	});
	

	
	
	
	
	
	var setCurrentPage = function(url) {
		/*$.ajax({
			url: 'url', 
			type: 'post',
			data:'username='+$("#personalPageButton").attr("value"), 
			success: function(result){
				$("#container").html(result);
				location.hash = $("#personalPageButton").attr("value");
			}
		});*/
	    $('h2 span').html(url || "/");
	    $("#menu-nav a[href='" + url + "']").fadeTo(500, 0.3);
	};

	$('#menu-nav a').click(function(e){
	    e.preventDefault();
	    var targetUrl = $(this).attr('href'),
	        targetTitle = $(this).attr('title');
	    
	    $("#menu-nav a[href='" + window.location.pathname + "']").fadeTo(500, 1.0);
	    
	    window.history.pushState({url: "" + targetUrl + ""}, targetTitle, targetUrl);
	    setCurrentPage(targetUrl);
	});

	window.onpopstate = function(e) {
	    $("#menu-nav a").fadeTo('fast', 1.0);
	    setCurrentPage(e.state ? e.state.url : null);
	};
	
	/*
	$('#easyTutoLogo').click(function(event){
		 window.location.href='';
	});
	*/	
});