package com.quantcast.evaluation.model;

import java.util.*;
import java.util.stream.Collectors;

public class CookieCounter {

    private final Map<String, Integer> allActiveCookiesCounter = new HashMap<>();

    public void addCookie(final String cookieValue) {
        if(allActiveCookiesCounter.containsKey(cookieValue)) {
            allActiveCookiesCounter.put(cookieValue, allActiveCookiesCounter.get(cookieValue) + 1);
        }
        else {
            allActiveCookiesCounter.put(cookieValue, 1);
        }
    }

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
