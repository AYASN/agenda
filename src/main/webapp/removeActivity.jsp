<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
   <title>Activities</title>
   <link rel="stylesheet" href="styles/css/bootstrap.min.css">
</head>
<body>
<%
   if (session != null) {
      if (session.getAttribute("login") == null) {
         response.sendRedirect("index.jsp");
      }
   }
%>


<div class="container">
   <div class="page-header">
      <h1>Application Web Java EE <small> - Gestion Agenda</small></h1>
   </div>
   <div class="row">
      <div class="panel panel-primary">
         <div class="panel-heading">Supprimer une activité :</div>
         <div class="panel-body">
            <div class="form-group">
               <label for="intitulé">Intitulé :</label>
               <input type="text" class="form-control" name="title" id="intitulé" placeholder="${activity.title}" readonly>
            </div>
            <div class="form-group">
               <label for="description">Description :</label>
               <input type="text" class="form-control" name="description" id="description" placeholder="${activity.description}"
                      readonly>
            </div>
            <div class="form-group input-append date form_datetime">
               <label for="starteDate">Date de Début :</label>
               <input type="text" class="form-control" name="starteDate" id="starteDate" placeholder="${activity.startDate}"
                      readonly>
            </div>
            <div class="form-group input-append date form_datetime">
               <label for="endDate">Date de Fin :</label>
               <input type="text" class="form-control" name="endDate" id="endDate" placeholder="${activity.endDate}"
                      readonly>
            </div>

            <%-- Boutons--%>
            <a href="activity?action=remove&id=<%= request.getParameter("id") %>"
               class="btn btn-success pull-right" style=" margin-left: 10px;">Valider</a>
            <a href="activities" class="btn btn-danger pull-right">Annuler</a>
         </div>
      </div>
   </div>
   <div class="alert alert-danger" role="alert"> La validation de cette action provoquera la suppresion de cette
      activité !
   </div>
</div>
</body>
</html>