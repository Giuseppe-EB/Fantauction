function fine(){
	window.location.href = "/fantauction.it/auction?key=fine"
}
function skip(){

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	console.log("resposnseTEXT=", xhttp.responseText);
	    	document.getElementById("currentPlayer").innerHTML= xhttp.responseText;
			}
		};
	xhttp.open("post", "/fantauction.it/auction?key=skip", true);
	xhttp.send(); 
}
function refresh(selected){

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	console.log("resposnseTEXT=", xhttp.responseText);
	    	document.getElementById(selected).innerHTML= xhttp.responseText;
			}
		};
	xhttp.open("post", "/fantauction.it/auction?key=refresh", true);
	xhttp.send(); 
}
function acquista(id){ 
	 
	  $.ajax({
		url : 'auction',
		type : 'post',
		data : {
			crediti : $('input[name="crediti"]').val(),
			selected: $('select[name="select"]').val(),
			player : document.getElementById("currentPlayerId").innerHTML,
			key : "acquista"
		},
	success:function(){
		refresh( $('select[name="select"]').val());
		skip();
	},
	error:function(){
		alert("Il giocatore è già stato acquistato da un'altra squadra");
	}
	});
}
function syncro(){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	var element = xhttp.responseText.split(",");
	    	console.log("resposnseTEXT=", xhttp.responseText);
	    	document.getElementById(element[0]).innerHTML= element[1];
			}
		};
	xhttp.open("post", "/fantauction.it/auction?key=refreshS", true);
	xhttp.send();
	
}
