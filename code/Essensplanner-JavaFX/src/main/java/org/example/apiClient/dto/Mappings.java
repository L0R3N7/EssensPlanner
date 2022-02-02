package org.example.apiClient.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Mappings {
    public static LocalDate StringToLocalDate(String dataString){
        return LocalDate.parse(dataString, DateTimeFormatter.ISO_DATE);
    }

    public static String LocalDateToString(LocalDate localDate){
        return DateTimeFormatter.ISO_DATE.format(localDate);
    }
}
