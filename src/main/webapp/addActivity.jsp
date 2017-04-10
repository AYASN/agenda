<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <title>Ajouter Activité</title>
   <link rel="stylesheet" href="styles/css/bootstrap.min.css">
   <link rel="stylesheet" type="text/css" href="styles/css/jquery.datetimepicker.css">
   <script src="js/jquery.js"></script>
   <script src="styles/build/jquery.datetimepicker.full.min.js"></script>
</head>

<body>
<%
if (session != null) {
if (session.getAttribute("login") == null) {
response.sendRedirect("index.jsp");
}
}
%>


<div class="page-header">
   <h1>Application Web Java EE <small> - Gestion Agenda</small></h1>
</div>
<div class="container">
   <div class="panel panel-primary">
      <div class="panel-heading">Ajouter une nouvelle activité :</div>
      <div class="panel-body">
         <form action="addActivity" method="post">

            <div class="form-group">
               <label for="intitulé">Intitulé :</label>
               <input type="text" class="form-control" name="title" id="intitulé" placeholder="intitulé">
            </div>
            <div class="form-group">
               <label for="description">Description :</label>
               <input type="text" class="form-control" name="description" id="description" placeholder="Description">
            </div>
            <div class="form-group input-append date form_datetime">
               <label for="startDate">Date de Début :</label>
               <input type="text" class="form-control" name="startDate" id="startDate" placeholder="Date de Début">
            </div>
            <div class="form-group input-append date form_datetime">
               <label for="endDate">Date de Fin :</label>
               <input type="text" class="form-control" name="endDate" id="endDate" placeholder="Date de Fin">
            </div>
            <button type="submit" class="btn btn-success pull-right" style="
    margin-left: 10px;">Valider
            </button>
            <a href="activities" class="btn btn-danger pull-right">Annuler</a>
         </form>

      </div>
   </div>
</div>
</body>
</html>

<script type="text/javascript">

   $('#startDate').datetimepicker();
   $('#endDate').datetimepicker();

</script>