package tasklist.view.all;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tasklist.model.Task;
import tasklist.model.TaskModel;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class AllTasksVM
{
  private ObservableList<Task> tasks;
  private TaskModel model;

  public AllTasksVM(TaskModel model)
  {
    this.model = model;
    tasks = FXCollections.observableArrayList();
    model.addPropertyChangeListener("TaskAdded", this::listModified);
    model.addPropertyChangeListener("TaskRemoved", evt -> tasks.remove((Task) evt.getNewValue()));
  }

  private void listModified(PropertyChangeEvent evt)
  {
    tasks.add((Task) evt.getNewValue());
  }

  public ObservableList<Task> getTaskList()
  {
    return tasks;
  }
}
