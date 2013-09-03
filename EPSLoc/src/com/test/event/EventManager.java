package com.test.event;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.test.backup.GameSensorEvents;
import com.test.interfaces.IEventManager;

public class EventManager implements IEventManager {

	private Configuration cepConfig = null;
	private EPAdministrator cepAdm = null;
	private static final String engineName = "CEPEngine";

	@Override
	public void eventInit(String eventType) {
		// TODO Auto-generated method stub

		cepConfig = new Configuration();
		//cepConfig.addEventType(eventType, GameEvents.class.getName());
		cepConfig.addEventType(eventType, GameSensorEvents.class.getName());
		//cepConfig.addEventType(eventType, GameMetadata.class.getName());

		EPServiceProvider cep = EPServiceProviderManager.getProvider(
				engineName, cepConfig);
		cepAdm = cep.getEPAdministrator();	
	}
}