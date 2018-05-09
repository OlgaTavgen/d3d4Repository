package com.d3d4project;

import java.lang.reflect.InvocationTargetException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.d3d4project.hogwarts.developers.dao.HogwartsDeveloperDaoImpl;
import static com.shared.model.HogwartsDeveloperLocators.*;
import com.shared.service.DeveloperDocumentXMLParser;
import com.shared.service.TaskDocumentXMLParser;

public class ApplicationRunner
{	
	private final static String XML_CLASSPATH = "file:src/main/resources/spring-beans.xml";
	private final static String DEVELOPER_DAO_NAME = "hogwartsDeveloperDaoImpl";
	
	public static void main(String args[]) throws InstantiationException, IllegalAccessException,
    NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException 
	{
		generateDevelopersXml();
		generateTasksXml();
	
		ApplicationContext context = getContext(XML_CLASSPATH);
		
		HogwartsDeveloperDaoImpl hogwartsDeveloperDaoImpl = (HogwartsDeveloperDaoImpl) context.getBean(DEVELOPER_DAO_NAME);
		
		manipulateDeveloperDao(hogwartsDeveloperDaoImpl);
	}
	
	private static void generateDevelopersXml()
	{
		new DeveloperDocumentXMLParser().buildDocument();
	}
	
	private static void generateTasksXml()
	{
		new TaskDocumentXMLParser().buildDocument();
	}
	
	private static ApplicationContext getContext(final String path)
	{
		return new ClassPathXmlApplicationContext(path);
	}
	
	private static void manipulateDeveloperDao(final HogwartsDeveloperDaoImpl hogwartsDeveloperDaoImpl)
	{
		hogwartsDeveloperDaoImpl.addDeveloper(
				DEV1_FIRST_NAME,
				DEV1_LAST_NAME,
				DEV1_PRIMARY_SKILL,
				DEV1_NICKNAME,
				DEV1_LEVEL,
				DEV1_TEAM);
		
		hogwartsDeveloperDaoImpl.deleteDeveloper(DEV1_FIRST_NAME);
		
		System.out.println("firstName " + hogwartsDeveloperDaoImpl.getDeveloper(DEV1_LAST_NAME).getFirstName());
		
		hogwartsDeveloperDaoImpl.updateDeveloperFirstName(DEV2_FIRST_NAME, DEV1_FIRST_NAME);		
		System.out.println("changed firstName " + hogwartsDeveloperDaoImpl.getDeveloper(DEV1_FIRST_NAME).getFirstName());
		
		hogwartsDeveloperDaoImpl.updateDeveloperLastName(DEV2_LAST_NAME, DEV2_FIRST_NAME);		
		System.out.println("changed lastName " + hogwartsDeveloperDaoImpl.getDeveloper(DEV2_LAST_NAME).getLastName());
		
		hogwartsDeveloperDaoImpl.updateDeveloperPrimarySkill(DEV2_PRIMARY_SKILL, DEV2_FIRST_NAME);
		System.out.println("changed primarySkill " + hogwartsDeveloperDaoImpl.getDeveloper(DEV2_LAST_NAME).getPrimarySkill());
		
		hogwartsDeveloperDaoImpl.updateDeveloperLevel(DEV2_PRIMARY_SKILL, DEV2_FIRST_NAME);		
		System.out.println("changed Level " + hogwartsDeveloperDaoImpl.getDeveloper(DEV2_LAST_NAME).getLevel());
		
		System.out.println("get all developers " + hogwartsDeveloperDaoImpl.getDevelopers());
	}
}
