package com.yassine.assir.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.yassine.assir.dao.ActivityDao;
import com.yassine.assir.dao.ConnectionFactory;
import com.yassine.assir.dao.DbUtil;
import com.yassine.assir.model.Activity;

public class ActivityDaoImpl implements ActivityDao {
   private Connection connection;
   private Statement statement;
   private ResultSet resultSet;

   public void create(Activity activity) {
      String query = "INSERT INTO activity (title, description, start_date, end_date, id_agenda) VALUES " +
            "(\"" + activity.getTitle() + "\", \"" + activity.getDescription() + "\"," +
            " \"" + activity.getStartDate() + "\", \"" + activity.getEndDate() + "\", 1);";

      executeUpdate(query);
   }

   public List<Activity> populateActivitiesByAgendaId(Long id) {
      String query = "select * from activity where id_agenda=1;";
      return executeQuery(query);
   }

   public void remove(Long id) {
      String query = "DELETE from activity where id=" + id;
      executeUpdate(query);
   }

   public void edit(Activity activity) {
      String query = "UPDATE activity set title ='" + activity.getTitle() + "', description = '" + activity.getDescription() +"',\n" +
            "start_date = '" + activity.getStartDate() + "', end_date = '" + activity.getEndDate() + "' where id= " + activity.getId();
      executeUpdate(query);
   }

   public Activity getActivity(Long id) {
      String query = "select * from activity where id_agenda=1 and id=" + id + ";";
      return executeQuery(query).get(0);
   }

   private List<Activity> executeQuery(String query) {
      List<Activity> activities = new ArrayList<Activity>();
      try {
         connection = ConnectionFactory.getConnection();
         statement = connection.createStatement();
         resultSet = statement.executeQuery(query);
         while (resultSet.next()) {
//            newActivity(resultSet.getLong("id"),
//                  resultSet.getString("title"),
//                  resultSet.getString("description"),
//                  resultSet.getDate("start_date"),
//
//
            Activity activity = newActivity(resultSet.getLong("id"),
                  resultSet.getString("title"),
                  resultSet.getString("description"),
                  new Date(),
                  new Date());

            activities.add(activity);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DbUtil.close(resultSet);
         DbUtil.close(statement);
         DbUtil.close(connection);
      }
      return activities;
   }

   private void executeUpdate(String query) {
      try {
         connection = ConnectionFactory.getConnection();
         statement = connection.createStatement();
         statement.executeUpdate(query);
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DbUtil.close(statement);
         DbUtil.close(connection);
      }
   }

   private static Activity newActivity(Long id, String title, String description, Date startDate, Date endDate) {
      Activity activity = new Activity();
      activity.setId(id);
      activity.setTitle(title);
      activity.setDescription(description);
      activity.setStartDate(startDate);
      activity.setEndDate(endDate);
      return activity;
   }
}
