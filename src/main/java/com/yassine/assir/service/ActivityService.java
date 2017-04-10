package com.yassine.assir.service;

import java.util.List;
import com.yassine.assir.model.Activity;

public interface ActivityService {
   void create(Activity activity);

   List<Activity> populateActivitiesByAgendaId(Long agendaId);

   void remove(Long id);

   void edit(Activity idActivity);

   Activity getActivity(Long id);
}
