package com.d3d4project.hogwarts.developers.dao;

import java.util.List;

import com.shared.model.developers.Developer;

public interface HogwartsDeveloperDao
{
	
	public void addDeveloper(String firstName, String lastName, String nickname, String primarySkill, String level, int team);
		
	public void updateDeveloperFirstName(String firstName, String newFirstName);
	
	public void updateDeveloperLastName(String lastName, String firstName);
	
	public void updateDeveloperPrimarySkill(String primarySkill, String firstName);

	public void updateDeveloperLevel(String level, String firstName);
	
	public Developer getDeveloper(String lastName);
	
	public List<Developer> getDevelopers();
	
	public void deleteDeveloper(String firstName);

}