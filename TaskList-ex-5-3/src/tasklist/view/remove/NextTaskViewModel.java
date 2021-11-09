package tasklist.view.remove;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import tasklist.model.Model;
import tasklist.model.Task;

public class NextTaskViewModel
{
  private StringProperty desc, createdBy, date;

  private Model model;

  public NextTaskViewModel(Model model) {
    this.model = model;
    desc = new SimpleStringProperty();
    createdBy = new SimpleStringProperty();
    date = new SimpleStringProperty();
  }

  void getNextTask() {
    Task task = model.getNextTask();
    desc.setValue(task.getDescription());
    createdBy.setValue(task.getCreator());
    date.setValue(task.getDateCreated());
  }

  void clear() {
    desc.setValue("");
    createdBy.setValue("");
    date.setValue("");
  }

  StringProperty descProperty() {
    return desc;
  }

  StringProperty createdByProperty() {
    return createdBy;
  }

  StringProperty dateProperty() {
    return date;
  }
}
