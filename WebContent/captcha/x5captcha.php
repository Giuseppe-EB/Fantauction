<?php
include("../res/x5engine.php");
$nameList = array("gne","lyt","lu8","3sd","vfw","3wx","se2","3ma","s2p","yt6");
$charList = array("U","K","J","H","M","H","M","V","T","3");
$cpt = new X5Captcha($nameList, $charList);
//Check Captcha
if ($_GET["action"] == "check")
	echo $cpt->check($_GET["code"], $_GET["ans"]);
//Show Captcha chars
else if ($_GET["action"] == "show")
	echo $cpt->show($_GET['code']);
// End of file x5captcha.php
