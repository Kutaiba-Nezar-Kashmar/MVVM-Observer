package tasklist.view.add;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import tasklist.model.Model;

public class AddViewModel
{
  private StringProperty creator;
  private StringProperty description;

  private Model model;

  public AddViewModel(Model _model) {
    model = _model;
    creator = new SimpleStringProperty();
    description = new SimpleStringProperty();
  }

  void addNewTask() {
    model.addTask(creator.getValue(), description.getValue());
    creator.setValue("");
    description.setValue("");
  }


  StringProperty creatorProperty() {
    return creator;
  }

  StringProperty descriptionProperty() {
    return description;
  }

  void clear() {
    creator.set("");
    description.set("");
  }
}
