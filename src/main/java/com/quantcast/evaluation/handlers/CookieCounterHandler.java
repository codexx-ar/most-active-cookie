package com.quantcast.evaluation.handlers;

import com.quantcast.evaluation.model.CookieCounter;

import java.io.IOException;
import java.util.List;

public class CookieCounterHandler {

    private static CookieCounter instance;

    /**
     * Process the cookies read in memory for the data.
     * @param recordSeparator separator between date and cookie value
     * @throws IOException
     */
    public static void processActiveCookies(final String recordSeparator) throws IOException {
        instance = new CookieCounter();
        for(String line : DataHandler.fetchActiveCookieRecords()) {
            instance.addCookie(findCookie(line, recordSeparator));
        }
    }

    /**
     * find cookie value in the record.
     * @param line the record
     * @param recordSeparator the separator
     * @return cookie value
     * @throws IOException
     */
    private static String findCookie(final String line,
                                     final String recordSeparator) throws IOException {
        final String[] recordValues = line.split(recordSeparator);
        if(recordValues.length < 2) {
            throw new IOException();
        }
        return recordValues[0];
    }

    /**
     * fetch all calculated most active cookies
     * @return most active cookies
     */
    public static List<String> fetchActiveCookies() {
        return instance.fetchActiveCookies();
    }
}
