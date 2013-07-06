package com.test.event;

import java.util.HashMap;
import java.util.Map;

import com.test.utils.EventValue;

public class EventManager {

	/**
	 * @param args
	 */
	Map<Integer,EventValue> map = new HashMap<Integer,EventValue>();

	public void addEvent(int id, String event_name,	String event_time_real,	int event_counter,int type) {

		map.put(id, new EventValue(event_name, event_time_real, event_counter, type));
	}

	public void getEvent(){}

	public Map<Integer,EventValue> exportEventInfo() {
		return map;
	}

	public void importEventInfo(Map<Integer,EventValue> parMap) {
		map=parMap;
	}

	public String getEventName(int id) {
		if(map.containsKey(id))
		{
			return map.get(id).getEvent_name();
		}
		return null;
	}

	public void setEventName(int id,String name) {
		
		if(map.containsKey(id))
		{
			map.get(id).setEvent_name(name);
		}
	}

	public String getEventTime(int id) {

		if(map.containsKey(id))
		{
			return map.get(id).getEvent_time_real();
		}
		return null;
	}
	
	public void setEventTime(int id, String time)
	{
		if(map.containsKey(id))
		{
			map.get(id).setEvent_time_real(time);
		}
	}

	public int getEventCounter(int id) {
		if(map.containsKey(id))
		{
			return map.get(id).getEvent_counter();
		}
		return -1;
	}
	public void setEventCounter(int id, int counter) {
		if(map.containsKey(id))
		{
			map.get(id).setEvent_counter(counter);
		}
	}

	public int getEventType(int id) {
		if(map.containsKey(id))
		{
			return map.get(id).getComment();
		}
		return -1;
	}

	public void setEventType(int id, int type) {
		if(map.containsKey(id))
		{
			map.get(id).setComment(type);
		}
	}	

}
