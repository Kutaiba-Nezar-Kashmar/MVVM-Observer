import external.Thermometer;
import javafx.application.Application;
import javafx.stage.Stage;
import temperature.mediator.TemperatureModelManager;
import temperature.model.ModelFactory;
import temperature.view.ViewHandler;
import temperature.view.ViewModelFactory;

import java.io.IOException;

public class TemperatureApp extends Application
{
  public void start(Stage primaryStage) throws IOException
  {

    ModelFactory mf = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(mf);
    ViewHandler viewHandler = new ViewHandler(primaryStage, viewModelFactory);
    viewHandler.start();

    runTemp((TemperatureModelManager) mf.getTemperatureModel());
  }

  private void runTemp(TemperatureModelManager m)
  {
    Thermometer t1 = new Thermometer("t1", 15, 1, m);
    Thermometer t2 = new Thermometer("t2", 15, 7, m);
    Thread thread = new Thread(t1);
    Thread thread1 = new Thread(t2);

    thread.start();
    thread1.start();
  }
}
