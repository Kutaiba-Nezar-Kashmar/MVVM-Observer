import tasklist.core.ModelFactory;
import tasklist.core.ViewHandler;
import tasklist.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class TaskListApplication extends Application
{
  @Override
  public void start(Stage stage) {
    ModelFactory mf = new ModelFactory();
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(stage, vmf);
    vh.start();
  }
}
