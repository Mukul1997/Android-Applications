<?php

$user = filter_input(INPUT_POST,"username");
$pass = filter_input(INPUT_POST,"password");

$mysqli = new mysqli("localhost","root","","tinderer");
$query = "SELECT * FROM member WHERE user = '$user' AND pass = '$pass'";

$result = mysqli_query($mysqli,$query);
if($data = mysqli_fetch_array($result)) {
  echo "1";
}

?>
