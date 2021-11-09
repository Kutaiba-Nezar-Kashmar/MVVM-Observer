package tasklist.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListModel implements Model
{
  private List<Task> taskList;
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  public ListModel() {
    taskList = new ArrayList<>();
  }

  @Override
  public void addTask(String creator, String description) {
    Task task = new Task(creator, description, calcTimeStamp());
    taskList.add(task);
    support.firePropertyChange("TaskAdded", null, task);
  }

  @Override
  public Task getNextTask() {
    Task removedTask = taskList.remove(0);
    support.firePropertyChange("TaskRemoved", null, removedTask);
    return removedTask;
  }

  @Override
  public void addActionListener(String eventName, PropertyChangeListener listener) {
    if(eventName == null || "".equals(eventName)) {
      support.addPropertyChangeListener(listener);
    } else {
      support.addPropertyChangeListener(eventName, listener);
    }
  }

  private String calcTimeStamp() {
    SimpleDateFormat sdfDate =
        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date now = new Date();
    return sdfDate.format(now);
  }
}
