package com.pluralsight;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDates {
    public static void main(String[] args) {
        // Get current date/time in system default time zone
        ZonedDateTime now = ZonedDateTime.now();

        // 1. MM/dd/yyyy
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now.format(fmt1));

        // 2. yyyy-MM-dd
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(now.format(fmt2));

        // 3. Month d, yyyy
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        System.out.println(now.format(fmt3));

        // 4. Sunday, Sep 5, 2021 10:02 (in GMT)
        ZonedDateTime gmtTime = now.withZoneSameInstant(ZoneOffset.UTC);
        DateTimeFormatter fmt4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm", Locale.ENGLISH);
        System.out.println(gmtTime.format(fmt4) + " GMT");
    }
}
