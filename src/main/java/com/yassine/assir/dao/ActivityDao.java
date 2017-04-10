package com.yassine.assir.dao;

import java.util.List;
import com.yassine.assir.model.Activity;

public interface ActivityDao {
   void create(Activity activity);

   List<Activity> populateActivitiesByAgendaId(Long id);

   void remove(Long id);

   void edit(Activity idActivity);

   Activity getActivity(Long id);
}
