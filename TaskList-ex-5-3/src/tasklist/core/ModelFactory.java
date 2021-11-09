package tasklist.core;

import tasklist.model.ListModel;
import tasklist.model.Model;

public class ModelFactory
{
  private Model model;

  public Model getModel() {
    if(model == null) model = new ListModel();
    return model;
  }
}
