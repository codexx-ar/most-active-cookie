package com.quantcast.evaluation.handlers;

import com.quantcast.evaluation.model.CookieCounter;

import java.io.IOException;
import java.util.List;

public class CookieCounterHandler {

    private static CookieCounter instance;

    public static void processActiveCookies(final String recordSeparator) throws IOException {
        instance = new CookieCounter();
        for(String line : DataHandler.fetchActiveCookieRecords()) {
            instance.addCookie(findCookie(line, recordSeparator));
        }
    }

    private static String findCookie(final String line,
                                     final String recordSeparator) throws IOException {
        final String[] recordValues = line.split(recordSeparator);
        if(recordValues.length < 2) {
            throw new IOException();
        }
        return recordValues[0];
    }

    public static List<String> fetchActiveCookies() {
        return instance.fetchActiveCookies();
    }
}
