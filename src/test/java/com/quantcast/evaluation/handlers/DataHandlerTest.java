package com.quantcast.evaluation.handlers;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class DataHandlerTest {

    @Test
    public void readAllCookiesByDateWhenDateNotExist() throws Exception {
        DataHandler.readAllCookiesByDate(
                getClass().getClassLoader().getResource("ValidCookieFile.csv").getPath(), "2018-12-20");
        List<String> activeCookies = DataHandler.fetchActiveCookieRecords();
        assertEquals(0, activeCookies.size());
    }

    @Test(expected = IOException.class)
    public void readAllCookiesByDateFileEmpty() throws Exception {
        DataHandler.readAllCookiesByDate(
                getClass().getClassLoader().getResource("EmptyCookieFile.csv").getPath(), "2018-12-09");
    }

    @Test(expected = IOException.class)
    public void readAllCookiesByDateFileOnlyHeader() throws Exception {
        DataHandler.readAllCookiesByDate(
                getClass().getClassLoader().getResource("EmptyCookieFile.csv").getPath(), "2018-12-09");
    }

    @Test
    public void readAllCookiesByDateSuccess() throws Exception {
        DataHandler.readAllCookiesByDate(
                getClass().getClassLoader().getResource("ValidCookieFile.csv").getPath(), "2018-12-09");
        List<String> activeCookies = DataHandler.fetchActiveCookieRecords();
        assertEquals(4, activeCookies.size());
    }
}