package com.d3d4project.hogwarts.tasks.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.d3d4project.hogwarts.tasks.service.TaskMapper;
import com.shared.model.tasks.Task;

public class HogwartsTaskDaoImpl implements HogwartsTaskDao
{
	public DataSource dataSource;
	public JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void addTask(Task task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTask(Task task) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Task> getTasks() 
	{
		String sql = "select * from tasks";
		List<Task> tasks = jdbcTemplate.query(sql, new TaskMapper());
		return tasks;
	}

}
