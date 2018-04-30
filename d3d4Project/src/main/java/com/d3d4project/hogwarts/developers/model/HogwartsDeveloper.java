package com.d3d4project.hogwarts.developers.model;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.d3d4project.hogwarts.tasks.model.HogwartsTask;

public class HogwartsDeveloper {

	private String firstName = StringUtils.EMPTY;
	private String lastName = StringUtils.EMPTY;
	private String nickname = StringUtils.EMPTY;
	private String primarySkill = StringUtils.EMPTY;

	private String level;
	
	private Map<HogwartsDeveloper, HogwartsTask> taskMapping;
	
	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getNickname()
	{
		return nickname;
	}
	
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}
	
	public String getPrimarySkill()
	{
		return primarySkill;
	}
	
	public void setPrimarySkill(String primarySkill)
	{
		this.primarySkill = primarySkill;
	}
	
	public Map<HogwartsDeveloper, HogwartsTask> getTasks() 
	{
		return taskMapping;
	}

	public void setTasks(Map<HogwartsDeveloper, HogwartsTask> taskMapping) 
	{
		this.taskMapping = taskMapping;
	}

	public String getLevel() 
	{
		return level;
	}

	public void setLevel(String level)
	{
		this.level = level;
	}

	@Override
	public String toString()
	{
		return "Developer [firstName=" + firstName + ", lastName=" + lastName + ", nickname=" + nickname + ", primarySkill=" + primarySkill + ", level=" + level + ", tasks=" + taskMapping + "]";
	}
}
