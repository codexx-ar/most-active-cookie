package com.quantcast.evaluation.model;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class CookieCounter {

    private final Map<String, Integer> allActiveCookiesCounter = new HashMap<>();

    /**
     * Add a new cookie to the list of active cookies
     * @param cookieValue the cookie value to add
     */
    public void addCookie(final String cookieValue) {
        if(allActiveCookiesCounter.containsKey(cookieValue)) {
            allActiveCookiesCounter.put(cookieValue, allActiveCookiesCounter.get(cookieValue) + 1);
        }
        else {
            allActiveCookiesCounter.put(cookieValue, 1);
        }
    }

    /**
     * fetch all calculated most active cookies
     * @return most active cookies
     */
    public List<String> fetchActiveCookies() {
        // TODO: can be optimized further with a reduce
        final List<String> mostActiveCookies = new ArrayList<>();
        if(allActiveCookiesCounter.size() > 0) {
            Map<String, Integer> result = allActiveCookiesCounter.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
            final int highest = (Integer) result.values().toArray()[0];
            result.entrySet().stream().filter(x -> x.getValue() == highest)
                    .forEach(x -> mostActiveCookies.add(x.getKey()));
        }
        return mostActiveCookies;
    }
}
