package tasklist.view.remove;

import tasklist.core.ViewHandler;
import tasklist.core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import tasklist.view.ViewController;

public class GetNextTaskViewController implements ViewController
{
  @FXML Label descLabel, createdByLabel, timeLabel;

  private NextTaskViewModel viewModel;
  private ViewHandler vh;

  public void init(ViewHandler viewHandler, ViewModelFactory vm) {
    viewModel = vm.getNextTaskListViewModel();
    vh = viewHandler;
    descLabel.textProperty().bind(viewModel.descProperty());
    createdByLabel.textProperty().bind(viewModel.createdByProperty());
    timeLabel.textProperty().bind(viewModel.dateProperty());
  }

  public void onGetTaskButton(ActionEvent actionEvent) {
    viewModel.getNextTask();
  }

  public void onBackButton(ActionEvent actionEvent) {
    viewModel.clear();
    vh.openShowAllView();
  }
}
