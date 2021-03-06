package tasklist;

import javafx.application.Application;
import javafx.stage.Stage;
import tasklist.core.ModelFactory;
import tasklist.core.ViewHandler;
import tasklist.core.ViewModelFactory;
import tasklist.model.TaskModelManager;

public class TaskListApplication extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
    viewHandler.start();

    Thread thread = new Thread(()-> {
      TaskModelManager taskModelManager = (TaskModelManager) modelFactory.getTaskModel();
      for (int i = 0; i < 10; i++)
      {
        try
        {
          Thread.sleep(2500);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
        taskModelManager.addTask("MyName", "Test task" + i);

      }
    });
    thread.setDaemon(true);
    thread.start();
  }
}
