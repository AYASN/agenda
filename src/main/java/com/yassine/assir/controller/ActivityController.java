package com.yassine.assir.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yassine.assir.model.Activity;
import com.yassine.assir.service.ActivityService;
import com.yassine.assir.service.impl.ActivityServiceImpl;

public class ActivityController extends HttpServlet {
   private ActivityService activityService;

   @Override
   public void init() throws ServletException {
      activityService = new ActivityServiceImpl();
   }


   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String action = req.getParameter("action") != null ? req.getParameter("action") : "";
      String toPage = req.getParameter("toPage") != null ? req.getParameter("toPage") : "";
      String idActivity = req.getParameter("id");

      // The controller decide based on the req params if it's
      // a simple redirection or it's an actual action
      if (toPage.isEmpty()) {
         doActions(req, resp, action, idActivity);
      } else {
         redirectRequest(req, resp, toPage, idActivity);
      }
   }

   private void doActions(HttpServletRequest req, HttpServletResponse resp, String action, String idActivity) throws ServletException, IOException {
      if (action.equalsIgnoreCase("remove")) {
         if (idActivity != null) {
            activityService.remove(Long.valueOf(idActivity));
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/activities");
            requestDispatcher.forward(req, resp);
         }
      }
   }

   private void redirectRequest(HttpServletRequest req, HttpServletResponse resp, String toPage, String idActivity) throws ServletException, IOException {
      if (toPage.equalsIgnoreCase("remove")) {
         if (idActivity != null) {
            Activity activity = activityService.getActivity(Long.valueOf(idActivity));
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/removeActivity.jsp");
            req.setAttribute("activity", activity);
            requestDispatcher.forward(req, resp);
         }
      } else if (toPage.equalsIgnoreCase("edit")) {
         if (idActivity != null) {
            Activity activity = activityService.getActivity(Long.valueOf(idActivity));
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/editActivity.jsp");
            req.setAttribute("activity", activity);
            requestDispatcher.forward(req, resp);
         }
      }
   }
}
