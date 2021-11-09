package tasklist.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tasklist.view.ViewController;

import java.io.IOException;

public class ViewHandler
{
  private ViewModelFactory viewModelFactory;
  private Stage mainStage;

  public ViewHandler(Stage stage, ViewModelFactory vmf) {
    mainStage = stage;
    viewModelFactory = vmf;
  }

  public void start() {
    openShowAllView();
  }

  private Scene addScene;
  private Scene removeTaskScene;
  private Scene viewAllScene;

  public void openAdd() {
    try {
      if (addScene == null) {
        addScene = getScene("../tasklist.tasklist.view/tasklist.tasklist.view.tasklist.view.add/Add.fxml");
      }
      changeScene("Add task", addScene);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void openShowAllView() {
    try {
      if(viewAllScene == null)
        viewAllScene = getScene("../tasklist.tasklist.view/tasklist.tasklist.view.tasklist.view.all/TaskList.fxml");
      changeScene("View tasks", viewAllScene);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void openRemove() {
    try {
      if (removeTaskScene == null)
        removeTaskScene = getScene("../tasklist.tasklist.view/tasklist.tasklist.view.tasklist.view.remove/GetNextTask.fxml");
      changeScene("Get task", removeTaskScene);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void changeScene(String s, Scene addScene) {
    mainStage.setTitle(s);
    mainStage.setScene(addScene);
    mainStage.show();
  }

  private Scene getScene(String path) {
    try {
      FXMLLoader loader = new FXMLLoader();

      loader.setLocation(getClass().getResource(path));
      Parent root = loader.load();

      ViewController view = loader.getController();
      view.init(this, viewModelFactory);

      return new Scene(root);
    } catch (IOException e) {
      e.printStackTrace();
    }
    throw new RuntimeException("Failed to create scene");
  }

}
