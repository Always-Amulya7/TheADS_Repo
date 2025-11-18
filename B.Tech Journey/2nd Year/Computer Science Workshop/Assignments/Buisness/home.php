<?php  
session_start();
include("./database/db_conection.php"); // Correct the path if necessary

if (!isset($_SESSION['user_username'])) {    
    header("Location: index.php");
    exit(); // Stop further script execution after redirect
}

$user_username = $_SESSION['user_username'];

// Prepare the query to prevent SQL injection
$view_users_query = "SELECT * FROM test_users WHERE user_username=?";
$stmt = $dbcon->prepare($view_users_query);
$stmt->bind_param("s", $user_username);
$stmt->execute();
$result = $stmt->get_result();

if ($row = $result->fetch_assoc()) { // Fetch the user data if it exists
    $user_name = $row['user_name']; // Replace with actual column name
    $user_gender = $row['user_gender']; // Replace with actual column name
} else {
    echo "User Not Found."; // Handle cases where no user is found
}
$stmt->close();
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>व्यापार</title>
    <link rel="shortcut icon" href="./Assets/Logo.png" type="image/x-icon">
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <nav id="NavBar">
        <img class="Image" src="./Assets/Logo.png" alt="Logo">
        <ul id="NavHold">
            <li><a href="home.php">Home</a></li>
            <li><a href="register.php">Register</a></li>
            <li><a href="logout.php">Logout</a></li>
        </ul>
        <a id="Storage" class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown" style="display:flex;align-items:center;font-size: 18px;">
            <?php
            if ($user_gender == 'male')
            {
            ?>
            <img src="./assets/Male.png" alt="Profile" class="rounded-circle ImageWork" height="30vh">
            <?php }
            else
            {
            ?>
            <img src="./assets/Female.png" alt="Profile" class="rounded-circle ImageWork" height="30vh">
            <?php }
            ?>
            <span class="d-none d-md-block ps-2">&nbsp;&nbsp;<?php echo $user_name; ?></span>
            </a>
    </nav>
    <div class="Container">
        <div class="Items">
            <div class="Item"><img src="./Assets/Product.png" id="Product" alt=""><label for="Product">Product - 1</label></div>
            <div class="Item"><img src="./Assets/Product.png" id="Product" alt=""><label for="Product">Product - 2</label></div>
            <div class="Item"><img src="./Assets/Product.png" id="Product" alt=""><label for="Product">Product - 3</label></div>
            <div class="Item"><img src="./Assets/Product.png" id="Product" alt=""><label for="Product">Product - 4</label></div>
            <div class="Item"><img src="./Assets/Product.png" id="Product" alt=""><label for="Product">Product - 5</label></div>
            <div class="Item"><img src="./Assets/Product.png" id="Product" alt=""><label for="Product">Product - 6</label></div>
        </div>
        <div class="Items">
            <div class="Item"><img src="./Assets/Product.png" id="Product" alt=""><label for="Product">Product - 7</label></div>
            <div class="Item"><img src="./Assets/Product.png" id="Product" alt=""><label for="Product">Product - 8</label></div>
            <div class="Item"><img src="./Assets/Product.png" id="Product" alt=""><label for="Product">Product - 9</label></div>
            <div class="Item"><img src="./Assets/Product.png" id="Product" alt=""><label for="Product">Product - 10</label></div>
            <div class="Item"><img src="./Assets/Product.png" id="Product" alt=""><label for="Product">Product - 11</label></div>
            <div class="Item"><img src="./Assets/Product.png" id="Product" alt=""><label for="Product">Product - 12</label></div>
        </div>
    </div>
</body>
</html>

<?php  
include("./database/db_conection.php"); // Check if the path is correct

if (isset($_POST['login'])) {  
    $user_username = trim($_POST['username']);  
    $user_password = trim($_POST['password']);  

    // Prepare the query
    $check_user = "SELECT * FROM test_users WHERE user_username = ?";
    $stmt = $dbcon->prepare($check_user);
    $stmt->bind_param("s", $user_username);
    $stmt->execute();
    $result = $stmt->get_result();

    if ($result->num_rows > 0) {
        $user = $result->fetch_assoc();
        // Verify the password with the hashed password
        if (password_verify($user_name, $user_password)) {
            $_SESSION['user_username'] = $user_username;
            echo "<script>window.open('/home.php','_self')</script>"; 
        } else {
            echo "<script>alert('Username Or Password Is Incorrect!');</script>";
            echo "<script>window.open('/index.php','_self');</script>";
        }
    } else {
        echo "<script>alert('Username Or Password Is Incorrect!');</script>";
        echo "<script>window.open('index.php','_self');</script>";
    }
    $stmt->close();
}
?>