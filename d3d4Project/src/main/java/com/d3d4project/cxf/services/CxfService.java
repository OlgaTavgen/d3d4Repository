package com.d3d4project.cxf.services;

import javax.jws.WebService;

@WebService(endpointInterface = "com.d3d4project.cxf.services.CfxServiceOperator")
public class CxfService implements CfxServiceOperator
{
	@Override
	public String sayHi(final String text) {
        System.out.println("sayHi called");
        return "Hello " + text;
    }
}
