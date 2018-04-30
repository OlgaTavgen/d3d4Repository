package com.d3d4project.hogwarts.tasks.model;

import java.util.Properties;

import org.apache.commons.lang.StringUtils;

public class HogwartsTask
{
	private String id = StringUtils.EMPTY;
	private String type = StringUtils.EMPTY;
	private String description = StringUtils.EMPTY;
	private String estimate = StringUtils.EMPTY;
	private String priority = StringUtils.EMPTY;
	private String severity = StringUtils.EMPTY;
	
	private Properties props;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() 
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public String getDescription() 
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public String getEstimate() {
		return estimate;
	}
	public void setEstimate(String estimate) {
		this.estimate = estimate;
	}
	
	public String getPriority()
	{
		return priority;
	}
	
	public void setPriority(String priority)
	{
		this.priority = priority;
	}
	
	public String getSeverity()
	{
		return severity;
	}
	
	public void setSeverity(String severity)
	{
		this.severity = severity;
	}	
	
	public Properties getProps()
	{
		return props;
	}

	public void setProps(Properties props)
	{
		this.props = props;
	}

	@Override
	public String toString()
	{
		return "Task [id=" + id + ", type=" + type + ", description=" + description + ", estimate=" + estimate +
				", priority=" + priority + ", severity=" + severity + ", props" + props + "]";
	}
}
