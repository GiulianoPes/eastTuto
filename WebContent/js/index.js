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
			//alert("updateHash - page: "+pageHash);
			pageHash +=".xhtml";
			$.ajax({
				url: "faces/"+pageHash, 
				type: 'post', 
				success: function(result){
					$("#container").html(result);
				}
			});
		}else if(hash.substring(1,5)=="tuto"){
			tutoHash = hash.substring(6,hash.size);
			//alert("updateHash - tuto: "+tutoHash);
			$.ajax({
				url: 'faces/tutoDetails.xhtml', 
				type: 'post', 
				data: 'tutoId='+tutoHash, 
				success: function(result) {
					$("#container").html(result);
				}
			});
		}else{
			alert("Risorsa: "+hash+" inesistente");
		}
	}
	if(Hash!=""){
		
		updateHashPage(Hash);
		
	}else{
		$.ajax({
			url: 'faces/homeContent.xhtml',
			type: 'post',
			success: function(result){
				$("#container").html(result);
			}
		});
	}


	$(".headerInput").click(function(event){
		action = $(this).attr("id");
		if(action == "personalPage"){
			window.location.hash = "user:"+$(this).attr("value");
		}else if (action == "homeContent"){
			
			window.location = "";
		}else{
			window.location.hash = "page:"+$(this).attr("id");
		}
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