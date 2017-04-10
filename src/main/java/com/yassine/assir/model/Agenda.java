package com.yassine.assir.model;

import java.util.List;

public class Agenda {
   private Long id;
   private String type;
   private String title;
   private List<Activity> activities;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public List<Activity> getActivities() {
      return activities;
   }

   public void setActivities(List<Activity> activities) {
      this.activities = activities;
   }
}

