package tasklist.core;

import tasklist.view.all.AllTasksVM;

public class ViewModelFactory
{
  private AllTasksVM allTasksVM;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    allTasksVM = new AllTasksVM(modelFactory.getTaskModel());
  }

  public AllTasksVM getAllTasksVM()
  {
    return allTasksVM;
  }
}
