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
     setUp("Game");
    }

    private void setUp(String eventType) {

     cepConfig = new Configuration();
     cepConfig.addEventType(eventType, GameEvents.class.getName());
     
     EPServiceProvider cep = EPServiceProviderManager.getProvider(
       EventDescription.engineName, cepConfig);

     cepAdm = cep.getEPAdministrator();    

    }
}