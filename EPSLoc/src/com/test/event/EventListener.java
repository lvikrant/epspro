package com.test.event;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class EventListener implements UpdateListener {

		public void update(EventBean[] newData, EventBean[] oldData) {
			 EventBean event = newData[0];
			System.out.println("Event received: " + event.get("*"));
			
		}
	}