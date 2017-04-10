package com.yassine.assir.controller;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      ServletContext servletContext = req.getServletContext();
      String contextPath = servletContext.getContextPath();

      String login = req.getParameter("login");
      String password = req.getParameter("password");

      if (login.equals("admin") && password.equals("admin")) {
         HttpSession session = req.getSession(true);
         session.setAttribute("login", login);
         session.setMaxInactiveInterval(60);
         resp.sendRedirect(contextPath + "/activities");
      } else {
         resp.sendRedirect(contextPath + "/index.jsp");
      }
   }
}
