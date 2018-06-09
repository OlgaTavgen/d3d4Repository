package com.d3d4project.cxf;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.d3d4project.cxf.services.CfxServiceOperator;

public final class CxfApplicationRunner 
{
	private CxfApplicationRunner()
	{		
	}
	
	public static void main(String args[]) throws Exception
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("client-beans.xml");
		
		CfxServiceOperator client = (CfxServiceOperator) context.getBean("cxfApplicationRunner");
		
		String response = client.sayHi("Joe");
		System.out.println("Response: " + response);
		System.exit(0);
	}
}
