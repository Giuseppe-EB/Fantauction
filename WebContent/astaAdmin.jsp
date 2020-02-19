<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AstaAdmin - Prova - WEBSITE X5 DEMO VERSION </title>
		<meta charset="utf-8" />
		<!--[if IE]><meta http-equiv="ImageToolbar" content="False" /><![endif]-->
		<meta name="generator" content="Incomedia WebSite X5 Professional 14.0.6.1 - UNREGISTERED VERSION - www.websitex5.com" />
		<meta property="og:locale" content="it" />
		<meta property="og:type" content="website" />
		<meta property="og:url" content="http://eagsatea.it/astaadmin.html" />
		<meta property="og:title" content="AstaAdmin" />
		<meta property="og:site_name" content="Prova" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		
		<link rel="stylesheet" type="text/css" href="style/reset.css?14-0-6-1" media="screen,print" />
		<link rel="stylesheet" type="text/css" href="style/print.css?14-0-6-1" media="print" />
		<link rel="stylesheet" type="text/css" href="style/style.css?14-0-6-1" media="screen,print" />
		<link rel="stylesheet" type="text/css" href="style/template.css?14-0-6-1" media="screen" />
		<link rel="stylesheet" type="text/css" href="pcss/astaadmin.css?14-0-6-1-637177060098510891" media="screen,print" />
		<script type="text/javascript" src="res/jquery.js?14-0-6-1"></script>
		<script type="text/javascript" src="res/x5engine.js?14-0-6-1" data-files-version="14-0-6-1"></script>
		<script type="text/javascript">
			window.onload = function(){ checkBrowserCompatibility('Il Browser che stai utilizzando non supporta le funzionalit� richieste per visualizzare questo Sito.','Il Browser che stai utilizzando potrebbe non supportare le funzionalit� richieste per visualizzare questo Sito.','[1]Aggiorna il tuo browser[/1] oppure [2]procedi ugualmente[/2].','http://outdatedbrowser.com/'); };
			x5engine.utils.currentPagePath = 'astaadmin.html';
			x5engine.boot.push(function () { x5engine.imPageToTop.initializeButton({}); });
		</script>
	</head>
	<body>
		<div id="imPageExtContainer">
			<div id="imPageIntContainer">
				<div id="imHeaderBg"></div>
				<div id="imFooterBg"></div>
				<div id="imPage">
					<div id="imHeader">
						<h1 class="imHidden">AstaAdmin - Prova - WEBSITE X5 DEMO VERSION </h1>
						<div id="imHeaderObjects"><div id="imHeader_imMenuObject_01_wrapper" class="template-object-wrapper"><div id="imHeader_imCell_1" class="" > <div id="imHeader_imCellStyleGraphics_1"></div><div id="imHeader_imCellStyle_1" ><div id="imHeader_imMenuObject_01"><div class="hamburger-button hamburger-component"><div><div><div class="hamburger-bar"></div><div class="hamburger-bar"></div><div class="hamburger-bar"></div></div></div></div><div class="hamburger-menu-background-container hamburger-component">
	<div class="hamburger-menu-background menu-mobile menu-mobile-animated hidden">
		<div class="hamburger-menu-close-button"><span>&times;</span></div>
	</div>
</div>
<ul class="menu-mobile-animated hidden">
	<li class="imMnMnFirst imPage" data-link-paths="/index.html,/">
<div class="label-wrapper">
<div class="label-inner-wrapper">
		<a class="label" href="index.html">
Home Page		</a>
</div>
</div>
	</li><li class="imMnMnMiddle imPage" data-link-paths="/astaadmin.html">
<div class="label-wrapper">
<div class="label-inner-wrapper">
		<a class="label" href="astaadmin.html">
AstaAdmin		</a>
</div>
</div>
	</li><li class="imMnMnMiddle imPage" data-link-paths="/homeasta.html">
<div class="label-wrapper">
<div class="label-inner-wrapper">
		<a class="label" href="homeasta.html">
HomeAsta		</a>
</div>
</div>
	</li><li class="imMnMnMiddle imPage" data-link-paths="/pagina-1.html">
<div class="label-wrapper">
<div class="label-inner-wrapper">
		<a class="label" href="pagina-1.html">
Pagina 1		</a>
</div>
</div>
	</li><li class="imMnMnMiddle imPage" data-link-paths="/pagina-2.html">
<div class="label-wrapper">
<div class="label-inner-wrapper">
		<a class="label" href="pagina-2.html">
Pagina 2		</a>
</div>
</div>
	</li><li class="imMnMnLast imPage" data-link-paths="/pagina-3.html">
<div class="label-wrapper">
<div class="label-inner-wrapper">
		<a class="label" href="pagina-3.html">
Pagina 3		</a>
</div>
</div>
	</li></ul></div><script type="text/javascript">
x5engine.boot.push(function(){x5engine.initMenu('imHeader_imMenuObject_01',1000)});
$(function () {$('#imHeader_imMenuObject_01 ul li').each(function () {    var $this = $(this), timeout = 0, subtimeout = 0, width = 'none', height = 'none';        var submenu = $this.children('ul').add($this.find('.multiple-column > ul'));    $this.on('mouseenter', function () {        if($(this).parents('#imHeader_imMenuObject_01-menu-opened').length > 0) return;         clearTimeout(timeout);        clearTimeout(subtimeout);        $this.children('.multiple-column').show(0);        submenu.stop(false, false);        if (width == 'none') {             width = submenu.width();        }        if (height == 'none') {            height = submenu.height();            submenu.css({ overflow : 'hidden', height: 0});        }        setTimeout(function () {         submenu.css({ overflow : 'hidden'}).fadeIn(1).animate({ height: height }, 300, null, function() {$(this).css('overflow', 'visible'); });        }, 250);    }).on('mouseleave', function () {        if($(this).parents('#imHeader_imMenuObject_01-menu-opened').length > 0) return;         timeout = setTimeout(function () {         submenu.stop(false, false);            submenu.css('overflow', 'hidden').animate({ height: 0 }, 300, null, function() {$(this).fadeOut(0); });            subtimeout = setTimeout(function () { $this.children('.multiple-column').hide(0); }, 300);        }, 250);    });});});

</script>
</div></div></div><div id="imHeader_imObjectTitle_03_wrapper" class="template-object-wrapper"><div id="imHeader_imCell_3" class="" > <div id="imHeader_imCellStyleGraphics_3"></div><div id="imHeader_imCellStyle_3" ><div id="imHeader_imObjectTitle_03"><span id ="imHeader_imObjectTitle_03_text" >Asta del Fantacalcio</span > </div></div></div></div></div>
					</div>
					<div id="imStickyBarContainer">
						<div id="imStickyBarGraphics"></div>
						<div id="imStickyBar">
							<div id="imStickyBarObjects"><div id="imStickyBar_imObjectTitle_02_wrapper" class="template-object-wrapper"><div id="imStickyBar_imCell_2" class="" > <div id="imStickyBar_imCellStyleGraphics_2"></div><div id="imStickyBar_imCellStyle_2" ><div id="imStickyBar_imObjectTitle_02"><span id ="imStickyBar_imObjectTitle_02_text" >Title</span > </div></div></div></div><div id="imStickyBar_imMenuObject_03_wrapper" class="template-object-wrapper"><div id="imStickyBar_imCell_3" class="" > <div id="imStickyBar_imCellStyleGraphics_3"></div><div id="imStickyBar_imCellStyle_3" ><div id="imStickyBar_imMenuObject_03"><div class="hamburger-button hamburger-component"><div><div><div class="hamburger-bar"></div><div class="hamburger-bar"></div><div class="hamburger-bar"></div></div></div></div><div class="hamburger-menu-background-container hamburger-component">
	<div class="hamburger-menu-background menu-mobile menu-mobile-animated hidden">
		<div class="hamburger-menu-close-button"><span>&times;</span></div>
	</div>
</div>
<ul class="menu-mobile-animated hidden">
	<li class="imMnMnFirst imPage" data-link-paths="/index.html,/">
<div class="label-wrapper">
<div class="label-inner-wrapper">
		<a class="label" href="index.html">
Home Page		</a>
</div>
</div>
	</li><li class="imMnMnMiddle imPage" data-link-paths="/astaadmin.html">
<div class="label-wrapper">
<div class="label-inner-wrapper">
		<a class="label" href="astaadmin.html">
AstaAdmin		</a>
</div>
</div>
	</li><li class="imMnMnMiddle imPage" data-link-paths="/homeasta.html">
<div class="label-wrapper">
<div class="label-inner-wrapper">
		<a class="label" href="homeasta.html">
HomeAsta		</a>
</div>
</div>
	</li><li class="imMnMnMiddle imPage" data-link-paths="/pagina-1.html">
<div class="label-wrapper">
<div class="label-inner-wrapper">
		<a class="label" href="pagina-1.html">
Pagina 1		</a>
</div>
</div>
	</li><li class="imMnMnMiddle imPage" data-link-paths="/pagina-2.html">
<div class="label-wrapper">
<div class="label-inner-wrapper">
		<a class="label" href="pagina-2.html">
Pagina 2		</a>
</div>
</div>
	</li><li class="imMnMnLast imPage" data-link-paths="/pagina-3.html">
<div class="label-wrapper">
<div class="label-inner-wrapper">
		<a class="label" href="pagina-3.html">
Pagina 3		</a>
</div>
</div>
	</li></ul></div><script type="text/javascript">
x5engine.boot.push(function(){x5engine.initMenu('imStickyBar_imMenuObject_03',1000)});
$(function () {$('#imStickyBar_imMenuObject_03 ul li').each(function () {    var $this = $(this), timeout = 0, subtimeout = 0, width = 'none', height = 'none';        var submenu = $this.children('ul').add($this.find('.multiple-column > ul'));    $this.on('mouseenter', function () {        if($(this).parents('#imStickyBar_imMenuObject_03-menu-opened').length > 0) return;         clearTimeout(timeout);        clearTimeout(subtimeout);        $this.children('.multiple-column').show(0);        submenu.stop(false, false);        if (width == 'none') {             width = submenu.width();        }        if (height == 'none') {            height = submenu.height();            submenu.css({ overflow : 'hidden', height: 0});        }        setTimeout(function () {         submenu.css({ overflow : 'hidden'}).fadeIn(1).animate({ height: height }, 300, null, function() {$(this).css('overflow', 'visible'); });        }, 250);    }).on('mouseleave', function () {        if($(this).parents('#imStickyBar_imMenuObject_03-menu-opened').length > 0) return;         timeout = setTimeout(function () {         submenu.stop(false, false);            submenu.css('overflow', 'hidden').animate({ height: 0 }, 300, null, function() {$(this).fadeOut(0); });            subtimeout = setTimeout(function () { $this.children('.multiple-column').hide(0); }, 300);        }, 250);    });});});

</script>
</div></div></div></div>
						</div>
					</div>
					<a class="imHidden" href="#imGoToCont" title="Salta il menu di navigazione">Vai ai contenuti</a>
					<div id="imSideBarContainer">
						<div id="imSideBarGraphics"></div>
						<div id="imSideBar">
							<div id="imSideBarObjects"><div id="imSideBar_imObjectImage_01_wrapper" class="template-object-wrapper"><div id="imSideBar_imCell_1" class="" > <div id="imSideBar_imCellStyleGraphics_1"></div><div id="imSideBar_imCellStyle_1" ><img id="imSideBar_imObjectImage_01" src="images/empty-GT_imagea-1-.png" title="" alt="" /></div></div></div></div>
						</div>
					</div>
					<div id="imContentContainer">
						<div id="imContentGraphics"></div>
						<div id="imContent">
							<a id="imGoToCont"></a>
				<div id="imPageRow_1" class="imPageRow">
				
				<div id="imPageRowContent_1" class="imContentDataContainer">
				<div id="imGroup_1" class="imHGroup">
				<div id="imCell_1" class="" > <div id="imCellStyleGraphics_1"></div><div id="imCellStyle_1"  data-responsive-sequence-number="1"><div id="imHTMLObject_7_01" class="imHTMLObject" style="height: 350px; overflow: auto; text-align: center;">
				<table class="table7" style="width:100%">				
				 <tr>
				  <th></th>
				  	<th>Nome</th>
				  	<th>Squadra</th>
				  </tr>
				<c:forEach var="giocatori" items="${giocatori}">
					 <tr>
				 		<td>${giocatori.getRuolo()}</td>
				 		<td>${giocatori.getNome()} ${giocatori.getCognome()}</td>
				 		<td>${giocatori.getSquadra()}</td>
				 	</tr>
				</c:forEach> 
				</table></div></div></div><div id="imGroup_2" class="imVGroup">
				<div id="imGroup_3" class="imHGroup">
				<div id="imCell_4" class="" > <div id="imCellStyleGraphics_4"></div><div id="imCellStyle_4"  data-responsive-sequence-number="2"><div id="imHTMLObject_7_04" class="imHTMLObject" style="height: 350px; overflow: auto; text-align: center;">
				<table class="table7" style="width:100%">
				 <tr>
				  <th>Squadra</th>
				  <th>Crediti</th>
				  </tr>
				<c:forEach var="squadre" items="${squadre}">
				 	<tr>
				 		<td> ${squadre.getNome()}</td>
				 		<td> ${squadre.getCrediti()}</td>
				 	</tr>
				</c:forEach>	 
				</table>
				</div></div></div>
				<div id="imCell_5" class="" > 
					<div id="imCellStyleGraphics_5"></div>
						<div id="imCellStyle_5"  data-responsive-sequence-number="3">
							<img id="imObjectImage_7_05" src="images/logo.png.jpg" title="" alt="" />
							<p id="currentPlayer">${giocatori.get(currentPlayer).getNome()}</p>
						</div>
				</div>
				</div>
				<div id="imCell_3" class="" > 
					<div id="imCellStyleGraphics_3">
					</div>
					<div id="imCellStyle_3"  data-responsive-sequence-number="4">
						<div id="imHTMLObject_7_03" class="imHTMLObject" style="height: 350px; overflow: auto; text-align: center;">
							<input type="text" class="bho" value="Crediti">
						</div>
					</div>
				</div>
				<div id="imGroup_4" class="imHGroup">
					<div id="imCell_2" class="" >
						 <div id="imCellStyleGraphics_2">
						 </div>
						 	<div id="imCellStyle_2"  data-responsive-sequence-number="5">
						 		<div id="imHTMLObject_7_02" class="imHTMLObject" style="height: 200px; overflow: auto; text-align: center;">
						 			<a href="#" onclick="skip()" class="myButton">Skip</a>
						 		</div>
						 	</div>
					</div>
					<div id="imCell_6" class="" > 
						<div id="imCellStyleGraphics_6">
						</div>
						<div id="imCellStyle_6"  data-responsive-sequence-number="6">
							<div id="imHTMLObject_7_06" class="imHTMLObject" style="height: 350px; overflow: auto; text-align: center;">
								<a href="#" class="acquista">Acquista</a>
							</div>
						</div>
					</div>
				</div>
				</div>
				</div></div>
				</div>
				
							<div class="imClear"></div>
						</div>
					</div>
					<div id="imFooter">
						<div id="imFooterObjects"></div>
					</div>
				</div>
				<span class="imHidden"><a href="#imGoToCont" title="Rileggi i contenuti della pagina">Torna ai contenuti</a></span>
			</div>
		</div>
		
		<noscript class="imNoScript"><div class="alert alert-red">Per poter utilizzare questo sito � necessario attivare JavaScript.</div></noscript>
	</body>
<script>
function skip(){

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	console.log("resposnseTEXT=", xhttp.responseText);
	    	document.getElementById("currentPlayer").innerHTML= xhttp.responseText;
			}
		};
	xhttp.open("post", "/Prova/Servlet?key=skip", true);
	xhttp.send(); 
}
</script>	
</html>