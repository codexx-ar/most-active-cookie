package com.quantcast.evaluation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class FindMostActiveCookie {

    private static Logger logger = LoggerFactory.getLogger(FindMostActiveCookie.class);

    public static void main(String [] args) {
        if(args.length < 2) {
            logger.error("Invalid input. Please check format to execute");
        }
        final File fileToRead = new File(args[0]);
        if(!fileToRead.exists()) {
            logger.error("File %s does not exist.", args[0]);
        }

    }
}
