package temperature.view;

import temperature.model.ModelFactory;

public class ViewModelFactory
{
  private TemperatureViewModel temperatureViewModel;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    temperatureViewModel = new TemperatureViewModel(modelFactory.getTemperatureModel());
  }

  public TemperatureViewModel getTemperatureViewModel()
  {
    return temperatureViewModel;
  }
}
