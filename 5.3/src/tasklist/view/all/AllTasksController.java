package tasklist.view.all;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tasklist.core.ViewHandler;
import tasklist.model.Task;

public class AllTasksController
{
  @FXML public TableView<Task> tableView;
  @FXML public TableColumn<String, Task> creatorColumn;
  @FXML public TableColumn<String, Task> descColumn;
  @FXML public TableColumn<String, Task> dateColumn;
  private ViewHandler viewHandler;

  public void init(AllTasksVM allTasksVM, ViewHandler viewHandler)
  {
      this.viewHandler = viewHandler;

      creatorColumn.setCellValueFactory(new PropertyValueFactory<>("creator"));
      descColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
      dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
      tableView.setItems(allTasksVM.getTaskList());
  }

  @FXML public void onAddTaskButton(ActionEvent actionEvent)
  {
    viewHandler.openAddTaskView();
  }

  @FXML public void onNextTaskButton(ActionEvent actionEvent)
  {
    viewHandler.openGetNextTaskView();
  }
}
