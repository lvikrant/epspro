package com.test.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EventValue {

	/**
	 * Comment is converted to type of event:
	 * 0: Game Interruption
	 * 1: Shot on Goal
	 * 2: Ball Possession
	 * 
	 */
	
	
	String event_name;
	//String event_time_real;
	int event_counter;
	int comment;
	Date time = new Date();
	SimpleDateFormat format = new SimpleDateFormat("HH:mm:SS.SSS");
	String event_time_real = format.format(time);
	
	public EventValue(String event_name, String event_time_real,
			int event_counter, int comment) {
		super();
		this.event_name = event_name;
		this.event_time_real = event_time_real;
		this.event_counter = event_counter;
		this.comment = comment;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getEvent_time_real() {
		return event_time_real;
	}
	public void setEvent_time_real(String event_time_real) {
		this.event_time_real = event_time_real;
	}
	public int getEvent_counter() {
		return event_counter;
	}
	public void setEvent_counter(int event_counter) {
		this.event_counter = event_counter;
	}
	public int getComment() {
		return comment;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
}
