<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type=”text/javascript” src=”http://www.google.com/jsapi?key=ABQIAAAAqJTkrAjlGEQ5_cEfzzAJgRTQX3UUxEGSqOGjz60gOBbhvyrQnBRqzWIrzxDjqGSAC-EoQLEWgDn0mA”></script>
<!DOCTYPE html><!-- HTML5 -->
<html prefix="og: http://ogp.me/ns#" lang="it-IT" dir="ltr">
<head>
<title>HomeAsta - Prova</title>
		<meta charset="utf-8" />
		<!--[if IE]><meta http-equiv="ImageToolbar" content="False" /><![endif]-->
		<meta name="generator" content="Incomedia WebSite X5 Professional 14.0.6.1 - www.websitex5.com" />
		<meta property="og:locale" content="it" />
		<meta property="og:type" content="website" />
		<meta property="og:url" content="http://eagsatea.it/homeasta.html" />
		<meta property="og:title" content="HomeAsta" />
		<meta property="og:site_name" content="Prova" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		
		<link rel="stylesheet" type="text/css" href="style/reset.css?14-0-6-1" media="screen,print" />
		<link rel="stylesheet" type="text/css" href="style/print.css?14-0-6-1" media="print" />
		<link rel="stylesheet" type="text/css" href="style/style.css?14-0-6-1" media="screen,print" />
		<link rel="stylesheet" type="text/css" href="style/template.css?14-0-6-1" media="screen" />
		<link rel="stylesheet" type="text/css" href="pcss/homeasta.css?14-0-6-1-637176442522103386" media="screen,print" />
		<script type="text/javascript" src="res/jquery.js?14-0-6-1"></script>
		<script type="text/javascript" src="res/x5engine.js?14-0-6-1" data-files-version="14-0-6-1"></script>
		<script type="text/javascript">
			window.onload = function(){ checkBrowserCompatibility('Il Browser che stai utilizzando non supporta le funzionalità richieste per visualizzare questo Sito.','Il Browser che stai utilizzando potrebbe non supportare le funzionalità richieste per visualizzare questo Sito.','[1]Aggiorna il tuo browser[/1] oppure [2]procedi ugualmente[/2].','http://outdatedbrowser.com/'); };
			x5engine.utils.currentPagePath = 'homeasta.html';
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
						<h1 class="imHidden">HomeAsta - Prova</h1>
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
					 LA TUA SQUADRA E': ${squadra.getNome()}
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
				<div id="imGroup_2" class="imVGroup">
				<div id="imCell_2" class="" > <div id="imCellStyleGraphics_2"></div><div id="imCellStyle_2"  data-responsive-sequence-number="1"><div id="imHTMLObject_6_02" class="imHTMLObject" style="height: 165px; overflow: auto; text-align: center;"><table class="table7" style="width:100%">
				 <tr>
				  <th></th>
				  <th>Nome</th>
				  <th>Squadra</th>
				  </tr>
				 <tr>
				  <td class="round-top">ATT</td>
				  <td>Cristiano Ronaldo</td>
				  <td>Juventus</td>
				 </tr>
				<tr>
				  <td>ATT</td>
				  <td>Joao Pedro</td>
				  <td>Cagliari</td>
				</tr>
				<tr>
				  <td>ATT</td>
				  <td>Ciccio Caputo</td>
				  <td>Sassuolo</td>
				
				</tr>
				</table>
				</div></div></div><div id="imCell_3" class="" > <div id="imCellStyleGraphics_3"></div><div id="imCellStyle_3"  data-responsive-sequence-number="2"><div id="imTableObject_6_03">
					<div class="text-tab-content"  id="imTableObject_6_03_tab0" style="">
						<div class="text-inner">
							<table data-minrequestedwidth="257" data-computedwidth="257" style="width: 257px;">
								<tbody>
								<c:forEach var="squadre" items="${squadre}">
									<tr>
										<td style="text-align: center; width: 249px; height: 60px; margin-top: 0px; margin-left: 0px; background-color: rgb(255, 255, 255);" class="imVc">
										 ${squadre.getNome()} <p id="${squadre.getId()}"> </p>
										</td>
									</tr>
								</c:forEach>	
								</tbody>
							</table>
						</div>
					</div>
				
				</div>
				</div></div>
				</div><div id="imCell_4" class="" > <div id="imCellStyleGraphics_4"></div><div id="imCellStyle_4"  data-responsive-sequence-number="3"><div id="imHTMLObject_6_04" class="imHTMLObject" style="height: 350px; overflow: auto; text-align: center;"><script type=”text/javascript” src=”http://www.google.com/jsapi?key=ABQIAAAAqJTkrAjlGEQ5_cEfzzAJgRTQX3UUxEGSqOGjz60gOBbhvyrQnBRqzWIrzxDjqGSAC-EoQLEWgDn0mA”></script>
				<script src="http://feedroll.com/rssviewer/feed2js.php?src=https%3A%2F%2Frss.fantacalcio.it%2F&chan=y&date=y&utf=y&pc=y&html=a"  charset="UTF-8" type="text/javascript"></script>
				<noscript>
				<a href="http://feedroll.com/rssviewer/feed2js.php?src=https%3A%2F%2Frss.fantacalcio.it%2F&chan=y&date=y&utf=y&pc=y&html=y">View RSS feed</a>
				</noscript>
				
				</div></div></div>
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
	
		<noscript class="imNoScript"><div class="alert alert-red">Per poter utilizzare questo sito è necessario attivare JavaScript.</div></noscript>
	</body>
	<script>
		var clock = setInterval(function(){
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 200) {
			    	console.log("resposnseTEXT=", xhttp.responseText);
			    	var connected = xhttp.responseText.split(",");
			    	console.log(connected.length);
			    	for(var i=0; i<connected.length;i++){
						console.log(connected[i]);
					}
			    	connected.pop();
			    	connected.shift();
					if(connected.length=="${squadre.size()}"){
						window.location.href = "/Prova/Servlet?key=check"
					}			
					for(var i=0; i<connected.length; i++){
							console.log(connected[i]);
							document.getElementById(connected[i]).innerHTML = "Connesso";	
					}
				}		
			};
			xhttp.open("post", "/Prova/Servlet?key=check", true);
			xhttp.send(); 
			
		}, 3000);
	</script>
</html>