<?php

// Input from Android
$name = $_POST['name'];
$email = $_POST['email'];
$password = $_POST['password'];

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

$sql = "INSERT INTO User VALUES (null, '$name','$email','$password')";

$response = array();

if ($conn->query($sql) === TRUE) {
    $response['success']=1;
 	$response['message']="User Registered Sucessfully";
}else{
 	$response['success']=0;
 	$response['message']="User Registration Failed";
}

$conn->close();

echo json_encode($response)
?>