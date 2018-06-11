package com.d3d4project.monitoringAndTroubleshooting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.common.collect.Lists;

import shared.HogwartsTestHelper;

public class CustomFileReader 
{
	final static Logger logger = Logger.getLogger(CustomFileReader.class);
	
	// bad variable for memory leak
	String fragment = null;
	
	public List<String> readFileAndExtractSymbols(final String filePath)
	{
		final List<String> extractedSymbols = Lists.newArrayList();
		
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))) 
		{
			for(String line; (line = br.readLine()) != null; ) 
			{
				if (line.length() > 0)
				{
					int i = 0;
					while (i < 1000000)
					{
						final String symbols = line.substring(0, 3);
						fragment = new String(symbols);
						extractedSymbols.add(fragment);
						i++;
						
						System.out.println(i);
					}					
				}		        
		    }
		}
		catch (final FileNotFoundException fe)
		{
			logger.error("File" + filePath + "is not found", fe);
		}
		catch (final IOException ioe)
		{
			logger.error("Could not complete file reading", ioe);
		}
		return extractedSymbols;
	}
}
