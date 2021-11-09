package tasklist.core;

import tasklist.view.add.AddViewModel;
import tasklist.view.all.TaskListViewModel;
import tasklist.view.remove.NextTaskViewModel;

public class ViewModelFactory
{
  private AddViewModel addViewModel;
  private TaskListViewModel taskListViewModel;
  private NextTaskViewModel nextTaskViewModel;

  public ViewModelFactory(ModelFactory mf) {
    addViewModel = new AddViewModel(mf.getModel());
    taskListViewModel = new TaskListViewModel(mf.getModel());
    nextTaskViewModel = new NextTaskViewModel(mf.getModel());
  }

  public AddViewModel getAddViewModel() {
    return addViewModel;
  }

  public TaskListViewModel getTaskListViewModel() {
    return taskListViewModel;
  }

  public NextTaskViewModel getNextTaskListViewModel() {
    return nextTaskViewModel;
  }
}
