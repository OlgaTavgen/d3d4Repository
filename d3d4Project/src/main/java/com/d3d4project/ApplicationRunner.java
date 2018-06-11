package com.d3d4project;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.d3d4project.hogwarts.developers.dao.HogwartsDeveloperDaoImpl;
import com.d3d4project.monitoringAndTroubleshooting.CustomFileReader;
import com.shared.service.DeveloperDocumentXMLParser;
import com.shared.service.TaskDocumentXMLParser;

public class ApplicationRunner
{	
	private final static String XML_CLASSPATH = "file:src/main/resources/spring-beans.xml";
	private final static String DEVELOPER_DAO_NAME = "hogwartsDeveloperDaoImpl";
	private final static String FILE_PATH = "src/main/resources/txt/princessOfMars.txt";
	
	public static void main(String args[]) throws InstantiationException, IllegalAccessException,
    NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException 
	{
		// monitoring and troubleshooting module
		final List<String> extractedSymbols = readFileAndExtractSymbols(FILE_PATH);
		
		generateDevelopersXml();
		generateTasksXml();
	
		ApplicationContext context = getContext(XML_CLASSPATH);
		
		HogwartsDeveloperDaoImpl hogwartsDeveloperDaoImpl = (HogwartsDeveloperDaoImpl) context.getBean(DEVELOPER_DAO_NAME);
		
		manipulateDeveloperDao(hogwartsDeveloperDaoImpl);
	}
	
	private static List<String> readFileAndExtractSymbols(final String filePath)
	{
		return new CustomFileReader().readFileAndExtractSymbols(filePath);
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
		hogwartsDeveloperDaoImpl.addDeveloper("Olga", "Tavgen", "java", "otavgen", "2", 3);
		
		hogwartsDeveloperDaoImpl.deleteDeveloper("Olga");
		
		System.out.println("firstName " + hogwartsDeveloperDaoImpl.getDeveloper("Tavgen").getFirstName());
		
		hogwartsDeveloperDaoImpl.updateDeveloperFirstName("Olga2", "Olga");		
		System.out.println("changed firstName " + hogwartsDeveloperDaoImpl.getDeveloper("Tavgen").getFirstName());
		
		hogwartsDeveloperDaoImpl.updateDeveloperLastName("Tavgen2", "Olga2");		
		System.out.println("changed lastName " + hogwartsDeveloperDaoImpl.getDeveloper("Tavgen2").getLastName());
		
		hogwartsDeveloperDaoImpl.updateDeveloperPrimarySkill("java2", "Olga2");
		System.out.println("changed primarySkill " + hogwartsDeveloperDaoImpl.getDeveloper("Tavgen2").getPrimarySkill());
		
		hogwartsDeveloperDaoImpl.updateDeveloperLevel("level2", "Olga2");		
		System.out.println("changed Level " + hogwartsDeveloperDaoImpl.getDeveloper("Tavgen2").getLevel());
		
		System.out.println("get all developers " + hogwartsDeveloperDaoImpl.getDevelopers());		
		System.out.println("simple change");
	}
}
