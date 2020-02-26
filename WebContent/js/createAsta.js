function selezione(id){ 				    	  
	$.ajax({
		url : 'auction',
		type : 'post',
		data : {
			id : id,
			key : "seleziona"
		},
		success:function(){
			document.getElementById(id).innerHTML= "Selezionata";
			window.location.href = "/fantauction.it/auction?key=seleziona"
		},
		error:function(){
			alert("Errore");
		}
	});
}
function enter(){
	$.ajax({
		url : 'auction',
		type : 'post',
		data : {
			name : $('input[name="name_enter"]').val(),
			password: $('input[name="password_enter"]').val(),
			key : "partecipa"
		},
	success:function(){
		window.location.href="/fantauction.it/auction?key=partecipa";
	},
	error:function(){
		alert("Password errata oppure non esiste un'asta con questo nome");
	}
	});
}