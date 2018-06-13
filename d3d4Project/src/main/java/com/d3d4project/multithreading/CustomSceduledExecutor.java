package com.d3d4project.multithreading;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class CustomSceduledExecutor 
{
	final static int MIN = 1;
	final static int MAX = 5;
	final static String CONVERT_SUFFIX = " - number was handled";
	private final static String FILE_PATH = "src/main/resources/txt/";
	private final static String FILE_NAME = "multithreading.txt";
	
	final static Logger logger = Logger.getLogger(CustomSceduledExecutor.class); 
	
	final SimpleNumberGenerator simpleNumberGenerator = new SimpleNumberGenerator();
	
	public void generateValueAndWriteToFileForThreadsNumber(final int threadsNumber)
	{	
		FileWriter fileWriter = null;
		try
		{
			fileWriter  = new FileWriter(FILE_PATH + FILE_NAME);
		}
		catch (final IOException ioe) 
		{
			logger.error("Could not complete file writing", ioe);
		}	
		
		final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		for (int i = 0; i < threadsNumber; i++)
		{
			final ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();			
			final int numberToPullToGenerator = i;
			
			service.schedule(new Runnable() {
				
				@Override
				public void run() {
					
					final int generatedNumber = simpleNumberGenerator.generateNumber(numberToPullToGenerator);
					final String convertedNumberValue = generatedNumber + CONVERT_SUFFIX;
										
					updateFileWithConvertedNumberValue(bufferedWriter, convertedNumberValue);
				}
			}, generateDelayUpToFiveSeconds(), TimeUnit.SECONDS);
		}		
	}
	
	private int generateDelayUpToFiveSeconds()
	{
		return new Random().nextInt((MAX - MIN) + 1) + MIN;
	}
	
	private void updateFileWithConvertedNumberValue(final BufferedWriter writer, final String value)
	{
		try
		{
			writer.write(value);
		}
		catch (final IOException ioe) 
		{
			logger.error("Could not complete file writing", ioe);
		}		
	}
}
