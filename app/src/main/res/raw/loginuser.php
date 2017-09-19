<?php

$email = 'john@example.com';//;$_POST['email'];
$pass = 'kishant_testdb';//$_POST['password'];

$servername = "localhost";
$username = "kishant_testdb";
$password = "kishant_testdb";
$dbname = "kishant_testdb";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "SELECT * FROM User WHERE email = '$email' and password = '$pass'";

$response = array();

$result = $conn->query($sql);

if(mysqli_num_rows($result)>0){

 	$response['success']=1;
 	$response['message']="Login Success";
 }else{
 	$response['success']=0;
 	$response['message']="Login Failure";
 }

 echo json_encode($response);

?>