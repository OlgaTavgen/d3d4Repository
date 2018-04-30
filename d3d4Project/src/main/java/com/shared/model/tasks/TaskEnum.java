package com.shared.model.tasks;

public enum TaskEnum {
	TASK1(
			"120301",
			"BUG",
			"Dashboard: Search field doesn't contain placeholder",
			"0.5",
			"4",
			"1"),
	TASK2(
			"120302",
			"BUG",
			"Document Editor: NullPointerException while trying to retrieve JSON for Folders Category",
			"1",
			"1",
			"3"),
	TASK3(
			"120303",
			"BUG",
			"Wizards: Wizard's component doesn't support TAB navigation",
			"1",
			"1",
			"2"),
	TASK4(
			"120304",
			"BUG",
			"Document: titles are not bold",
			"0.5",
			"2",
			"4"),
	TASK5(
			"220301",
			"STORY",
			"Dashboard: New Project Wizard",
			"3",
			"1",
			"3"),
	TASK6(
			"220302",
			"STORY",
			"Document: JSON for Templates Category",
			"4",
			"1",
			"2"),
	TASK7(
			"220303",
			"STORY",
			"Document Editor: Redesign for Lefthand Navigation tab",
			"2",
			"3",
			"5"),
	TASK8(
			"220304",
			"STORY",
			"Wizards: New 'author notes' field",
			"1",
			"1",
			"4"),
	TASK9(
			"320301",
			"TESTING",
			"Dashboard: Automation Coverage for New Project Wizard",
			"2",
			"1",
			"3"),
	TASK10(
			"320302",
			"TESTING",
			"Wizards: validate bug 120303",
			"1",
			"2",
			"4"),
	TASK11(
			"320303",
			"TESTING",
			"Document Editor: validate new design for Lefthand Navigation tab",
			"1",
			"1",
			"3"),
	TASK12(
			"320304",
			"TESTING",
			"Document: validate bug Document's titles 120304",
			"0.5",
			"2",
			"4");
	
	private final String id;
	private final String type;
	private final String description;
	private final String estimate;
	private final String priority;
	private final String severity;
		
	TaskEnum(final String id, final String type, final String description, 
			final String estimate, final String priority, final String severity)
	{
		this.id = id;
		this.type = type;
		this.description = description;
		this.estimate = estimate;
		this.priority = priority;
		this.severity = severity;
	}
	
	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public String getEstimate() {
		return estimate;
	}

	public String getId()
	{
		return id;
	}

	public String getPriority() {
		return priority;
	}

	public String getSeverity() {
		return severity;
	}
}
