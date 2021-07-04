package com.example.learningspring.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static Date createDateFromDateString(String dateString) throws ParseException {
        Date date = null;
        if (dateString != null) {
            try {
                date = DATE_FORMAT.parse(dateString);
            } catch (ParseException exception) {
                //use today day because it is a bad day
                date = new Date();

            }
        } else {
            date = new Date();

        }
        return date;
    }

}
