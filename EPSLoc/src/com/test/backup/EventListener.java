package com.test.backup;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class EventListener implements UpdateListener  {

	public void update(EventBean[] newData, EventBean[] oldData) {
			
		//System.out.println("Inside update");	
		System.out.println("Event received: " + newData[0].getUnderlying());
		//System.out.println("Event received: " + newData[0].getUnderlying().toString());
	}
}