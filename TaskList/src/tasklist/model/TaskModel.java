package tasklist.model;

public interface TaskModel extends PropertyChangeSubject
{
  void addTask(String owner, String disc);
  Task getTask();
}
