package com.d3d4project.hogwarts.tasks.model;

import java.util.List;

import com.google.common.collect.Lists;

public class HogwartsTaskItem {

	private List<HogwartsTask> tasks = Lists.newArrayList();

	public List<HogwartsTask> getTasks()
	{
		return tasks;
	}	
}
