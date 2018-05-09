package com.d3d4project.hogwarts.teams.model;

import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.d3d4project.hogwarts.developers.model.HogwartsDeveloper;

public class HogwartsTeam
{
	private String id = StringUtils.EMPTY;
	private String name = StringUtils.EMPTY;
	private Set<HogwartsDeveloper> developers;
	
	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public Set<HogwartsDeveloper> getDevelopers()
	{
		return developers;
	}

	public void setDevelopers(Set<HogwartsDeveloper> developers)
	{
		this.developers = developers;
	}

	@Override
	public String toString()
	{
		return "Team [id=" + id + ", name=" + name + ", developers=" + developers + "]";
	}
}
