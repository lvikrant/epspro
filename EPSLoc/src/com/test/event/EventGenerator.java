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
	static int type;
	//
	static EventManager mgr;

	public EventGenerator() {

		// The Configuration is meant only as an initialization-time object.
		Configuration cepConfig = new Configuration();
		cepConfig.addEventType("GameEventsTable", GameEvents.class.getName());
		//System.out.println("Inside EventGenerator constructor");
		EPServiceProvider cep = EPServiceProviderManager.getProvider("CEPEngine", cepConfig);
		cepRuntime = cep.getEPRuntime();
	}

	/*public static void generateEvents(EPRuntime cepRT)
	{
		Map<Integer,EventValue> map = new HashMap<Integer,EventValue>();
		String cvsSplitBy = ";";
		List<String[]> eventList= new ArrayList<String[]>();
		eventList = csvReader("Game_Interruption_1st_Half");
		for(String[] s:eventList)
		{
			for(int i=0;i<s.length;i++)
			{
				System.out.println("--> "+s[i]);
				String arr[] = s[i].split(cvsSplitBy);
				map.put(Integer.parseInt(arr[0]), new EventValue(arr[1], arr[2],Integer.parseInt( arr[3]),arr[4],0));
				mgr = new EventManager(map);
				//mgr.addEvent(Integer.parseInt(arr[0]), arr[1], arr[2],Integer.parseInt( arr[3]),arr[4],0);
			}
		}
		cepRT.sendEvent(mgr);		
	}*/

	public void generateGameInterruption()
	{}

	public void generateShotOnGoal()
	{}

	public void generateBallPossession()
	{}

	public static List<String[]> csvReader(String fName)
	{
		List<String[]> eventList= new ArrayList<String[]>();
		try {
			CSVReader reader  = new CSVReader(new FileReader("./src/com/test/resources/"+fName+".csv"));
			eventList = reader.readAll();
			reader.close();
			return eventList;			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void run() {
		while (!getStopGeneratingEvent()) {

			String cvsSplitBy = ";";
			List<String[]> eventList= new ArrayList<String[]>();
			eventList = csvReader("Game_Interruption_1st_Half");
			GameEvents ge = null;;
			for(String[] s:eventList)
			{
				for(int i=0;i<s.length;i++)
				{
					//System.out.println("--> "+s[i]);
					String arr[] = s[i].split(cvsSplitBy);
					ge = new GameEvents(Integer.parseInt(arr[0]), arr[1], arr[2],Integer.parseInt( arr[3]),arr[4]);
					System.out.println("Sending event--> \t" + ge);
					cepRuntime.sendEvent(ge);
				}
			}

			/*ge = new GameEvents(1, "test", "test", 1, "test");
			System.out.println("Sending event--> \n" + ge);
			cepRuntime.sendEvent(ge);
			 */

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
