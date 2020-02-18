<?php
include("../res/x5engine.php");
$nameList = array("pd6","yfj","rax","xf6","74z","u88","r7t","zzj","xpn","z6c");
$charList = array("U","5","5","8","6","R","5","H","M","W");
$cpt = new X5Captcha($nameList, $charList);
//Check Captcha
if ($_GET["action"] == "check")
	echo $cpt->check($_GET["code"], $_GET["ans"]);
//Show Captcha chars
else if ($_GET["action"] == "show")
	echo $cpt->show($_GET['code']);
// End of file x5captcha.php
