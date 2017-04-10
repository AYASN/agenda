package com.yassine.assir.service.impl;

import com.yassine.assir.dao.AgendaDao;
import com.yassine.assir.dao.impl.AgendaDaoImpl;
import com.yassine.assir.model.Agenda;
import com.yassine.assir.service.AgendaService;

public class AgendaServiceImpl implements AgendaService {
   private AgendaDao agendaDao;

   public AgendaServiceImpl() {
      agendaDao = new AgendaDaoImpl();
   }

   public Agenda createAgenda() {
      return new Agenda();
//      return agendaDao.create();
   }
}
