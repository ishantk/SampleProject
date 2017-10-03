<?php

// Input from Android
$id = $_POST['id'];

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

$sql = "DELETE FROM User WHERE id = $id";

$response = array();

if ($conn->query($sql) === TRUE) {
    $response['success']=1;
 	$response['message']="User Deleted Sucessfully";
}else{
 	$response['success']=0;
 	$response['message']="User Deletion Failed";
}

$conn->close();

echo json_encode($response)
?>