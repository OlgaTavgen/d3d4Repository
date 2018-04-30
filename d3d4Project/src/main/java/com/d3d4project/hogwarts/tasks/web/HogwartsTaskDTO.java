package com.d3d4project.hogwarts.tasks.web;

import com.d3d4project.hogwarts.tasks.model.HogwartsTask;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(
		creatorVisibility = Visibility.NONE,
		fieldVisibility = Visibility.NONE,
		getterVisibility = Visibility.NONE,
		isGetterVisibility = Visibility.NONE,
		setterVisibility = Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HogwartsTaskDTO
{
	@JsonProperty
	private String id;
	
	@JsonProperty
	private String type;
	
	@JsonProperty
	private String description;
	
	@JsonProperty
	private String estimate;
	
	@JsonProperty
	private String priority;
	
	@JsonProperty
	private String severity;
	
	public HogwartsTaskDTO(final HogwartsTask task)
	{
		this.id = task.getId();
		this.type = task.getType();
		this.description = task.getDescription();
		this.estimate = task.getEstimate();
		this.priority = task.getPriority();
		this.severity = task.getSeverity();
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
}
