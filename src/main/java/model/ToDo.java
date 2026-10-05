package model;

public class ToDo
{
	private final int id;
	private final String description;
	private final String dueDate; // ISO yyyy-mm-dd oder null
	private boolean completed;

	public ToDo(int id, String description, String dueDate, boolean completed)
	{
		this.id = id;
		this.description = description;
		this.dueDate = dueDate;
		this.completed = completed;
	}

	@Override
	public String toString()
	{
		return "ToDo{" +
		"id=" + id +
		", description='" + description + '\'' +
		", dueDate='" + dueDate + '\'' +
		", completed=" + completed +
		'}';
	}
}
