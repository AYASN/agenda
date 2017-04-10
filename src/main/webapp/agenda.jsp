<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
   <title>Activities</title>
   <link rel="stylesheet" href="styles/css/bootstrap.min.css">
</head>
<body>

<%-- Check if you're logged in --%>
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
      <div class="panel-heading">La liste des activités : ${agenda.title}</div>
      <div class="panel-body">
         <table class="table table-striped">
            <tr>
               <th>#</th>
               <th>Intitulé</th>
               <th>Description</th>
               <th>Date Début</th>
               <th>Date Fin</th>
               <th>Editer</th>
               <th>Supprimer</th>
            </tr>
            <c:forEach items="${agenda.activities}" var="activity">
               <tr>
                  <th scope="row">${activity.id}</th>
                  <td>${activity.title}</td>
                  <td>${activity.description}</td>
                  <td>${activity.startDate}</td>
                  <td>${activity.endDate}</td>
                  <td>
                     <a href="activity?id=${activity.id}&action=edit&toPage=edit" class="btn btn-primary btn-sm">
                        <span class="glyphicon glyphicon-pencil"></span>
                     </a>
                  </td>
                  <td>
                     <a href="activity?id=${activity.id}&action=remove&toPage=remove" class="btn btn-danger btn-sm">
                        <span class="glyphicon glyphicon-trash"></span>
                     </a>
                  </td>
               </tr>
            </c:forEach>
         </table>
         <a href="addActivity.jsp" class="btn btn-success pull-right">Ajouter</a>
      </div>
   </div>
</div>
</body>
</html>