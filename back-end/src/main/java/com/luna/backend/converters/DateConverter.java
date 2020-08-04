package com.luna.backend.converters;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateConverter {
    public static Long parseDate(String date){
        LocalDateTime localDateTime  = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return localDateTime
                .atZone(ZoneId.systemDefault())
                .toInstant().toEpochMilli();
    }
}
