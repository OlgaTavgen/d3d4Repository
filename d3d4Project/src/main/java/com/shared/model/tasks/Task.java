package com.shared.model.tasks;

public class Task {

	private String type;
	private String description;
	private String estimate;
	private String priority;
	private String severity;
	
	private Task(final Task prototype)
	{
		if (prototype != null)
		{
			//@formatter:off
			type = prototype.type;
			description = prototype.description;
			estimate = prototype.estimate;
			priority = prototype.priority;
			severity = prototype.severity;
			//@formatter:on
		}		
	}
	
	public static Builder builder()
	{
		return builder(null);
	}
	
	public static Builder builder(final Task prototype)
	{
		return new Builder(prototype);
	}
	
	public String getType()
	{
		return type;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public String getEstimate()
	{
		return estimate;
	}
	
	public String getPriority()
	{
		return priority;
	}
	
	public String getSeverity()
	{
		return severity;
	}

	public static final class Builder
	{
		private final Task prototype;
		
		private Builder(final Task prototype)
		{
			this.prototype = new Task(prototype);
		}
		
		public Builder type(String type)
		{
			prototype.type = type;
			
			return this;
		}
		
		public Builder description(String description)
		{
			prototype.description = description;
			
			return this;
		}
		
		public Builder estimate(String estimate)
		{
			prototype.estimate = estimate;
			
			return this;
		}
		
		public Builder priority(String priority)
		{
			prototype.priority = priority;
			
			return this;
		}
		
		public Builder severity(String severity)
		{
			prototype.severity = severity;
			
			return this;
		}
		
		public Task build()
		{
			return new Task(prototype);
		}
	}
}
