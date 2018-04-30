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
import com.shared.model.developers.Developer;
import com.shared.model.developers.DeveloperEnum;
import com.shared.model.teams.TeamEnum;

public class DeveloperDocumentXMLParser implements DocumentInterface
{
	private final static String DEVELOPERS_XML_PATH = "src/main/resources/xml/developer.xml";
	private final static String PROJECT_NAME = "Hogwarts"; 

	@Override
	public void buildDocument()
	{
		try
		{	
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document document = docBuilder.newDocument();
			Element projectElement = createElement(document, XMLTagsLocators.PROJECT, XMLTagsLocators.PROJECT_NAME_ATTR, PROJECT_NAME);
			document.appendChild(projectElement);
			
			for (final TeamEnum team : TeamEnum.values())
			{
				Element teamElement = createElement(document, XMLTagsLocators.TEAM, XMLTagsLocators.TEAM_NAME_ATTR, team.getName());
				projectElement.appendChild(teamElement);
				
				for (final DeveloperEnum dev : DeveloperEnum.values())
				{
					if (dev.getTeam().equals(team.getName()))
					{
						Developer developer = Developer.builder()
								.firstName(dev.getFirstName())
								.lastName(dev.getLastName())
								.nickname(dev.getFirstName(), dev.getLastName())
								.primarySkill(dev.getPrimarySkill())
								.build();
						
						final Element developerElement = createElement(document, XMLTagsLocators.DEVELOPER, XMLTagsLocators.DEVELOPER_ID_ATTR, dev.getId());
						teamElement.appendChild(developerElement);
						
						final Element firstnameElement = document.createElement(XMLTagsLocators.DEVELOPER_FIRSTNAME);
						firstnameElement.appendChild(document.createTextNode(developer.getFirstName()));
						developerElement.appendChild(firstnameElement);

						final Element lastnameElement = document.createElement(XMLTagsLocators.DEVELOPER_LASTNAME);
						lastnameElement.appendChild(document.createTextNode(developer.getLastName()));
						developerElement.appendChild(lastnameElement);

						final Element nicknameElement = document.createElement(XMLTagsLocators.DEVELOPER_NICKNAME);
						nicknameElement.appendChild(document.createTextNode(developer.getNickname()));
						developerElement.appendChild(nicknameElement);

						final Element primarySkillElement = document.createElement(XMLTagsLocators.DEVELOPER_PRIMARYSKILL);
						primarySkillElement.appendChild(document.createTextNode(developer.getPrimarySkill()));
						developerElement.appendChild(primarySkillElement);
					}
				}
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(DEVELOPERS_XML_PATH));

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
