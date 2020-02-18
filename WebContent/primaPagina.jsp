<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

  
</head>

<body>

  <button onclick="tutti()" > SUCA</button>
       

<script>
function tutti(){
	 /*$.ajax({
			url : 'Servlet',
			type : 'get',
			data : {
			action : "tutti"
			},
		success:function(){
			 alert("andata");
			 window.location.href = "/Prova/Servlet";
		},
		error:function(){
			alert("Errore");
		}
		});*/
		alert("1");
	    var reader = new FileReader();
	    console.log("1");
	    reader.readAsDataURL("view-source:https://play.trxradio.it");
	      var dataURL = reader.result;
	      output.src = dataURL;
	      alert("2");
	    alert(output)
	  }	
</script>
 <script>
      var openFile = function(event) {
    	  console.log(event.target);
        var input = event.target;

        var reader = new FileReader();
        reader.onload = function(){
          var text = reader.result;
          var node = document.getElementById('output');
          node.innerText = text;
          console.log(reader.result.substring(0, 200));
        };
        reader.readAsText(input.files[0]);
      };
    </script>
    <input type='file' accept='text/plain' onchange='openFile(event)'><br>
    <div id='output'>
    </div></body>	
</html>