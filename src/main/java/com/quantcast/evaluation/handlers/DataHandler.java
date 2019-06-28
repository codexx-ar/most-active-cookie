package com.quantcast.evaluation.handlers;

import com.quantcast.evaluation.util.OutputUtil;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class DataHandler {

    private List<String> activeCookieRecords = new ArrayList<>();

    private static DataHandler instance;

    /**
     * Read file to get active cookies for the date and store in memory
     * @param fileName - the file with cookies
     * @param date - the date to process by
     * @throws IOException
     */
    public static void readAllCookiesByDate(final String fileName,
                                                    final String date) throws IOException {
        // TODO: can be optimized further to read first and last line
        // to check if date present in given file
        instance = new DataHandler();
        final RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "r");
        if(randomAccessFile.length() < 2) {
            throw new IOException();
        }
        randomAccessFile.readLine();
        String line;
        boolean firstLineFound = false;
        while((line = randomAccessFile.readLine()) != null) {
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

    /**
     * Return a list of all active cookie records for said date.
     * @return active cookie records
     */
    public static List<String> fetchActiveCookieRecords() {
        return instance.activeCookieRecords;
    }
}
