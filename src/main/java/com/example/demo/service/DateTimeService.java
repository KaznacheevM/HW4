package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DateTimeService {

    private static final ZoneId MOSCOW_ZONE = ZoneId.of("Europe/Moscow");

    public String getMoscowTime() {
        return getTime(MOSCOW_ZONE);
    }

    public String getMoscowDate() {
        return getDate(MOSCOW_ZONE);
    }

    private static String getTime(ZoneId zoneId) {
        ZonedDateTime dateTime = ZonedDateTime.now(zoneId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return formatter.format(dateTime);
    }

    private static String getDate(ZoneId zoneId) {
        ZonedDateTime dateTime = ZonedDateTime.now(zoneId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");
        return formatter.format(dateTime);
    }
}
