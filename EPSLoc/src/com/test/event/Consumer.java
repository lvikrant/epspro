package com.test.event;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

public class Consumer {

    public static void main(String[] args) {

     ConsoleAppender appender = new ConsoleAppender(new SimpleLayout());
     Logger.getRootLogger().addAppender(appender);
     Logger.getRootLogger().setLevel((Level) Level.WARN);

     EventDescription interestedEvents = new EventDescription();
     interestedEvents.createSelectEvent();
     
     EventGenerator eventGenerator = new EventGenerator();
     eventGenerator.setStopGeneratingEvent(false);
     
     Thread tickThread = new Thread(eventGenerator);
     tickThread.start();
    }
}