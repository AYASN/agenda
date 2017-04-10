package com.yassine.assir.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yassine.assir.model.Agenda;
import com.yassine.assir.service.ActivityService;
import com.yassine.assir.service.AgendaService;
import com.yassine.assir.service.impl.ActivityServiceImpl;
import com.yassine.assir.service.impl.AgendaServiceImpl;

public class AgendaController extends HttpServlet {

   private AgendaService agendaService;
   private ActivityService activityService;

   public void init() throws ServletException {
      agendaService = new AgendaServiceImpl();
      activityService = new ActivityServiceImpl();
   }

   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html");
      Agenda agenda = agendaService.createAgenda();

      agenda.setActivities(activityService.populateActivitiesByAgendaId((long) 1));

      RequestDispatcher requestDispatcher = req.getRequestDispatcher("/agenda.jsp");
      req.setAttribute("agenda", agenda);
      requestDispatcher.forward(req, resp);
   }
}
