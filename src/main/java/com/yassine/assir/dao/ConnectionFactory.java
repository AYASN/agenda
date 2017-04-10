package com.yassine.assir.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

   private static final java.lang.String DRIVER_CLASS = "org.sqlite.JDBC";
   String urlToDbFile = this.getClass().getClassLoader().getResource("agenda.db").toString();
   public static String DB_URL = null;
   private static ConnectionFactory instance = new ConnectionFactory();

   public ConnectionFactory() {
      DB_URL = "jdbc:sqlite:" + urlToDbFile;
      try {
         Class.forName(DRIVER_CLASS);
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
   }


   private Connection createConnection() {
      Connection connection = null;
      try {
         connection = DriverManager.getConnection(DB_URL);
         connection.setAutoCommit(true);
      } catch (SQLException e) {
         System.err.println("ERROR: Unable to connect to Database.");
      }
      return connection;
   }

   public static Connection getConnection() {
      return instance.createConnection();
   }
}
