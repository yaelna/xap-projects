package com.gigaspaces.exercise.processor;

import com.gigaspaces.exercise.common.City;
import org.openspaces.events.adapter.SpaceDataEvent;
import com.gigaspaces.exercise.common.Message;

import java.util.logging.Logger;


/*
 * The processor is passed interesting Objects from its associated PollingContainer
 * <p>The PollingContainer removes objects from the GigaSpace that match the criteria
 * specified for it.
 * <p>Once the Processor receives each Object, it modifies its state and returns it to
 * the PollingContainer which writes them back to the GigaSpace
 * <p>
 * <p>The PollingContainer is configured in the pu.xml file of this project
 */
public class Processor {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    /*
     * Process the given Message and return it to the caller.
     * This method is invoked using OpenSpaces Events when a matching event
     * occurs.
     */
    @SpaceDataEvent
    public Message processMessage(Message msg) {
        logger.info("Processor PROCESSING: " + msg);
        if(msg.getCity() == City.NEW_YORK){
            msg.setProcessed(true);
        }
        return msg;
    }

    public Processor() {
        logger.info("Processor instantiated, waiting for messages feed...");
    }

}