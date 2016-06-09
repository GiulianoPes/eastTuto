$(document).ready(function(){

	Hash = window.location.hash;
	
	window.onpopstate = function(e) {
		//alert("onpop"+history.state.url+" ");
		//alert("onpopo");
		
		if(Hash!=window.location.hash){
			updateHashPage(window.location.hash);
		}
		else if(Hash==""){
			$.ajax({
				url: "faces/homeContent.xhtml", 
				type: 'post', 
				success: function(result){
					$("#container").html(result);
				}
			});
		}
	   // setCurrentPage(e.state ? e.state.url : null);
	};
	
	var updateHashPage = function(hash) {
		//alert("updateHASH");
		if(hash.substring(1,5)=="user"){
			userHash = hash.substring(6,hash.size);
			//alert("updateHash - User: "+userHash);
			$.ajax({
				url: "faces/profilePage.xhtml", 
				type: 'post', 
				data: 'username='+userHash,
				success: function(result){
					$("#container").html(result);
				}
			});
		}else if(hash.substring(1,5)=="page"){
			pageHash = hash.substring(6,hash.size);
			$.ajax({
				url: "faces/"+pageHash+".xhtml", 
				type: 'post', 
				success: function(result){
					$("#container").html(result);
				}
			});
		}else if(hash.substring(1,5)=="tuto"){
			pageHash = hash.substring(6,hash.size);
			$.ajax({
				url: "faces/"+pageHash+".jsp", 
				type: 'post', 
				success: function(result){
					$("#container").html(result);
				}
			});
		}else{
			alert("Risorsa: "+hash+" inesistente");
		}
	}

	if(Hash!=""){
		
		updateHashPage(Hash);
		/*window.history.pushState({url: "faces/profilePage.xhtml"+location.hash}, "", "");
		$.ajax({
			url: 'faces/profilePage.xhtml', 
			type: 'post',
			data:'username='+userName, 
			success: function(result){
				$("#container").html(result);
				//alert(location);
				
			}
		});*/
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
		//setHistory(window.location);
		
		//window.location.hash = "user:"+$("#personalPageButton").attr("value");
		//alert("Sono il tasto"+history.state.url)
		/*$.ajax({
			url: 'faces/profilePage.xhtml', 
			type: 'post',
			data:'username='+$("#personalPageButton").attr("value"), 
			success: function(result){
				$("#container").html(result);
				window.location.hash = "user:"+$("#personalPageButton").attr("value");
				
			}
		});*/
	});
	$(".headerInput").click(function(event){
		action = $(this).attr("id");
		if(action == "personalPage"){
			window.location.hash = "user:"+$(this).attr("value");
		}else {
			window.location.hash = "page:"+$(this).attr("id");
		}
		//window.location.hash = "user:"+$("#personalPageButton").attr("value");
		//alert("Sono il tasto"+history.state.url)
		/*$.ajax({
			url: 'faces/profilePage.xhtml', 
			type: 'post',
			data:'username='+$("#personalPageButton").attr("value"), 
			success: function(result){
				$("#container").html(result);
				window.location.hash = "user:"+$("#personalPageButton").attr("value");
				
			}
		});*/
	});
	

	
	var setHistory = function(url){
		alert(url);
		//window.history.pushState({url: "faces/homeContent.xhtml"}, "", "");
	}
	
	
	
	var setCurrentPage = function(url) {
		//alert("setto "+url)
		if(url!=null){
			$.ajax({
				url: "faces/"+url, 
				type: 'post', 
				success: function(result){
					$("#container").html(result);
					//location.hash = $("#personalPageButton").attr("value");
				}
			});
		}
		
	   /* $('h2 span').html(url || "/");
	    $("#menu-nav a[href='" + url + "']").fadeTo(500, 0.3);*/
	};
	
		
	


	
	/*
	$('#easyTutoLogo').click(function(event){
		 window.location.href='';
	});
	*/	
});