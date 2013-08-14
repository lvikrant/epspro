package com.test.backup;

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

import java.util.Random;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;

public class TestInsert implements Runnable {

	private EPRuntime cepRuntime = null;
	private Random generator = new Random();
	private Boolean stopGeneratingEvent = false;
	GameSensorEvents gsEvents= null;
	GameMetadata gMeta;
	public TestInsert() {

		Configuration cepConfig = new Configuration();
		cepConfig.addEventType("Game", GameMetadata.class.getName());

		EPServiceProvider cep = EPServiceProviderManager.getProvider("CEPEngine", cepConfig);
		cepRuntime = cep.getEPRuntime();
	}

	@Override
	public void run() {

		while (!getStopGeneratingEvent()) {
			List<String[]> eventList= new ArrayList<String[]>();
			eventList = CsvReader.csvReader("metadata");

			for(String[] s:eventList)
			{
				for(int i=0;i<s.length;i++)
				{					
					String arr[] = s[i].split(";");

					gMeta =  new GameMetadata(Integer.parseInt(arr[0]),
							Integer.parseInt(arr[1]), 
							Integer.parseInt(arr[2]),
							arr[3],
							arr[4],
							arr[5]);
					System.out.println("Sending event--> \t" + gMeta);
					cepRuntime.sendEvent(gMeta);

					try {
						Thread.sleep(generator.nextInt(3) * 1000);
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
				}
			}

		}
	}

	public Boolean getStopGeneratingEvent() {
		return stopGeneratingEvent;
	}

	public void setStopGeneratingEvent(Boolean stopGeneratingEvent) {
		this.stopGeneratingEvent = stopGeneratingEvent;
	}
}