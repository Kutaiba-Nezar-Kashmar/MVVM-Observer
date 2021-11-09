package temperature.view;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import temperature.mediator.TemperatureModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TemperatureViewController implements PropertyChangeListener
{
   @FXML private Label outputLabel;
   @FXML private TextField filterField;
   @FXML private Label filterLabel;

   private ViewHandler viewHandler;

   private TemperatureViewModel viewModel;
   private TemperatureModel model;

   public TemperatureViewController()
   {
   }

   public void init(TemperatureViewModel viewModel)
   {
      outputLabel.textProperty().bind(viewModel.temperatureProperty());
      this.viewModel = viewModel;
      model.addPropertyChangeListener(null, this);
   }

   public void reset()
   {
      model.removePropertyChangeListener(null, this);
   }

   @FXML private void updateButtonPressed()
   {
      viewModel.getValue();
   }

   @FXML private void onFilter()
   {
      viewModel.updateTheThermometerId();
   }

   @Override public void propertyChange(PropertyChangeEvent evt)
   {
      Platform.runLater(() -> outputLabel.setText(evt.getNewValue().toString()));
   }


}
