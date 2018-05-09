package com.shared.service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface DocumentInterface {
	
	void buildDocument();	
	
	default Element createElement(final Document doc, final String elementName, final String attrKey, final String attrValue)
	{
		Element element = doc.createElement(elementName);
		element.setAttribute(attrKey, attrValue);
		
		return element;
	}
}
