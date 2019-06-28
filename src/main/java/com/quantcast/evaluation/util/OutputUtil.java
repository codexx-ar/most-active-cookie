package com.quantcast.evaluation.util;

import com.quantcast.evaluation.handlers.CookieCounterHandler;

public interface OutputUtil {

    static void error(final String message) {
        System.err.println(message);
    }

    static void printMostActiveCookies() {
        CookieCounterHandler.fetchActiveCookies().forEach(cookie -> {
            System.out.println(cookie);
        });
    }
}
