<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <title>Accueil Agenda</title>
   <link rel="stylesheet" href="styles/css/bootstrap.min.css"/>
</head>
<body>

<div class="container">
   <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
      <div class="panel panel-info">
         <div class="panel-heading">
            <div class="panel-title">Login</div>
         </div>
      </div>

      <div style="padding-top:30px" class="panel-body">

         <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

         <form action="login" class="form-horizontal" method="post">

            <div style="margin-bottom: 25px" class="input-group">
               <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
               <input type="text" class="form-control" name="login" placeholder="Login">
            </div>

            <div style="margin-bottom: 25px" class="input-group">
               <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
               <input type="password" class="form-control" name="password"
                      placeholder="Mot de Passe">
            </div>

            <div style="margin-top:10px" class="form-group">
               <div class="col-sm-12 controls">
                  <button type="submit" class="btn btn-success pull-right">Valider</button>
               </div>
            </div>
         </form>


      </div>
   </div>
</div>
</div>
</body>
</html>