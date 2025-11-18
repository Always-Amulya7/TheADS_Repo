<?php  
  session_start();//session starts here  
?> 

<!DOCTYPE html>
<html lang="en">

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>Login</title>
    <meta content="" name="description">
    <meta content="" name="keywords">
    <link rel="shortcut icon" href="./Assets/Logo.png" type="image/x-icon">
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <div class="LoginPage">
        <form class="Last" action="index.php" method="post">
            <p class="ContentWork">Login Page</p>
            <div class="col-12">
                <input type="text" name="username" class="form-control" id="yourUsername" placeholder="Enter Your UserName" required>
            </div>

            <div class="col-12">
                <input type="password" name="password" class="form-control" id="yourPassword" placeholder="Enter Your PassWord" required>
            </div>

            <div class="col-12">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="remember" value="true" id="rememberMe">
                    <label class="Sol" for="form-check-input">Remember Me</label>
                </div>
            </div>
            <div class="col-12">
                <button class="btn btn-primary w-100" type="submit" name="login">Login</button>
            </div>
            <div class="col-12">
                <p class="small mb-0">Don't Have Account? <a href="register.php">Create An Account</a></p>
            </div>
        </form>
    </div>
</body>

</html>

<?php  
      
    include("./database/db_conection.php");  
      
    if(isset($_POST['login']))  
    {  
        $user_username=$_POST['username'];  
        $user_password=$_POST['password'];  
      
        $check_user="select * from test_users WHERE user_username='$user_username' AND user_password='$user_password'";  
      
        $run=mysqli_query($dbcon,$check_user);  
      
        if(mysqli_num_rows($run))  
        {  
            echo "<script>window.open('home.php','_self')</script>";  
      
            $_SESSION['user_username']=$user_username;//here session is used and value of $user_email store in $_SESSION.  
      
        }  
        else  
        {  
          echo "<script>alert('Registration Number Or Password Is Incorrect!')</script>";  
          echo "<script>window.open('index.php','_self')</script>"; 
        }  
    }  
?> 