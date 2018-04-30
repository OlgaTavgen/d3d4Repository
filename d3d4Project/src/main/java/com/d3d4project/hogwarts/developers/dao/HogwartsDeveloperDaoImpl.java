package com.d3d4project.hogwarts.developers.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.d3d4project.hogwarts.developers.service.DeveloperMapper;
import com.shared.model.developers.Developer;

public class HogwartsDeveloperDaoImpl implements HogwartsDeveloperDao
{
	public DataSource dataSource;
	public JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void addDeveloper(String firstName, String lastName, String nickname, String primarySkill, String level, int team) 
	{				
		String sql = "insert into developers (firstname, lastname, nickname, primaryskill, level, team) values (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, firstName, lastName, nickname, primarySkill, level, team);
	}

	@Override
	public void deleteDeveloper(String firstName)
	{		
		String sql = "delete from developers where firstname = ?";
		
		jdbcTemplate.update(sql, firstName);
		System.out.println("Deleted Record with firstName = " + firstName);
		
	}

	@Override
	public void updateDeveloperFirstName(String newFirstName, String firstName) 
	{
		String sql = "update developers set firstname = ? where firstname = ?";		
		jdbcTemplate.update(sql, newFirstName, firstName);
		System.out.println("Updated Record with firstname = " + firstName + ", newFirstName = " + newFirstName);
	}

	@Override
	public void updateDeveloperLastName(String lastName, String firstName) 
	{
		String sql = "update developers set lastname = ? where firstname = ?";		
		jdbcTemplate.update(sql, lastName, firstName);
		System.out.println("Updated Record with firstname = " + firstName + ", lastname = " + lastName);		
	}

	@Override
	public void updateDeveloperPrimarySkill(String primarySkill, String firstName) 
	{
		String sql = "update developers set primaryskill = ? where firstname = ?";		
		jdbcTemplate.update(sql, primarySkill, firstName);
		System.out.println("Updated Record with firstname = " + firstName + ", primaryskill = " + primarySkill);			
	}

	@Override
	public void updateDeveloperLevel(String level, String firstName) 
	{
		String sql = "update developers set level = ? where firstname = ?";		
		jdbcTemplate.update(sql, level, firstName);
		System.out.println("Updated Record with firstname = " + firstName + ", level = " + level);		
	}

	@Override
	public List<Developer> getDevelopers() 
	{
		String sql = "select * from developers";
		List<Developer> developers = jdbcTemplate.query(sql, new DeveloperMapper());
		return developers;
	}

	@Override
	public Developer getDeveloper(String lastName) 
	{		
		String sql = "select * from developers where lastname = ?";
		Developer developer = jdbcTemplate.queryForObject(sql, new Object[]{lastName}, new DeveloperMapper());
		
		return developer;
	}
}