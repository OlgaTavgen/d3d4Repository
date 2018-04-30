package com.d3d4project.hogwarts.tasks.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.d3d4project.hogwarts.tasks.model.HogwartsTask;
import com.google.common.collect.Lists;
import com.shared.model.XMLTagsLocators;

@Component
public class HogwartsTaskService
{
	private final static String TASKS_XML_PATH = "D:/REPOSITORIES/mentoringRepository/mentoringproject/src/main/resources/xml/task.xml";
	
	public List<HogwartsTask> createTasksFromXML()
	{
		List<HogwartsTask> tasks = Lists.newArrayList();
				
		try
		{						
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.parse(new File(TASKS_XML_PATH));
		
			NodeList tasksList = doc.getElementsByTagName(XMLTagsLocators.TASK);
		
			for(int taskCount=0; taskCount<tasksList.getLength(); taskCount++)
			{
				Node taskNode = tasksList.item(taskCount);
				Element taskElement = (Element) taskNode;
				
				final HogwartsTask task = new HogwartsTask();
				
				final String id = taskElement.getAttribute(XMLTagsLocators.TASK_ID_ATTR).toString();
				task.setId(id);
				
				final Element typeElement = (Element) taskElement.getElementsByTagName(XMLTagsLocators.TASK_TYPE).item(0);
				final String type = typeElement.getFirstChild().getNodeValue();
				task.setType(type);
				
				final Element descriptionElement = (Element) taskElement.getElementsByTagName(XMLTagsLocators.TASK_DESCRIPTION).item(0);
				final String description = descriptionElement.getFirstChild().getNodeValue();
				task.setDescription(description);
				
				final Element estimateElement = (Element) taskElement.getElementsByTagName(XMLTagsLocators.TASK_ESTIMATE).item(0);
				final String estimate = estimateElement.getFirstChild().getNodeValue();
				task.setEstimate(estimate);
				
				final Element priorityElement = (Element) taskElement.getElementsByTagName(XMLTagsLocators.TASK_PRIORITY).item(0);
				final String priority = priorityElement.getFirstChild().getNodeValue();
				task.setPriority(priority);
				
				final Element severityElement = (Element) taskElement.getElementsByTagName(XMLTagsLocators.TASK_SEVERITY).item(0);
				final String severity = severityElement.getFirstChild().getNodeValue();
				task.setSeverity(severity);
					
				tasks.add(task);					
			}
		
			return tasks;	
		}
		
		catch(ParserConfigurationException pce)
		{
			pce.printStackTrace();
		}
		
		catch (SAXException se)
		{
			se.printStackTrace ();
		} 
		
		catch (IOException ioe)
		{
			ioe.printStackTrace ();
		} 
		
		return tasks;
	}

}
