package tasklist.view.add;

import tasklist.core.ViewHandler;
import tasklist.core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import tasklist.view.ViewController;

public class AddViewController implements ViewController
{
  @FXML private TextField creatorTextField, descTextField;

  private AddViewModel addViewModel;
  private ViewHandler vh;

  public void init(ViewHandler vh, ViewModelFactory vmf) {
    this.addViewModel = vmf.getAddViewModel();
    this.vh = vh;
    addViewModel.creatorProperty().bindBidirectional(creatorTextField.textProperty());
    addViewModel.descriptionProperty().bindBidirectional(descTextField.textProperty());
  }

  public void onAddAction(ActionEvent actionEvent) {
    addViewModel.addNewTask();
  }

  public void onCancelAction(ActionEvent actionEvent) {
    addViewModel.clear();
    vh.openShowAllView();
  }
}
