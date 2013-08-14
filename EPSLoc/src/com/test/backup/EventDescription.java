package com.test.backup;

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
		setUp("Game");
	}

	private void setUp(String eventType) {

		cepConfig = new Configuration();
		//cepConfig.addEventType(eventType, GameEvents.class.getName());
		cepConfig.addEventType(eventType, GameSensorEvents.class.getName());
		//cepConfig.addEventType(eventType, GameMetadata.class.getName());

		EPServiceProvider cep = EPServiceProviderManager.getProvider(
				EventDescription.engineName, cepConfig);

		cepAdm = cep.getEPAdministrator();    

	}

	public void createSelectEvent() {

		EPStatement cepStatement = cepAdm.createEPL("select * from Game");

		/*EPStatement cepStatement = cepAdm.createEPL("INSERT INTO metadata "+
				"SELECT pid,id,player,team,name,type as gamemetadata" +
				"FROM Game ");*/
		cepStatement.addListener(new EventListener());
	} 
}