<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FDM - Login</title>

</head>

<link rel="stylesheet" href="css/login.css" type="text/css">

<div class="sidenav">
         <div class="login-main-text" style="text-align:center">
            <h2>Accedi<br></h2>
            
         </div>
      </div>
      <div class="main">
         <div class="col-md-3 col-sm-5">
            <div class="login-form">
               <form name="form" action="home" method="post" onsubmit="return validate()">
                  <div class="form-group">
                     <label>Username</label>
                     <input type="text" class="form-control" placeholder="Username">
                  </div>
                  <div class="form-group">
                     <label>Password</label>
                     <input type="password" class="form-control" placeholder="Password">
                  </div>
                  <button type="submit" class="btn btn-black">Login</button>
               </form>
            </div>
         </div>
      </div>