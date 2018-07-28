package com.d3d4project.multithreadingAndConcurrecncy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import com.d3d4project.multithreadingAndConcurrecncy.SimpleNumberGenerator;

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
	
	final Semaphore semaphoreConsumer = new Semaphore(0);
	final Semaphore semaphoreProducer = new Semaphore(1);

	public void generateValueAndWriteToFileForThreadsNumber(final int threadsNumber)
	{
		final String[] values = new String[threadsNumber];
		
		generateValuesTimesAndCollectToList(threadsNumber, values);
		updateTextFileWithValues(threadsNumber, values);
	}
	
	private void generateValuesTimesAndCollectToList(final int times, final String[] values)
	{
		for (int i = 0; i < times; i++)
		{			
			final ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();			
			final int numberToPullToGenerator = i;
			
			service.schedule(new Runnable() {
				
				@Override
				public void run() {

					values[numberToPullToGenerator] = generateValue(numberToPullToGenerator);
				}
			}, 0, TimeUnit.SECONDS);
		}	
	}
	
	private void updateTextFileWithValues(final int times, final String[] values)
	{
		final BufferedWriter bufferedWriter = getBufferredWriter();
		
		for (int i = 0; i < times; i++)
		{			
			final ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();			
			final int numberToPullToGenerator = i;
			
			service.schedule(new Runnable() {
				
				@Override
				public void run() {
					
					try
					{
						semaphoreProducer.acquire();
						System.out.println("semaphoreProducer acquired" + numberToPullToGenerator);
					}
					catch (final InterruptedException ie)
					{
						logger.error("Thread was interrupted before/during the activity", ie);
					}
					
					try
					{
						/* values[] is populated correctly by all threads; however, I'm getting some NPEs in case
						   some array entry has still not been populated - need additional wait mechanism here
						   probably with new volatile boolean flag
						*/
						updateFileWithConvertedNumberValue(bufferedWriter, values[numberToPullToGenerator]);//												
					}
					catch (final NullPointerException npe)
					{
						logger.error("No Bufferred Writer instantiated", npe);
					}
					semaphoreConsumer.release();
					System.out.println("semaphoreConsumer released" + numberToPullToGenerator);
				}
			}, 1, TimeUnit.SECONDS);
		}	
	}
	
	private String generateValue(final int index)
	{
		try
		{
			semaphoreConsumer.acquire();
			System.out.println("semaphoreConsumer acquired" + index);
		}
		catch (final InterruptedException ie)
		{
			logger.error("Thread was interrupted before/during the activity", ie);
		}
		final int generatedNumber = simpleNumberGenerator.generateNumber(index);
		final String convertedNumberValue = generatedNumber + CONVERT_SUFFIX;
		semaphoreProducer.release();
		System.out.println("semaphoreProducer released" + index);
		
		return convertedNumberValue;
	}
	
	private BufferedWriter getBufferredWriter()
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
		return new BufferedWriter(fileWriter);
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
			writer.newLine();
			writer.flush();
		}
		catch (final IOException ioe) 
		{
			logger.error("Could not complete file writing", ioe);
		}		
	}
}
