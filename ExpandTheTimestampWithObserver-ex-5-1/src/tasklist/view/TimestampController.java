package tasklist.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import viewmodel.TimestampViewModel;
//import viewmodel.ViewModelFactory;

public class TimestampController {

    @FXML
    Circle circle;
    @FXML
    Label eventLabel;
    @FXML
    Label numberOfUpdates;


    private TimestampViewModel viewModel;

    public TimestampController() {
    }

    public void init(TimestampViewModel viewModel) {
        this.viewModel = viewModel;

        eventLabel.textProperty().bind(viewModel.updateTimeStampProperty());
        numberOfUpdates.textProperty().bind(viewModel.numberOfUpdatesProperty());
        //circle.fillProperty().bind(viewModel.fillProperty());
    }

    public void onUpdateButton(ActionEvent actionEvent) {
        viewModel.updateTimestamp();
    }
}
