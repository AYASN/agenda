package com.yassine.assir.service.impl;

import java.util.List;
import com.yassine.assir.dao.ActivityDao;
import com.yassine.assir.dao.impl.ActivityDaoImpl;
import com.yassine.assir.model.Activity;
import com.yassine.assir.service.ActivityService;

public class ActivityServiceImpl implements ActivityService {
   private ActivityDao activityDao;

   public ActivityServiceImpl() {
      activityDao = new ActivityDaoImpl();
   }

   public void create(Activity activity) {
      activityDao.create(activity);
   }

   public List<Activity> populateActivitiesByAgendaId(Long id) {
      return activityDao.populateActivitiesByAgendaId(id);
   }

   public void remove(Long id) {
      activityDao.remove(id);
   }

   public void edit(Activity activity) {
      activityDao.edit(activity);
   }

   public Activity getActivity(Long id) {
      return activityDao.getActivity(id);
   }
}
