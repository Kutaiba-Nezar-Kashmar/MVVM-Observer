import javafx.application.Application;
import javafx.stage.Stage;
import tasklist.model.DataModelManager;
import tasklist.model.ModelFactory;
import tasklist.view.ViewHandler;
import viewmodel.ViewModelFactory;

import java.util.Random;

//import tasklist.tasklist.model.ModelFactory;
//import viewmodel.ViewModelFactory;

@SuppressWarnings("ALL")
public class TimestampApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
//        DataModel tasklist.tasklist.model = new DataModelManager();
//        TimestampViewModel viewModel =new TimestampViewModel(tasklist.tasklist.model);
//        ViewHandler viewHandler = new ViewHandler(stage, viewModel);
        ModelFactory mf = new ModelFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(mf);
        ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
        viewHandler.start();

        runAutoUpdate((DataModelManager) mf.getDataModel());
    }

    private void runAutoUpdate(DataModelManager m) {
        Thread thread = new Thread(() -> {
            Random r = new Random();
            while (true) {
                m.recalculateData();
                try {
                    Thread.sleep(r.nextInt(500) + 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start() ;
    }
}
