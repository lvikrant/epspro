package com.test.event;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

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

public class EventGenerator
{
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

	public static void generateEvents(EPRuntime cepRT)
	{
		List<List<String>> listOfLists = read_csv("Game_Interruption_1st_Half");
		//		GameMain game= new GameMain(sensor_id, timestamp, position_x, 
		//				position_y, position_z, direction_vector, acceleration_vector, 
		//				direction_x, direction_y, direction_z,
		//				acceleration_x, acceleration_y, acceleration_z);
		//		System.out.println("Sending tick:" + game);
		GameEvents gEvents = new GameEvents(event_id, event_name, event_time_real, event_counter, comment);
		for (List<String> list : listOfLists) {
			
			for(String s:list) {

				gEvents = new GameEvents(Integer.parseInt();
				cepRT.sendEvent(gEvents); 
			}
		}


		//		cepRT.sendEvent(game);
	}


	public void generateGameInterruption()
	{}

	public void generateShotOnGoal()
	{}

	public void generateBallPossession()
	{}



	public static List<List<String>> read_csv(String file_name)
	{
		String csvFile = "./"+file_name+".csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
		String[] event = null ;
		List<String> eventList= new ArrayList<String>();
		List<List<String>> listOfLists = Lists.newArrayList();
		try {	 
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				event= line.split(cvsSplitBy);
				eventList.add(line.split(cvsSplitBy).toString());

				System.out.println("Event id= " + event[0] 
						+ " , name=" + event[1] 
								+ " , time=" + event[2] 
										+ " , counter=" + event[3]
												+ " , comment=" + event[4]
						);
				listOfLists.add(eventList);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}			
		}
		return listOfLists;

	}

	public void readTest()
	{
		CSVReader reader  = new CSVReader
	}
	public static void main(String[] args) {

		SimpleLayout layout = new SimpleLayout();
		ConsoleAppender appender = new ConsoleAppender(new SimpleLayout());
		Logger.getRootLogger().addAppender(appender);
		Logger.getRootLogger().setLevel((Level) Level.WARN);

		//The Configuration is meant only as an initialization-time object.
		Configuration cepConfig = new Configuration();
		cepConfig.addEventType("Game", GameMain.class.getName());
		EPServiceProvider cep = EPServiceProviderManager.getProvider("myCEPEngine", cepConfig);
		EPRuntime cepRT = cep.getEPRuntime();

		EPAdministrator cepAdm = cep.getEPAdministrator();
		EPStatement cepStatement = cepAdm.createEPL(
				"select * from " +
				"Game");
		cepStatement.addListener(new EventListener());
		generateEvents(cepRT);
	}	
}
