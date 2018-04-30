package com.d3d4project.hogwarts.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d3d4project.hogwarts.common.model.HogwartsResultsResponse;
import com.d3d4project.hogwarts.developers.model.HogwartsDeveloper;
import com.d3d4project.hogwarts.developers.model.HogwartsDeveloperItem;
import com.d3d4project.hogwarts.developers.service.HogwartsDeveloperService;
import com.d3d4project.hogwarts.tasks.model.HogwartsTask;
import com.d3d4project.hogwarts.tasks.model.HogwartsTaskItem;
import com.d3d4project.hogwarts.tasks.service.HogwartsTaskService;

@Service("hogwartsService")
public class HogwartsService
{
	@Autowired
	protected HogwartsDeveloperService hogwartsDeveloperService;
	
	@Autowired
	protected HogwartsTaskService hogwartsTaskService;
	
	public HogwartsRequest forTeam(final String team)
	{		
		return new HogwartsRequest(team);
	}
	
	public class HogwartsRequest
	{
		private String team;
		
		public HogwartsRequest(final String team)
		{
			this.team = team;
		}
		
		public HogwartsResultsResponse retrieveResults()
		{
			final HogwartsResultsResponse response = new HogwartsResultsResponse(getTeam());
			
			response.setDeveloperItem(new HogwartsDeveloperItem());
			response.setTaskItem(new HogwartsTaskItem());
			
			populateResponseForTeam(response);
			
			return response;
		}

		public String getTeam()
		{
			return team;
		}
		
	}
	
	public void populateResponseForTeam(final HogwartsResultsResponse response)
	{
		final List<HogwartsDeveloper> developers = hogwartsDeveloperService.createDevelopersFromXML(response);
					
		final List<HogwartsTask> tasks = hogwartsTaskService.createTasksFromXML();
		
		response.getDeveloperItem().getDevelopers().addAll(developers);
		response.getTaskItem().getTasks().addAll(tasks);
	}

}
