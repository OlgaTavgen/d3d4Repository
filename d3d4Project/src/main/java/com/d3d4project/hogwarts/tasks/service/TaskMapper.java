package com.d3d4project.hogwarts.tasks.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shared.model.tasks.Task;

public class TaskMapper implements RowMapper<Task> 
{
	@Override
	public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Task task = Task.builder()
				.description(rs.getString("description"))
				.estimate(rs.getString("estimate"))
				.priority(rs.getString("priority"))
				.severity(rs.getString("severity"))
				.type(rs.getString("type"))
				.build();
		
		return task;
	}
}
