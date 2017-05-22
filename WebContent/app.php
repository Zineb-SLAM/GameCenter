<?php
 $response = file_get_contents('http://localhost:8080/GameCenter/web-services/products');
 $response = json_decode($response);
  echo $response;
  


?>