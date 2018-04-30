package com.d3d4project.hogwarts.common.web;

import org.springframework.ui.ModelMap;

import com.d3d4project.hogwarts.common.model.HogwartsResultsResponse;
import com.d3d4project.hogwarts.common.service.HogwartsService;
import com.d3d4project.hogwarts.developers.model.HogwartsDeveloper;
import com.d3d4project.hogwarts.developers.model.HogwartsDeveloperItem;
import com.d3d4project.hogwarts.tasks.model.HogwartsTask;
import com.d3d4project.hogwarts.tasks.model.HogwartsTaskItem;
import com.google.common.collect.Lists;

import javax.servlet.http.HttpServletResponse;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.Assertions.assertThat;

@SuppressWarnings("nls")
@RunWith(MockitoJUnitRunner.class)
public class HogwartsControllerTest 
{
	@InjectMocks
	private HogwartsController hogwartsController;
	
	@Mock
	public HogwartsService hogwartsService;
	
	@Mock
	public HogwartsService.HogwartsRequest hogwartsRequest;
	
	@Mock
	public HogwartsResultsResponse hogwartsResultsResponse;
	
	@Mock
	public HogwartsDeveloperItem hogwartsDeveloperItem;
	
	@Mock
	public HogwartsTaskItem hogwartsTaskItem;
	
	@Mock
	private HogwartsDeveloper hogwartsDeveloper;
	
	@Mock
	private HogwartsTask hogwartsTask;
	
	private String team;
	
	private HogwartsResultsResponseDTO hogwartsResultsResponseDTO;
	
	@Before
	public void init()
	{
		hogwartsTask = new HogwartsTask();
		team = "Slytherin";
		when(hogwartsService.forTeam(team)).thenReturn(hogwartsRequest);
		when(hogwartsRequest.retrieveResults()).thenReturn(hogwartsResultsResponse);
		when(hogwartsResultsResponse.getDeveloperItem()).thenReturn(hogwartsDeveloperItem);
		when(hogwartsResultsResponse.getTaskItem()).thenReturn(hogwartsTaskItem);
		when(hogwartsDeveloperItem.getDevelopers()).thenReturn(Lists.newArrayList(hogwartsDeveloper));
		when(hogwartsTaskItem.getTasks()).thenReturn(Lists.newArrayList(hogwartsTask));
		
		createStubbedDeveloper();
	}
	
	@Test
	public void testHogwartsHomePage()
	{
		assertThat(hogwartsController.hogwartsHomePage()).isEqualTo("/home.html");
	}
	
	@Test
	public void testRetrieveResults()
	{
		hogwartsResultsResponseDTO = hogwartsController.retrieveResults(team);
		
		assertThat(hogwartsResultsResponseDTO.getDevelopers()).isNotNull();
		assertThat(hogwartsResultsResponseDTO.getTasks()).isNotNull();
	}
	
	@Test
	public void testSaveDeveloper()
	{
		final ModelMap modelMap =new ModelMap();
		
		hogwartsController.saveDeveloper(hogwartsDeveloper, modelMap);
		
		assertTrue(modelMap.containsAttribute("firstName"));
		assertTrue(modelMap.containsAttribute("lastName"));
		assertTrue(modelMap.containsAttribute("nickname"));
		assertTrue(modelMap.containsAttribute("level"));
		assertTrue(modelMap.containsAttribute("primarySkill"));
		
		assertThat(modelMap.get("firstName")).isEqualTo("firstName 1");
		assertThat(modelMap.get("lastName")).isEqualTo("lastName 1");
		assertThat(modelMap.get("nickname")).isEqualTo("nickname 1");
		assertThat(modelMap.get("level")).isEqualTo("level 1");
		assertThat(modelMap.get("primarySkill")).isEqualTo("primarySkill 1");
	}
	
	@Test
	public void testTask()
	{
		hogwartsController.task(hogwartsTask);
		
		assertThat(hogwartsTask.getId()).isEqualTo("1");
		assertThat(hogwartsTask.getPriority()).isEqualTo("2");
		assertThat(hogwartsTask.getDescription()).isEqualTo("description for task 1");
		assertThat(hogwartsTask.getEstimate()).isEqualTo("2");
		assertThat(hogwartsTask.getSeverity()).isEqualTo("3");
		assertThat(hogwartsTask.getType()).isEqualTo("bug");		
	}
	
	@Test
	public void testHelloCookie()
	{
		Long hitCounter = new Long(5);
		
		HttpServletResponse response = mock(HttpServletResponse.class);
		
		hogwartsController.helloCookie(hitCounter, response);
		
		assertThat(response).isNotNull();
	}
	
	private void createStubbedDeveloper()
	{
		hogwartsDeveloper = new HogwartsDeveloper();
		
		hogwartsDeveloper.setFirstName("firstName 1");
		hogwartsDeveloper.setLastName("lastName 1");
		hogwartsDeveloper.setNickname("nickname 1");
		hogwartsDeveloper.setLevel("level 1");
		hogwartsDeveloper.setPrimarySkill("primarySkill 1");		
	}	
}
