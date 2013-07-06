package com.test;

import com.espertech.esper.client.*;

public class Main
{ 
	public static void main(String [] args){

		//The Configuration is meant only as an initialization-time object.
		Configuration cepConfig = new Configuration();
		// We register Ticks as objects the engine will have to handle
		cepConfig.addEventType("StockTick",Tick.class.getName());

		// We setup the engine
		EPServiceProvider cep = EPServiceProviderManager.getProvider("myCEPEngine",cepConfig);
		EPRuntime cepRT = cep.getEPRuntime();
		
		//We register an EPL statement
		EPAdministrator cepAdm = cep.getEPAdministrator();
		EPStatement cepStatement = cepAdm.createEPL("select * from " +
				"StockTick(symbol='AAPL').win:length(2) " +
				"having avg(price) > 6.0");
	}
}