package com.test.event;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

public class EventDescription {

	private Configuration cepConfig = null;
	private EPAdministrator cepAdm = null;
	private static final String engineName = "CEPEngine";

	public EventDescription() {		
	}
	
	public EventDescription(String eventType, String eventClass) {
		setUp(eventType,eventClass);
	}

	private void setUp(String eventType, String eventClass) {
		
		
		cepConfig = new Configuration();
		cepConfig.addEventType(eventType, eventClass.getClass().getName());

		EPServiceProvider cep = EPServiceProviderManager.getProvider(EventDescription.engineName, cepConfig);

		cepAdm = cep.getEPAdministrator();    

	}

	public void createSelectEvent(String table) {

		EPStatement cepStatement = cepAdm.createEPL("select * from "+table);

		cepStatement.addListener(new EventListener());
	} 
}
