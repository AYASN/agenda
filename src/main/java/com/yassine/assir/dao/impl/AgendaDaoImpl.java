package com.yassine.assir.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.yassine.assir.dao.AgendaDao;
import com.yassine.assir.dao.ConnectionFactory;
import com.yassine.assir.dao.DbUtil;
import com.yassine.assir.model.Agenda;

public class AgendaDaoImpl implements AgendaDao {

   private Connection connection;
   private Statement statement;

   public void create(Agenda agenda) {
      String query = "INSERT INTO agenda (title, type) VALUES (\"" + agenda.getTitle() +"\", \"" + agenda.getType() + "\");";
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


}
