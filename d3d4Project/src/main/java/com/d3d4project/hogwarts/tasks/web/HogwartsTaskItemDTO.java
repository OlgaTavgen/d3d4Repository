package com.d3d4project.hogwarts.tasks.web;

import java.util.List;

import com.d3d4project.hogwarts.tasks.model.HogwartsTask;
import com.d3d4project.hogwarts.tasks.model.HogwartsTaskItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;

public class HogwartsTaskItemDTO {
	
	@JsonProperty
	private List<HogwartsTaskDTO> tasks = Lists.newArrayList();
	
	public HogwartsTaskItemDTO(final HogwartsTaskItem item)
	{
		final List<HogwartsTaskDTO> taskDTOs = Lists.newArrayList();
		
		for (final HogwartsTask task: item.getTasks())
		{			
			final HogwartsTaskDTO taskDTO = new HogwartsTaskDTO(task);
			
			taskDTOs.add(taskDTO);			
		}
		
		tasks = taskDTOs;
	}
	
	public List<HogwartsTaskDTO> getTasks() 
	{
		return tasks;
	}
}
