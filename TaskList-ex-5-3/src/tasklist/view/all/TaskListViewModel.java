package tasklist.view.all;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tasklist.model.Model;
import tasklist.model.Task;

import java.beans.PropertyChangeEvent;

public class TaskListViewModel
{
  private Model model;

  private ObservableList<Task> items;

  public TaskListViewModel(Model model) {
    this.model = model;
    items = FXCollections.observableArrayList();
    model.addActionListener("TaskAdded", this::listModified);
    model.addActionListener("TaskRemoved", evt -> items.remove( (Task)evt.getNewValue() ));

  }

  private void listModified(PropertyChangeEvent evt) {
    items.add((Task)evt.getNewValue());
  }

  ObservableList<Task> getItemsList() {
    return items;
  }
}
