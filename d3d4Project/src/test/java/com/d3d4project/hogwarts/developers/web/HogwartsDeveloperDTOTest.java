package com.d3d4project.hogwarts.developers.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.d3d4project.hogwarts.developers.model.HogwartsDeveloper;

import static org.fest.assertions.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.containsString;

@SuppressWarnings("nls")
@RunWith(MockitoJUnitRunner.class)
public class HogwartsDeveloperDTOTest
{
	private HogwartsDeveloper developer1;
	private HogwartsDeveloper developer2;
	
	@Before
	public void init()
	{
		createStubbedDevelopers();
	}
	
	@Test
	public void testHogwartsDeveloperDTO()
	{
		final HogwartsDeveloperDTO developerDTO = new HogwartsDeveloperDTO(developer1);
		
		assertThat(developerDTO.getFirstName()).isEqualTo("First Name");
		assertThat(developerDTO.getLastName()).isEqualTo("Last Name");
		assertThat(developerDTO.getNickname()).isEqualTo("Nickname");
		assertThat(developerDTO.getPrimarySkill()).isEqualTo("Primary Skill");
	}
	
	@Test
	public void teasEquals()
	{
		final HogwartsDeveloperDTO developerDTO1 = new HogwartsDeveloperDTO(developer1);
		final HogwartsDeveloperDTO developerDTO2 = new HogwartsDeveloperDTO(developer2);
		
		assertThat(developerDTO1).isEqualTo(developerDTO1);
		assertThat(developerDTO1).isEqualTo(developerDTO2);
		
		developer2.setFirstName("First Name 2");
		
		HogwartsDeveloperDTO developerDTO3 = new HogwartsDeveloperDTO(developer2);
		
		assertThat(developerDTO1).isNotEqualTo(developerDTO3);	
		
		developer2.setFirstName("First Name");
		developer2.setLastName("Last Name 2");
		
		developerDTO3 = new HogwartsDeveloperDTO(developer2);
		
		assertThat(developerDTO1).isNotEqualTo(developerDTO3);	

		developer2.setLastName("Last Name");
		developer2.setNickname("Nickname 2");
		
		developerDTO3 = new HogwartsDeveloperDTO(developer2);
		
		assertThat(developerDTO1).isNotEqualTo(developerDTO3);	

		developer2.setNickname("Nickname");
		developer2.setPrimarySkill("Primary Skill 2");
		
		developerDTO3 = new HogwartsDeveloperDTO(developer2);
		
		assertThat(developerDTO1).isNotEqualTo(developerDTO3);
	}
	
	@Test
	public void testEquals_nullObject()
	{
		final HogwartsDeveloperDTO developerDTO1 = new HogwartsDeveloperDTO(developer1);
		final HogwartsDeveloperDTO developerDTO2 = null;
		
		assertThat(developerDTO1).isNotEqualTo(developerDTO2);
	}
	
	@Test
	public void testEquals_DifClassObject()
	{
		final HogwartsDeveloperDTO developerDTO1 = new HogwartsDeveloperDTO(developer1);
		
		assertThat(developerDTO1).isNotEqualTo(developer1);
	}
	
	@Test
	public void testHashCode()
	{
		final HogwartsDeveloperDTO developerDTO1 = new HogwartsDeveloperDTO(developer1);
		final HogwartsDeveloperDTO developerDTO2 = new HogwartsDeveloperDTO(developer1);
		
		assertThat(developerDTO1.hashCode(), is(developerDTO2.hashCode()));
	}
	
	@Test
	public void testToString()
	{
		final HogwartsDeveloperDTO developerDTO1 = new HogwartsDeveloperDTO(developer1);		
		final String s = developerDTO1.toString();
		
		assertThat(s, containsString("firstName"));
		assertThat(s, containsString("lastName"));
		assertThat(s, containsString("nickname"));
		assertThat(s, containsString("primarySkill"));
	}
	
	private void createStubbedDevelopers()
	{
		developer1 = new HogwartsDeveloper();
		
		developer1.setFirstName("First Name");
		developer1.setLastName("Last Name");
		developer1.setNickname("Nickname");
		developer1.setPrimarySkill("Primary Skill");
		
		developer2 = new HogwartsDeveloper();
		
		developer2.setFirstName("First Name");
		developer2.setLastName("Last Name");
		developer2.setNickname("Nickname");
		developer2.setPrimarySkill("Primary Skill");
	}
}
