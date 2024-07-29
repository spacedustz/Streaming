package com.streaming.utils;

public class DateUtil {
    public static String parseTimeToString(String time) {
        if (time == null) return null;

        if (time.matches("\\d{4}")) {
            return time.substring(0, 2) + ":" + time.substring(2, 4);
        } else if (time.matches("\\d{1,2}:\\d{2}")) {
            return time;
        } else {
            throw new IllegalArgumentException("Invalid Time Format: " + time);
        }
    }
}
