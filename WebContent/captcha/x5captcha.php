<?php
include("../res/x5engine.php");
$nameList = array("m3r","r8z","rap","5fw","ad2","dm2","7zf","tu5","pd6","pel");
$charList = array("6","D","X","T","W","C","3","2","L","V");
$cpt = new X5Captcha($nameList, $charList);
//Check Captcha
if ($_GET["action"] == "check")
	echo $cpt->check($_GET["code"], $_GET["ans"]);
//Show Captcha chars
else if ($_GET["action"] == "show")
	echo $cpt->show($_GET['code']);
// End of file x5captcha.php
