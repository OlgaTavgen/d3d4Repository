package com.d3d4project.cxf.services;

import javax.jws.WebService;

@WebService
public interface CfxServiceOperator 
{
	String sayHi(final String text);
}
