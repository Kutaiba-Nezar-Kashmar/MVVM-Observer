package tasklist.model;

public class Task
{
  private String owner;
  private String description;
  private String timeCreated;

  public Task(String owner, String description, String timeCreated)
  {
    this.owner = owner;
    this.description = description;
    this.timeCreated = timeCreated;
  }

  public String getOwner()
  {
    return owner;
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
