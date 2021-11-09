package tasklist.view;

import tasklist.core.ViewHandler;
import tasklist.core.ViewModelFactory;

public interface ViewController
{
  void init(ViewHandler vh, ViewModelFactory vmf);
}
