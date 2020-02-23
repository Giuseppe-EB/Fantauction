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