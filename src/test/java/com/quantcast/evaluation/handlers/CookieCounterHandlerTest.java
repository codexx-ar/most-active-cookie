package com.quantcast.evaluation.handlers;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CookieCounterHandlerTest {

    @Test
    public void processActiveCookiesOnly1Record() throws IOException {
        readCookieFile("OnlyOneCookieFile.csv");
        CookieCounterHandler.processActiveCookies(",");
        assertEquals(1, CookieCounterHandler.fetchActiveCookies().size());
        assertEquals("AtY0laUfhglK3lC7", CookieCounterHandler.fetchActiveCookies().iterator().next());
    }

    @Test
    public void processActiveCookies2DifferentCookies() throws IOException {
        readCookieFile("TwoActiveCookiesFile.csv");
        CookieCounterHandler.processActiveCookies(",");
        assertEquals(2, CookieCounterHandler.fetchActiveCookies().size());
        assertTrue(CookieCounterHandler.fetchActiveCookies().contains("AtY0laUfhglK3lC7"));
        assertTrue(CookieCounterHandler.fetchActiveCookies().contains("SAZuXPGUrfbcn5UA"));
    }

    @Test(expected = IOException.class)
    public void processActiveCookiesInvalidRecords() throws IOException {
        readCookieFile("TwoActiveCookiesFile.csv");
        CookieCounterHandler.processActiveCookies(".");
    }

    @Test
    public void processActiveCookiesInMixed() throws IOException {
        readCookieFile("ValidCookieFile.csv");
        CookieCounterHandler.processActiveCookies(",");
        assertEquals(1, CookieCounterHandler.fetchActiveCookies().size());
        assertTrue(CookieCounterHandler.fetchActiveCookies().contains("AtY0laUfhglK3lC7"));
    }

    @Test
    public void processActiveCookiesMultipleActive() throws IOException {
        readCookieFile("MultipleActiveCookieFile.csv");
        CookieCounterHandler.processActiveCookies(",");
        assertEquals(2, CookieCounterHandler.fetchActiveCookies().size());
        assertTrue(CookieCounterHandler.fetchActiveCookies().contains("AtY0laUfhglK3lC7"));
    }

    @Test
    public void processActiveCookiesOlderDate() throws IOException {
        readCookieFile("OlderDateCookieFile.csv");
        CookieCounterHandler.processActiveCookies(",");
        assertEquals(1, CookieCounterHandler.fetchActiveCookies().size());
        assertTrue(CookieCounterHandler.fetchActiveCookies().contains("AtY0laUfhglK3lC7"));
    }

    @Test
    public void processActiveCookiesDateNotExist() throws IOException {
        readCookieFile("DateNotExistCookieFile.csv");
        CookieCounterHandler.processActiveCookies(",");
        assertEquals(0, CookieCounterHandler.fetchActiveCookies().size());
    }

    private void readCookieFile(final String fileName) throws IOException {
        DataHandler.readAllCookiesByDate(
                getClass().getClassLoader().getResource(fileName).getPath(), "2018-12-09");
    }
}