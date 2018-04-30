package com.shared.service;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.shared.model.XMLTagsLocators;
import com.shared.model.tasks.Task;
import com.shared.model.tasks.TaskEnum;

public class TaskDocumentXMLParser implements DocumentInterface
{
	private final static String TASKS_XML_PATH = "src/main/resources/xml/task.xml";

	@Override
	public void buildDocument() {
		
		try
		{	
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document document = docBuilder.newDocument();
			Element backlogElement = createElement(document, "backlog", "name", "Hogwarts Backlog");
			document.appendChild(backlogElement);
			
			for (final TaskEnum taskEnum : TaskEnum.values())
			{
				Element taskElement = createElement(document, XMLTagsLocators.TASK, XMLTagsLocators.TASK_ID_ATTR, taskEnum.getId());
				backlogElement.appendChild(taskElement);
			
				Task task = Task.builder()
						.type(taskEnum.getType())
						.description(taskEnum.getDescription())
						.estimate(taskEnum.getEstimate())
						.priority(taskEnum.getPriority())
						.severity(taskEnum.getSeverity())
						.build();
				
				final Element typeElement = document.createElement(XMLTagsLocators.TASK_TYPE);
				typeElement.appendChild(document.createTextNode(task.getType()));
				taskElement.appendChild(typeElement);
											
				final Element descriptionElement = document.createElement(XMLTagsLocators.TASK_DESCRIPTION);
				descriptionElement.appendChild(document.createTextNode(task.getDescription()));
				taskElement.appendChild(descriptionElement);

				final Element estimateElement = document.createElement(XMLTagsLocators.TASK_ESTIMATE);
				estimateElement.appendChild(document.createTextNode(task.getEstimate()));
				taskElement.appendChild(estimateElement);

				final Element priorityElement = document.createElement(XMLTagsLocators.TASK_PRIORITY);
				priorityElement.appendChild(document.createTextNode(task.getPriority()));
				taskElement.appendChild(priorityElement);

				final Element severityElement = document.createElement(XMLTagsLocators.TASK_SEVERITY);
				severityElement.appendChild(document.createTextNode(task.getSeverity()));
				taskElement.appendChild(severityElement);			
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(TASKS_XML_PATH));

			// Output to console for testing
//			 StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);
		}
		
		catch(ParserConfigurationException pce)
		{
			pce.printStackTrace();
		}
		catch (TransformerException tfe) 
		{
			tfe.printStackTrace();
		}		
	}
}
