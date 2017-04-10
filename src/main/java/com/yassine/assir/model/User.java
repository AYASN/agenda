package com.yassine.assir.model;

import java.util.List;

public class User {
   private String firstname;
   private String lastname;
   private String login;
   private String password;
   private String email;
   private List<Activity> activities;

   public String getFirstname() {
      return firstname;
   }

   public void setFirstname(String firstname) {
      this.firstname = firstname;
   }

   public String getLastname() {
      return lastname;
   }

   public void setLastname(String lastname) {
      this.lastname = lastname;
   }

   public String getLogin() {
      return login;
   }

   public void setLogin(String login) {
      this.login = login;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public List<Activity> getActivities() {
      return activities;
   }

   public void setActivities(List<Activity> activities) {
      this.activities = activities;
   }
}
