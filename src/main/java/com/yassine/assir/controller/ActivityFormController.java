package com.yassine.assir.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yassine.assir.model.Activity;
import com.yassine.assir.service.ActivityService;
import com.yassine.assir.service.impl.ActivityServiceImpl;

public class ActivityFormController extends HttpServlet {
   private ActivityService activityService;

   @Override
   public void init() throws ServletException {
      activityService = new ActivityServiceImpl();
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      ServletContext servletContext = req.getServletContext();
      String contextPath = servletContext.getContextPath();
      String actionType = (String) req.getParameter("actionType") == null ? "" : (String) req.getParameter("actionType");
      String id = req.getParameter("id");
      String title = req.getParameter("title");
      String description = req.getParameter("description");
      Date startDate = null;
      Date endDate = null;
      String datePattern = "yyyy/mm/dd HH:mm";
      try {
         startDate = new SimpleDateFormat(datePattern).parse(req.getParameter("startDate"));
         endDate = new SimpleDateFormat(datePattern).parse(req.getParameter("endDate"));
      } catch (ParseException e) {
         // Log stuff
         System.out.println("Date parsing failed !");
      }

      if (actionType.equalsIgnoreCase("edit")) {
         activityService.edit(newActivity(id, title, description, startDate, endDate));
      } else {
         activityService.create(newActivity(title, description, startDate, endDate));
      }
      resp.sendRedirect(contextPath + "/activities");
   }

   private Activity newActivity(String id, String title, String description, Date startDate, Date endDate) {
      Activity activity = newActivity(title, description, startDate, endDate);
      activity.setId(Long.valueOf(id));
      return activity;
   }

   private Activity newActivity(String title, String description, Date startDate, Date endDate) {
      Activity activity = new Activity();
      activity.setTitle(title);
      activity.setDescription(description);
      activity.setStartDate(startDate);
      activity.setEndDate(endDate);
      return activity;
   }
}