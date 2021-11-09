package tasklist.model;

public class Task
{
  private String creator;
  private String description;
  private String timeCreated;

  public Task(String owner, String description, String timeCreated)
  {
    this.creator = owner;
    this.description = description;
    this.timeCreated = timeCreated;
  }

  public String getCreator()
  {
    return creator;
  }

  public String getDescription()
  {
    return description;
  }

  public String getTimeCreated()
  {
    return timeCreated;
  }
}
