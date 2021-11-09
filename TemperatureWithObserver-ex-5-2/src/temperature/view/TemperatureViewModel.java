package temperature.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import temperature.mediator.TemperatureModel;
import temperature.model.Temperature;

public class TemperatureViewModel
{
  private StringProperty temperature;
  private StringProperty id;
  private TemperatureModel model;

  public TemperatureViewModel(TemperatureModel model)
  {
    this.model = model;
    id = new SimpleStringProperty("ID: ");
    temperature = new SimpleStringProperty("0");
  }
  public void getLastTemp()
  {
    model.getLastInsertedTemperature();
  }

  public void getValue()
  {
    Temperature t = model.getLastInsertedTemperature();
    temperature.setValue(t.getValue() + "");
  }


  public StringProperty temperatureProperty()
  {
    return temperature;
  }

  public StringProperty updateTheThermometerId()
  {
    return id;
  }
}
