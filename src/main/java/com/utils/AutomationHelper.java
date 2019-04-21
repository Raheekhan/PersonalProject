package com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AutomationHelper {

    public static String getFormattedDate(String format) {
        Date date = new Date();
        return new SimpleDateFormat(format).format(date);
    }

    public static String getISODate() {
        return getFormattedDate("yyy-MM-dd");
    }

    public static String getISOTime() {
        return getFormattedDate("HH:mm:ss");
    }
}
