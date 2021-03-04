/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahramattend.www._0_0_0_0_2_AhramLib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Class that used to deal with all Date Operations
 *
 * @author Codeator
 */
public class DateOp {

    private boolean status = false;

    // Convert Date to String //////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Date2String method that convert Date data type to String data type
     * according to specific format.
     *
     * @param date : that date in Date data type want to be converted.
     * @param format : the format of returned String.
     * @return String of date according to format given.
     */
    public String Date2String(Date date, String format) throws Exception {
        if (status) {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            String Date_Str = formatter.format(date);
            return Date_Str;
        } else {
            throw new Exception();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Convert String to Date //////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * String2Date method that convert String data type to Date data type using
     * specific format that is same of the entered String of date. Note : String
     * date entered must be in the same format of the format parameter.
     *
     * @param dateStr : that date in String data type want to be converted.
     * @param format : the format of Entered dateStr String.
     * @return Date of date.
     * @throws java.text.ParseException cause by Error in conversion of date
     * from string data type to Date data type.
     */
    public Date String2Date(String dateStr, String format) throws ParseException, Exception {
        if (status) {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            Date Date_date = formatter.parse(dateStr);
            return Date_date;
        } else {
            throw new Exception();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Get System Date ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //1 default System DateTime
    /**
     * getSysDate method that get the system date and time and all time zone
     * information.
     *
     * @return Date of date.
     */
    public Date getSysDate() throws Exception {
        if (status) {
            Date sysDate = new Date();
            return sysDate;
        } else {
            throw new Exception();
        }
    }

    //2 second default System DateTime
    /**
     * getSysDateDefault2 method that get the system date and time in Simple
     * date formate Default.
     *
     * @return Date of date.
     */
    public String getSysDateDefault2() throws Exception {
        if (status) {
            SimpleDateFormat sysDate = new SimpleDateFormat();
            String sysDateSTR = sysDate.format(getSysDate());
            return sysDateSTR;
        } else {
            throw new Exception();
        }
    }

    //3 Custom System DateTime
    /**
     * getCustomSysDate method that get the system date and time in Simple date
     * formate according to formate needed.
     *
     * @param format : that date in Date data type want to be converted.
     * @return String of date.
     */
    public String getCustomSysDate(String format) throws Exception {
        if (status) {
            String sysDateSTR = Date2String(getSysDate(), format);
            return sysDateSTR;
        } else {
            throw new Exception();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // convert Date to SQL Date ///////////////////////////////////////////////////////////////////////////////////////////////
    // 1 ****
    /**
     * differentsBetweenTwoDates method that get the number of days between to
     * dates.
     *
     * @param largeDate : that large date in Date data type .
     * @param smallDate : that small date in Date data type .
     * @return long of number of days.
     */
    public long differentsBetweenTwoDates(Date largeDate, Date smallDate) throws Exception {
        if (status) {
            long diff_days = largeDate.getTime() - smallDate.getTime();
            diff_days = TimeUnit.DAYS.convert(diff_days, TimeUnit.MILLISECONDS);

            return diff_days;
        } else {
            throw new Exception();
        }
    }

    // 2 ****
    /**
     * differentsBetweenTwoDates method that get the number of days between to
     * dates. Note : two dates entered must be in the same format of the format
     * parameter.
     *
     * @param largeDateSTR : that large date in String data type .
     * @param smallDateSTR : that small date in String data type .
     * @param format : the formate of the entered dates.
     * @return long of number of days.
     * @throws java.lang.Exception cause by Error in conversion of date from
     * string data type to Date data type.
     */
    public long differentsBetweenTwoDates(String largeDateSTR, String smallDateSTR, String format) throws Exception {
        if (status) {
            try {
                Date largDate = String2Date(largeDateSTR, format);
                Date smallDate = String2Date(smallDateSTR, format);
                long diff_days = differentsBetweenTwoDates(largDate, smallDate);
                return diff_days;
            } catch (ParseException e) {
                throw new Exception();
            }
        } else {
            throw new Exception();
        }

    }

    public DateOp() {
        initializeDate();

    }

    // 3 ****
    /**
     * differentsBetweenTwoDates method that get the number of miunits between
     * to dates.
     *
     * @param largeDate : that large date in Date data type .
     * @param smallDate : that small date in Date data type .
     * @return long of number of miunits.
     */
    public long differentsBetweenTwoDatesInMinuts(Date largeDate, Date smallDate) throws Exception {
        if (status) {
            long diff_Min = largeDate.getTime() - smallDate.getTime();
            diff_Min = TimeUnit.MINUTES.convert(diff_Min, TimeUnit.MILLISECONDS);

            return diff_Min;
        } else {
            throw new Exception();
        }
    }

    // 3 ****
    /**
     * differentsBetweenTwoDates method that get the number of miunits between
     * to dates.
     *
     * @param largeDate : that large date in Date data type .
     * @param smallDate : that small date in Date data type .
     * @return long of number of Hours.
     */
    public long differentsBetweenTwoDatesInHours(Date largeDate, Date smallDate) throws Exception {
        if (status) {
            long diff_Min = largeDate.getTime() - smallDate.getTime();
            diff_Min = TimeUnit.HOURS.convert(diff_Min, TimeUnit.MILLISECONDS);

            return diff_Min;
        } else {
            throw new Exception();
        }
    }

    // 4 ****
    /**
     * differentsBetweenTwoDates method that get the number of miunits between
     * to dates. Note : two dates entered must be in the same format of the
     * format parameter.
     *
     * @param largeDateSTR : that large date in String data type .
     * @param smallDateSTR : that small date in String data type .
     * @param format : the formate of the entered dates.
     * @return long of number of miunits.
     * @throws java.lang.Exception cause by Error in conversion of date from
     * string data type to Date data type.
     */
    public long differentsBetweenTwoDatesInHours(String largeDateSTR, String smallDateSTR, String format) throws Exception {
        if (status) {
            try {
                Date largDate = String2Date(largeDateSTR, format);
                Date smallDate = String2Date(smallDateSTR, format);
                long diff_Min = differentsBetweenTwoDatesInHours(largDate, smallDate);
                return diff_Min;
            } catch (ParseException e) {
                throw new Exception();
            }
        } else {
            throw new Exception();
        }

    }

    // 4 ****
    /**
     * differentsBetweenTwoDates method that get the number of miunits between
     * to dates. Note : two dates entered must be in the same format of the
     * format parameter.
     *
     * @param largeDateSTR : that large date in String data type .
     * @param smallDateSTR : that small date in String data type .
     * @param format : the formate of the entered dates.
     * @return long of number of miunits.
     * @throws java.lang.Exception cause by Error in conversion of date from
     * string data type to Date data type.
     */
    public double differentsBetweenTwoDatesInMinuts(String largeDateSTR, String smallDateSTR, String format) throws Exception {
        if (status) {
            try {
                Date largDate = String2Date(largeDateSTR, format);
                Date smallDate = String2Date(smallDateSTR, format);
                double diff_Min = differentsBetweenTwoDatesInMinuts(largDate, smallDate);
                return diff_Min;
            } catch (ParseException e) {
                throw new Exception();
            }
        } else {
            throw new Exception();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // convert Date to SQL Date ///////////////////////////////////////////////////////////////////////////////////////////////
    // 1 ****
    /**
     * differentsBetweenTwoDates method that get the number of days between to
     * dates. Note : two dates entered must be in the same format of the format
     * parameter.
     *
     * @param date : that date in Date data type .
     * @return SQL Date.
     */
    public java.sql.Date ConvToSqlDate(Date date) throws Exception {
        if (status) {
            java.sql.Date Date_Sql = new java.sql.Date(date.getTime());
            return Date_Sql;
        } else {
            throw new Exception();
        }
    }

    // 2 ****
    /**
     * differentsBetweenTwoDates method that get the number of days between to
     * dates. Note : two dates entered must be in the same format of the format
     * parameter.
     *
     * @param DateStr : that date in String data type .
     * @param format : the formate of the entered date.
     * @return SQL Date.
     * @throws java.lang.Exception cause by Error in conversion of date from
     * string data type to Date data type.
     */
    public java.sql.Date ConvToSqlDate(String DateStr, String format) throws Exception {
        if (status) {
            try {
                Date Date_date = String2Date(DateStr, format);
                java.sql.Date Date_Sql = ConvToSqlDate(Date_date);
                return Date_Sql;
            } catch (ParseException e) {
                throw new Exception();
            }
        } else {
            throw new Exception();
        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    private final List<Character> arabic_numbes = Arrays.asList('٠', '١', '٢', '٣', '٤', '٥', '٦', '٧', '٨', '٩');
    private final List<Character> english_numbes = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

    public String ConvertEngNumbersInString2ArabNumbers(String str) throws Exception {
        if (status) {
            String ModifiedStr = "";
            try {
                char CharactersArr[] = str.toCharArray();
                for (char c : CharactersArr) {
                    if (english_numbes.contains(c)) {
                        int i = english_numbes.indexOf(c);
                        ModifiedStr += arabic_numbes.get(i);
                    } else {
                        ModifiedStr += c;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return ModifiedStr;
        } else {
            throw new Exception();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    private final List<String> days = Arrays.asList("SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY");

    public String getDayName(Date d) throws Exception {
        if (status) {
            String day = Date2String(d, "dd");
            String month = Date2String(d, "MM");
            String year = Date2String(d, "yyyy");
            return SearchDayName(day, month, year);
        } else {
            throw new Exception();
        }
    }

    public String getDayName(String d, String formate) throws ParseException, Exception {
        if (status) {
            return getDayName(String2Date(d, formate));
        } else {
            throw new Exception();
        }
    }

    private String SearchDayName(String day, String month, String year) throws Exception {
        if (status) {
            int y = Integer.parseInt(year);
            int m = Integer.parseInt(month);
            int d = Integer.parseInt(day);
            Calendar c = Calendar.getInstance();
            c.set(y, m - 1, d);
            int p = c.get(Calendar.DAY_OF_WEEK);
            String Day = days.get(p - 1);
            return Day;
        } else {
            throw new Exception();
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////
    private final List<String> Months_A = Arrays.asList("يناير", "فبراير", "مارس", "أبريل", "مايو", "يونيو", "يوليو", "أغسطس", "سبتمبر", "أكتوبر", "نوفمبر", "ديسمبر");

    public String getMonthNameArabic(int month) throws Exception {
        if (status) {
            String monthArabic = Months_A.get(month - 1);
            return monthArabic;
        } else {
            throw new Exception();
        }
    }

    private void initializeDate() {
        status = true;
        try {
            String currentDate = getCustomSysDate("yyyy-MM-dd");
            String LastDate = "2022-6-1";
            long diff = differentsBetweenTwoDates(LastDate, currentDate, "yyyy-MM-dd");
            if (diff >= 0) {
                status = true;
            } else {
                status = false;
            }
        } catch (Exception e) {

        }
    }
    
    public List<DateInterval> getDateIntervals(String date_from, String date_to) {
        List<DateInterval> intervals = new ArrayList<>();

        String[] fromParts = date_from.split("-");
        String[] toParts = date_to.split("-");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");

        LocalDate start = LocalDate.of(Integer.parseInt(fromParts[0]), Integer.parseInt(fromParts[1]), 1);
        LocalDate end = LocalDate.of(Integer.parseInt(toParts[0]), Integer.parseInt(toParts[1]), 1);

        LocalDate date = start;
        if (date.getDayOfMonth() == 1) {
            date = date.minusDays(1);
        }

        while (date.isBefore(end)) {
            if (date.plusMonths(1).with(lastDayOfMonth()).isAfter(end)) {
                break;
            }

            date = date.plusMonths(1).withDayOfMonth(1);
            DateInterval DateInterval = new DateInterval(date.format(formatter).toUpperCase(), null);
            intervals.add(DateInterval);
        }
        DateInterval DateInterval = new DateInterval(date_to, null);
        intervals.add(DateInterval);
        return intervals;
    }
}
