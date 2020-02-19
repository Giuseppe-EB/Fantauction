<?php
include("../res/x5engine.php");
$nameList = array("aku","tv4","4xh","55n","tyu","ddc","6g7","ken","l2u","6uj");
$charList = array("J","W","X","Z","8","G","A","U","G","Z");
$cpt = new X5Captcha($nameList, $charList);
//Check Captcha
if ($_GET["action"] == "check")
	echo $cpt->check($_GET["code"], $_GET["ans"]);
//Show Captcha chars
else if ($_GET["action"] == "show")
	echo $cpt->show($_GET['code']);
// End of file x5captcha.php
