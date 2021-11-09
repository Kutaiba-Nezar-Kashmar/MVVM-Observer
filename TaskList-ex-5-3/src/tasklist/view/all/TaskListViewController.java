package tasklist.view.all;

import tasklist.core.ViewHandler;
import tasklist.core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tasklist.model.Task;
import tasklist.view.ViewController;

public class TaskListViewController implements ViewController
{
  @FXML
  private TableView<Task> tableView;
  @FXML
  private TableColumn<String, Task> creatorColumn;
  @FXML
  private TableColumn<String, Task> descColumn;
  @FXML
  private TableColumn<String, Task> dateColumn;
  private ViewHandler vh;


  public void init(ViewHandler viewHandler, ViewModelFactory vm) {
    TaskListViewModel viewModel = vm.getTaskListViewModel();
    vh = viewHandler;
    creatorColumn.setCellValueFactory(new PropertyValueFactory<>("creator"));
    descColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
    dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateCreated"));
    tableView.setItems(viewModel.getItemsList());

  }

  public void onAddTaskButton(ActionEvent actionEvent) {
    vh.openAdd();
  }

  public void onNextTaskButton(ActionEvent actionEvent) {
    vh.openRemove();
  }
}
