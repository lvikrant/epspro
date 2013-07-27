package com.test.event;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.google.common.collect.Lists;
import com.test.utils.CsvReader;
import com.test.utils.EventValue;

import au.com.bytecode.opencsv.CSVReader;


public class EventGenerator implements Runnable
{
	private EPRuntime cepRuntime = null;
	private Random generator = new Random();
	private Boolean stopGeneratingEvent = false;

	static double sensor_id = 0;
	static double timestamp = 0;
	static int position_x = 0;
	static int position_y = 0;
	static int position_z = 0;
	static double direction_vector = 0;
	static double acceleration_vector= 0;
	static double direction_x= 0;
	static double direction_y= 0;
	static double direction_z= 0;
	static double acceleration_x= 0;
	static double acceleration_y= 0;
	static double acceleration_z= 0;

	//GAME EVENTS

	static int event_id;
	static String event_name;
	static String event_time_real;
	static int event_counter;
	static String comment;
	
	
	static EventManager mgr;
	CsvReader csvReader = new CsvReader();
	String fileName=null;
	String eventClass=null;
	String csvSplitBy = ";";
	int eventFlag  = 0;
	
	GameEvents ge = null;
	GameSensorEvents gsEvents= null;
	
	public EventGenerator(String fileName) {

		this.fileName = fileName;
		
		if(fileName.contains("sensor"))
		{
			csvSplitBy = ",";
		}		
		/*// The Configuration is meant only as an initialization-time object.
		Configuration cepConfig = new Configuration();
		cepConfig.addEventType("GameEventsTable", GameEvents.class.getName());
		EPServiceProvider cep = EPServiceProviderManager.getProvider("CEPEngine", cepConfig);
		cepRuntime = cep.getEPRuntime();*/
	}

	@Override
	public void run() {
		while (!getStopGeneratingEvent()) {

			
			List<String[]> eventList= new ArrayList<String[]>();
			eventList = CsvReader.csvReader(fileName);
			
			for(String[] s:eventList)
			{
				for(int i=0;i<s.length;i++)
				{					
					String arr[] = s[i].split(csvSplitBy);
					
					if(arr.length>5)
					{
						gsEvents = new GameSensorEvents(Double.parseDouble(arr[0]),
								Double.parseDouble(arr[1]),
								Double.parseDouble(arr[2]),
								Double.parseDouble(arr[3]),
								Double.parseDouble(arr[4]),
								Double.parseDouble(arr[5]),
								Double.parseDouble(arr[6]),
								Double.parseDouble(arr[7]),
								Double.parseDouble(arr[8]),
								Double.parseDouble(arr[9]),
								Double.parseDouble(arr[10]),
								Double.parseDouble(arr[11]),
								Double.parseDouble(arr[12]));
						
						System.out.println("Sending event--> \t" + gsEvents);
						cepRuntime.sendEvent(gsEvents);
					}
					
					else {	
					ge = new GameEvents(Integer.parseInt(arr[0]), arr[1], arr[2],Integer.parseInt( arr[3]),arr[4]);
					System.out.println("Sending event--> \t" + ge);
					cepRuntime.sendEvent(ge);
					}
				}
			}			
			try {
				Thread.sleep(generator.nextInt(3) * 1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}			
			setStopGeneratingEvent(true);
		}
	}

	public Boolean getStopGeneratingEvent() {
		return stopGeneratingEvent;
	}

	public void setStopGeneratingEvent(Boolean stopGeneratingEvent) {
		this.stopGeneratingEvent = stopGeneratingEvent;
	}
}
