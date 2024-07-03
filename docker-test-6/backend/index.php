<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
  <?php
    echo "<h1>Server is running at port " . $_ENV["PORT"] . "</h1>";


  function connect()
  {
      $host = $_ENV["DB_HOST"] . ":" . $_ENV["DB_PORT"];
      $user = $_ENV["DB_USER"];
      $password = $_ENV["DB_PASSWORD"];
      $dbname = $_ENV["DB_NAME"];

      $conn = mysqli_connect($host, $user, $password, $dbname);

      if($conn->connect_error) {
          die("Conexão falhou: " . $conn->connect_error);
      }

      echo "Conexão bem sucedida";

      $conn->close();
  }

  connect();
  ?>
  
</body>
</html>