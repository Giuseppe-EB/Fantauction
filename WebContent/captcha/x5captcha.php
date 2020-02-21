<?php
include("../res/x5engine.php");
$nameList = array("js7","cuf","f7z","g4w","c7m","67f","fyx","nf4","arn","63a");
$charList = array("K","F","P","G","R","8","6","P","5","X");
$cpt = new X5Captcha($nameList, $charList);
//Check Captcha
if ($_GET["action"] == "check")
	echo $cpt->check($_GET["code"], $_GET["ans"]);
//Show Captcha chars
else if ($_GET["action"] == "show")
	echo $cpt->show($_GET['code']);
// End of file x5captcha.php
