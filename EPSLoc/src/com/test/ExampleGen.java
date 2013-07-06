package com.test;

import java.util.Date;
import java.util.Random;
import com.espertech.esper.client.*;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class ExampleGen {
	
	private static Random generator = new Random();

	public static void GenerateRandomTick(EPRuntime cepRT) {

		double price = (double) generator.nextInt(10);
		long timeStamp = System.currentTimeMillis();
		String symbol = "AAPL";
		Tick tick = new Tick(symbol, price, timeStamp);
		System.out.println("Sending tick:" + tick);
		cepRT.sendEvent(tick);
	}

	public static void main(String[] args) {

		SimpleLayout layout = new SimpleLayout();
		ConsoleAppender appender = new ConsoleAppender(new SimpleLayout());
		Logger.getRootLogger().addAppender(appender);
		Logger.getRootLogger().setLevel((Level) Level.WARN);

		//The Configuration is meant only as an initialization-time object.
		Configuration cepConfig = new Configuration();
		cepConfig.addEventType("StockTick", Tick.class.getName());
		EPServiceProvider cep = EPServiceProviderManager.getProvider("myCEPEngine", cepConfig);
		EPRuntime cepRT = cep.getEPRuntime();

		EPAdministrator cepAdm = cep.getEPAdministrator();
		EPStatement cepStatement = cepAdm.createEPL("select * from " +
				"StockTick(symbol='AAPL').win:length(2) " +
				"having avg(price) > 6.0");

		cepStatement.addListener(new CEPListener());

		// We generate a few ticks...
		for (int i = 0; i < 5; i++) {
			GenerateRandomTick(cepRT);
		}
	}
}