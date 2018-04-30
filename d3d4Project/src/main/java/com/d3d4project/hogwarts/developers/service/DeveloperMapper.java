package com.d3d4project.hogwarts.developers.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shared.model.developers.Developer;

public class DeveloperMapper implements RowMapper<Developer>
{

	@Override
	public Developer mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Developer developer = Developer.builder()
				.firstName(rs.getString("firstname"))
				.lastName(rs.getString("lastname"))
				.nickname(rs.getString("firstname"), rs.getString("lastname"))
				.primarySkill(rs.getString("primaryskill"))
				.level(rs.getString("level"))
				.build();
		
		return developer;
	}

}
