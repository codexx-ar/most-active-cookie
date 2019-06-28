package com.quantcast.evaluation.util;

import com.quantcast.evaluation.handlers.CookieCounterHandler;

public interface OutputUtil {

    /**
     * Print any errors seen in cookie finding.
     * @param message the error message
     */
    static void error(final String message) {
        System.err.println(message);
    }

    /**
     * Print the cookie values.
     */
    static void printMostActiveCookies() {
        CookieCounterHandler.fetchActiveCookies().forEach(cookie -> {
            System.out.println(cookie);
        });
    }
}
