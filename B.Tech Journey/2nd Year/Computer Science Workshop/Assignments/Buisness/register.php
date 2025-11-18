<?php  
  session_start();//session starts here  
?> 

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>Registration - व्यापार</title>
    <meta content="" name="description">
    <meta content="" name="keywords">
    <link rel="shortcut icon" href="./Assets/Logo.png" type="image/x-icon">
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <div class="FormWork">
        <form action="register.php" method="post" class="FormBox">
            <p id="Regs">|| व्यापार ||</p>
            <div class="col-12">
                <input type="text" name="name" class="form-control" id="yourName" placeholder="Enter Your Name" required>
            </div>
    
            <div class="col-12">
                <select name="gender" class="form-control" required>
                    <option value="">Select Your Gender</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                </select>
            </div>
    
            <div class="col-12">
                <input type="email" name="email" class="form-control" id="yourEmail" placeholder="Enter Your Email" required>
            </div>
    
            <div class="col-12">
                <input type="text" name="number" class="form-control" id="yourNumber" placeholder="Enter Your Contact" required>
            </div>
    
            <div class="col-12">
                <input type="text" name="username" class="form-control" id="yourUsername" placeholder="Enter Username" required>
            </div>
    
            <div class="col-12">
                <input type="password" name="password" class="form-control" id="yourPassword" placeholder="Enter Password" required>
            </div>
    
            <div class="col-12">
                <button class="btn btn-primary w-100" type="submit" name="register">Create Account</button>
            </div>

            <div class="col-12">
                <p class="small mb-0">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Already Have An Account? <a href="home.php">Log In</a></p>
            </div>
        </form>
    </div>
</body>

</html>


<?php
// Connect to the database
include("./database/db_conection.php");

if (isset($_POST['register'])) {
    // Get the form data and sanitize inputs
    $user_name = trim($_POST['name']);
    $user_gender = $_POST['gender'];
    $user_email = trim($_POST['email']);
    $user_number = trim($_POST['number']);
    $user_username = trim($_POST['username']);
    $user_password = trim($_POST['password'], PASSWORD_DEFAULT);

    // Check if username already exists
    $check_username_query = "SELECT * FROM test_users WHERE user_username = ?";
    $stmt = $dbcon->prepare($check_username_query);
    $stmt->bind_param("s", $user_username);
    $stmt->execute();
    $stmt->store_result();

    if ($stmt->num_rows > 0) {
        echo "<script>alert('Username $user_username Is Already Taken. Please Try Another.')</script>";
        $stmt->close();
        exit();
    }
    $stmt->close();

    // Insert user data into the database
    $insert_user_query = "INSERT INTO test_users (user_name, user_gender, user_email, user_number, user_username, user_password) VALUES (?, ?, ?, ?, ?, ?)";
    $stmt = $dbcon->prepare($insert_user_query);
    $stmt->bind_param("ssssss", $user_name, $user_gender, $user_email, $user_number, $user_username, $user_password);

    if ($stmt->execute()) {
        echo "<script>alert('Registration Successful ! Redirecting To Login.');</script>";
        echo "<script>window.location.href = 'index.php';</script>";
    } else {
        echo "<script>alert('Error During Registration. Please Try Again.');</script>";
    }
    // Close the prepared statement
    $stmt->close();
}
?>
