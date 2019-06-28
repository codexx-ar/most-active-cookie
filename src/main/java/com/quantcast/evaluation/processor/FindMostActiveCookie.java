package com.quantcast.evaluation.processor;

import com.quantcast.evaluation.handlers.CookieCounterHandler;
import com.quantcast.evaluation.handlers.DataHandler;
import com.quantcast.evaluation.model.CookieCounter;
import com.quantcast.evaluation.util.OutputUtil;

import java.io.IOException;

public class FindMostActiveCookie {

    public static boolean inputsValid(String[] inputs) {
        if(inputs.length < 3) {
            OutputUtil.error("Invalid input. Please check format to execute");
            return false;
        }
        return true;
    }

    public static void execute(String[] inputs) throws IOException {
        OutputUtil.debug("Reading active cookies for given date...");
        DataHandler.readAllCookiesByDate(inputs[0], inputs[2]);
        OutputUtil.debug("Processing active cookies...");
        CookieCounterHandler.processActiveCookies(inputs[1]);
        OutputUtil.debug("Printing most active cookies...");
        OutputUtil.printMostActiveCookies();
    }

}
