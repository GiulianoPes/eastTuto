$(document).ready(function(){

	Hash = window.location.hash;
	//alert(window.location);
	if(window.location != "http://localhost:8080/easyTuto/"){
		window.location = "/easyTuto/";
	}
	
	window.onpopstate = function(e) {
		//alert("onpop"+history.state.url+" ");
		//alert(Hash);
		if(Hash!=window.location.hash){
			updateHashPage(window.location.hash);
		}
		else if(Hash==""){
			//alert("carico homeContetn");
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
		Hash = window.location.hash;
		if(hash.substring(1,5)=="user") {
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
		} else if(hash.substring(1,5)=="page") {
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
		} else if(hash.substring(1,5)=="tuto") {
			tutoHash = hash.substring(6,hash.size);
			//alert("updateHash - tuto: "+tutoHash);
			$.ajax({
				url: 'faces/tutoDetails.xhtml', 
				type: 'post', 
				data: 'tuto_id='+tutoHash, 
				success: function(result) {
					$("#container").html(result);
				}
			});
		} else if(hash.substring(1,5)=="edit") { 
			tutoHash = hash.substring(6, hash.size);
			$.ajax({
				url: 'faces/editTuto.xhtml', 
				type: 'post', 
				data: 'tutoId='+tutoHash, 
				success: function(result) {
					$("#container").html(result);
				}
			});
		} else if (hash.substring(1,5)=="cate") {
			categoryHash = hash.substring(6, hash.size);
			$.ajax({
				url: 'faces/tutoFilterByCategory.xhtml', 
				type: 'post', 
				data: 'categoryId='+categoryHash, 
				success: function(result) {
					$("#container").html(result);
				}
			});
		} else {
			window.location = "/easyTuto/";
		}
	}
	if(Hash!=""){
		
		updateHashPage(Hash);
		
	}else{
		//alert("carico homeContetn");
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
			
			window.location = "/easyTuto/";
		}else{
			window.location.hash = "page:"+$(this).attr("id");
		}
	});
	
	
	
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