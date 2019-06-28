package com.quantcast.evaluation.util;

import com.quantcast.evaluation.processor.FindMostActiveCookie;
import com.quantcast.evaluation.handlers.CookieCounterHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface OutputUtil {

    Logger logger = LoggerFactory.getLogger(FindMostActiveCookie.class);

    static void error(final String message) {
        System.err.println(message);
    }

    static void info(final String message) {
        logger.info(message);
    }

    static void debug(final String message) {
        logger.debug(message);
    }

    static void printMostActiveCookies() {
        info("Active cookies: ");
        CookieCounterHandler.fetchActiveCookies().forEach(cookie -> {
            info(cookie);
            System.out.println(cookie);
        });
    }
}
