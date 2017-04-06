package com.mycompany.recipe;

import org.ehcache.event.CacheEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.ehcache.event.CacheEventListener;

/**
 * @author Nishanthan Krishnakumar
 * @version 1.0
 */
public class CacheEventLogger implements CacheEventListener<Object,Object> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheEventLogger.class);

    @Override
    public void onEvent(CacheEvent<Object, Object> event) {
        LOGGER.info("Event: " + event.getType() + " Key: " + event.getKey() + " old value: " + event.getOldValue() + " new value: " + event.getNewValue());
    }
}
