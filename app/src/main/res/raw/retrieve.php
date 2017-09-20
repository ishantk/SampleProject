<?php

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

$sql = "SELECT * FROM User";

$response = array();

$result = $conn->query($sql);

if(mysqli_num_rows($result)>0){

	$response['users'] = array();
	while($row=mysqli_fetch_row($result)){
		array_push($response['users'], $row);
	}

	$response['success']=1;
 	$response['message']="Records Retrieved sucessfully";
 	
}else{
 	$response['success']=0;
 	$response['message']="No Records Found";
 }

 echo json_encode($response);

?>