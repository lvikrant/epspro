package com.test.beans;

import java.sql.Time;

public class GameEvents {


	int event_id;
	String event_name;
	String event_time_real;
	int event_counter;
	String comment;

	public GameEvents(int event_id, String event_name, String event_time_real,
			int event_counter, String comment) {

		this.event_id = event_id;
		this.event_name = event_name;
		this.event_time_real = event_time_real;
		this.event_counter = event_counter;
		this.comment = comment;
	}

	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	  @Override
	    public String toString() {
	     return "Id: " + String.valueOf(event_id) + " Name: " + event_name.toString() +
	    		 " Time: "+event_time_real.toString()+
	    		 " Counter: "+String.valueOf(event_counter)+
	    		 " Comment: "+comment.toString();
	    }
}
