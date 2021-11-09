package tasklist.model;

import java.beans.PropertyChangeListener;

public interface Model
{
  void addTask(String creator, String description);

  Task getNextTask();

  void addActionListener(String eventName, PropertyChangeListener listener);
}
