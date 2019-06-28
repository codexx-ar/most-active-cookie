package com.quantcast.evaluation.handlers;

import com.quantcast.evaluation.util.OutputUtil;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class DataHandler {

    private List<String> activeCookieRecords = new ArrayList<>();

    private static DataHandler instance = new DataHandler();

    public static void readAllCookiesByDate(final String fileName,
                                                    final String date) throws IOException {
        final RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "r");
        if(randomAccessFile.length() < 2) {
            throw new IOException();
        }
        randomAccessFile.readLine();
        String line;
        boolean firstLineFound = false;
        while((line = randomAccessFile.readLine()) != null) {
            OutputUtil.debug("Line being processed from file: " + line);
            line = line.trim();
            if(!line.isEmpty() && line.contains(date)) {
                firstLineFound = true;
                instance.activeCookieRecords.add(line);
            }
            else if(firstLineFound) {
                break;
            }
        }
    }

    public static List<String> fetchActiveCookieRecords() {
        return instance.activeCookieRecords;
    }
}
