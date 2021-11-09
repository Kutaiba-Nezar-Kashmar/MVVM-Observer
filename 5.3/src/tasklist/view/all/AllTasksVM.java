package tasklist.view.all;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tasklist.model.Task;
import tasklist.model.TaskModel;

import java.beans.PropertyChangeEvent;

public class AllTasksVM
{
  private ObservableList<Task> tasks;
  private TaskModel mdl;

  public AllTasksVM(TaskModel mdl)
  {
    this.mdl = mdl;
    tasks = FXCollections.observableArrayList();

    mdl.addPropertyChangeListener("TaskAdded", this::listModified);
    mdl.addPropertyChangeListener("TaskRemoved", evt -> tasks.removeAll((Task) evt.getNewValue()));
  }

  public ObservableList<Task> getTaskList()
  {
    return tasks;
  }

 private void listModified(PropertyChangeEvent evt)
 {
  tasks.add((Task) evt.getNewValue());
 }
}
