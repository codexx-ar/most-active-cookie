package com.quantcast.evaluation.model;

import java.util.HashMap;
import java.util.Map;

public class CookieCounter {

    private final Map<String, Integer> allActiveCookiesCounter = new HashMap<>();
    private final Map<String, Integer> mostActiveCookiesCounter = new HashMap<>();

    private int highestCookieCount;

    public void addCookie(final String cookieValue) {
        if(allActiveCookiesCounter.containsKey(cookieValue)) {
            allActiveCookiesCounter.put(cookieValue, allActiveCookiesCounter.get(cookieValue) + 1);
        }
        else {
            allActiveCookiesCounter.put(cookieValue, 1);
        }
        updateMostActiveCookieCounter(allActiveCookiesCounter.get(cookieValue), cookieValue);
    }

    private void updateMostActiveCookieCounter(final int currentCookieCount,
                                               final String cookieValue) {
        if(currentCookieCount > highestCookieCount) {
            highestCookieCount = currentCookieCount;
            mostActiveCookiesCounter.clear();
            mostActiveCookiesCounter.put(cookieValue, currentCookieCount);
        } else if (currentCookieCount == highestCookieCount) {
            mostActiveCookiesCounter.put(cookieValue, currentCookieCount);
        }
    }

    public Map<String,Integer> fetchActiveCookies() {
        return mostActiveCookiesCounter;
    }
}
