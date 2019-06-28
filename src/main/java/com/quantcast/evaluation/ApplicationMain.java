package com.quantcast.evaluation;

import com.quantcast.evaluation.processor.FindMostActiveCookie;
import com.quantcast.evaluation.util.OutputUtil;

import java.io.IOException;

public class ApplicationMain {
    public static void main(final String [] inputs) {
        try {
            final FindMostActiveCookie findMostActiveCookieInstance = new FindMostActiveCookie();
            if(findMostActiveCookieInstance.inputsValid(inputs)) {
                findMostActiveCookieInstance.execute(inputs);
            }
        } catch (IOException e) {
            OutputUtil.error("Input file has some errors.");
        }
    }
}
