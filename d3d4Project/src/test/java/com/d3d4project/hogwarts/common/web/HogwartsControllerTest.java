package com.d3d4project.hogwarts.common.web;

import org.springframework.ui.ModelMap;

import com.d3d4project.hogwarts.common.service.HogwartsService;
import com.d3d4project.hogwarts.developers.model.HogwartsDeveloper;
import com.d3d4project.hogwarts.tasks.model.HogwartsTask;

import javax.servlet.http.HttpServletResponse;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.Assertions.assertThat;

@SuppressWarnings("nls")
@RunWith(MockitoJUnitRunner.class)
public class HogwartsControllerTest 
{	
	@Mock
	public HogwartsService hogwartsService;
	
	@Mock
	public HogwartsService.HogwartsRequest hogwartsRequest;
	
	private HogwartsController hogwartsController;
	private String team;
	private HogwartsDeveloper hogwartsDeveloper;
	private HogwartsTask hogwartsTask;
	
	@Before
	public void init()
	{
		hogwartsController = new HogwartsController();
		hogwartsTask = new HogwartsTask();
		team = "Slytherin";
		when(hogwartsService.forTeam(team)).thenReturn(hogwartsRequest);
		
		createStubbedDeveloper();
	}
	
	@Test
	public void testHogwartsHomePage()
	{
		assertThat(hogwartsController.hogwartsHomePage()).isEqualTo("/home.html");
	}
	
//	@Test
//	public void testRetrieveResults()
//	{
//		hogwartsResultsResponseDTO = hogwartsController.retrieveResults(team);
//		
//		assertThat(hogwartsResultsResponseDTO.getDevelopers()).isNotNull();
//		assertThat(hogwartsResultsResponseDTO.getTasks()).isNotNull();
//		assertThat(hogwartsResultsResponseDTO.getTeam()).isNotNull();
//	}
	
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
