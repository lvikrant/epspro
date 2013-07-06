package com.test.event;

import java.util.HashMap;
import java.util.Map;

import com.test.utils.EventValue;

public class EventManager {

	/**
	 * @param args
	 */
	Map<Integer,EventValue> map = new HashMap<Integer,EventValue>();
	
	//int event_id;
	//EventValue value = new EventValue(event_name, event_time_real, event_counter, comment);

	public void addEvent(int id, String event_name,	String event_time_real,	int event_counter,int type) {
		
		map.put(id, new EventValue(event_name, event_time_real, event_counter, type));
	}
	
	public void getEvent(){}
	
	public void exportEventInfo(){}
	
	public void importEventInfo(){}
	
	public void getEventName(){}
	
	public void getEventTime(){}
	
	public void getEventCounter(){}
	
	public void getEventType(){}
	
	
	public void setEventName(){}
	
	public void setEventTime(){}
	
	public void setEventCounter(){}
	
	public void setEventType(){}
	
}
