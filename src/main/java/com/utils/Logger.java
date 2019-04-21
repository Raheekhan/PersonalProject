package com.utils;

import org.openqa.selenium.WebElement;

public class Logger {

    public static void logInteraction(WebElement element, String message) {
        log("Action: " + message + ", on element: '" + element + "'.");
    }

    public static void log(String string) {
        String time = AutomationHelper.getFormattedDate(AutomationHelper.getISODate() + " | " + AutomationHelper.getISOTime());
        System.out.println("" + time + " : " + string);
    }

}
