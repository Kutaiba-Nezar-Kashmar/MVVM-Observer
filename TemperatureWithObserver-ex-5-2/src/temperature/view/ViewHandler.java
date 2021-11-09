package temperature.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import temperature.mediator.TemperatureModel;

import java.io.IOException;

public class ViewHandler
{
  private Stage primaryStage;
  private Scene currentScene;
private TemperatureModel model;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(Stage stage, ViewModelFactory viewModelFactory)
  {
    primaryStage = stage;
    this.viewModelFactory = viewModelFactory;
  }

  public ViewHandler(TemperatureModel model)
  {
    this.model = model;
  }

  public void start() throws IOException
  {
    openView("Temperature");
  }

  public void openView(String id) throws IOException
  {

    Scene scene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    loader.setLocation(getClass().getResource(id + "View.fxml"));
    root = loader.load();
    if ("Temperature".equals(id))
    {
      TemperatureViewController view = loader.getController();
      view.init(viewModelFactory.getTemperatureViewModel());
      primaryStage.setTitle("BLA");
    }
      scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

}
