package com.test.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class CsvReader {

	
	
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

}
