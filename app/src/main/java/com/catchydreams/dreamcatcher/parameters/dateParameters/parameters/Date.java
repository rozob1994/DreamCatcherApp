package com.catchydreams.dreamcatcher.parameters.dateParameters.parameters;

import android.util.Log;

import java.util.Calendar;
import java.util.HashMap;

import static java.lang.Math.floor;

public class Date {
    private static Date instance = null;
    private int dayOfWeek;
    private int dayOfMonth;
    private int dayOfYear;
    private int weekOfMonth;
    private int month;
    private int year;
    private java.util.Date date;

    private Date() {
    }

    public static Date getInstance() {
        if (instance == null) {
            instance = new Date();
        }
        return instance;
    }

    public static void delDate() {
        instance = null;
    }

    private Calendar today() {
        java.util.Date date = new java.util.Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public void setCustomDay(String year, String month, int day) {
        this.dayOfMonth = day;
        this.dayOfWeek = dayToWeekOfMonth(day);
        this.month = monthStrToInt(month);
        Log.e("","");
        this.year = Integer.parseInt(year);
        this.weekOfMonth = dayToWeekOfMonth(day);
        this.dayOfYear = dayOfYear(this.year,this.month,day);

    }



    /**
     * @param yearInt
     * @param monthInt
     * @param dayInt = dayOfMonth
     * @return int dayOfYear.
     */
    public static int dayOfYear(int yearInt, int monthInt, int dayInt){
        double year = yearInt;
        double month = monthInt;
        double day = dayInt;
        double N1 = floor(275 * month / 9);
        double N2 = floor((month + 9) / 12);
        double N3 = (1 + floor((year - 4 * floor(year / 4) + 2) / 3));
        double N = N1 - (N2 * N3) + day - 30;

        return (int)N;
    }

    /**
     * @param day = dayOfMonth
     * @return int weekOfMonth
     */
    public int dayToWeekOfMonth(int day){
        int weekOfMonth;
        int calc = day/7;
        if (calc==0) {
            weekOfMonth = 1;
        } else if (calc==1) {
            weekOfMonth = 2;
        } else if (calc == 2){
            weekOfMonth = 3;
        } else if (calc ==3){
            weekOfMonth = 4;
        } else {
            weekOfMonth = 0;
        }
        return weekOfMonth;
    }

    /**
     * @param month = full month's name.
     * @return int of month
     */
    public static int monthStrToInt(String month) {
        String month2 = month.toLowerCase();
        int monthInt = 0;
        switch (month2) {
            case "jan":
                monthInt = 1;
                break;
            case "feb":
                monthInt = 2;
                break;
            case "mar":
                monthInt = 3;
                break;
            case "apr":
                monthInt = 4;
                break;
            case "may":
                monthInt = 5;
                break;
            case "jun":
                monthInt = 6;
                break;
            case "jul":
                monthInt = 7;
                break;
            case "aug":
                monthInt = 8;
                break;
            case "sep":
                monthInt = 9;
                break;
            case "oct":
                monthInt = 10;
                break;
            case "nov":
                monthInt = 11;
                break;
            case "dec":
                monthInt = 12;
                break;
            case "فروردین":
                monthInt = 1;
                break;
            case "اردیبهشت":
                monthInt = 2;
                break;
            case "خرداد":
                monthInt = 3;
                break;
            case "تیر":
                monthInt = 4;
                break;
            case "مرداد":
                monthInt = 5;
                break;
            case "شهریور":
                monthInt = 6;
                break;
            case "مهر":
                monthInt = 7;
                break;
            case "آبان":
                monthInt = 8;
                break;
            case "آذر":
                monthInt = 9;
                break;
            case "دی":
                monthInt = 10;
                break;
            case "بهمن":
                monthInt = 11;
                break;
            case "اسفند":
                monthInt = 12;
                break;
        }
        return monthInt;
    }
    /**
     * @return 0 = Saturday, 1 = Sunday, 2 = Monday, 3 = Tuesday, 4 = Wednesday, 5 = Thursday,
     * 6 = Friday.
     */
    public int dateToDayOfWeek(String year, String month, int day){
        int yearInt = Integer.parseInt(year)%100;
        int yearWhole = Integer.parseInt(year);
        int yearCode = (yearInt + (yearInt/4))%7;
        HashMap<String, Integer> monthCodes = new HashMap<>();
        monthCodes.put("january",0);
        monthCodes.put("february",3);
        monthCodes.put("march",3);
        monthCodes.put("april",6);
        monthCodes.put("may",1);
        monthCodes.put("june",4);
        monthCodes.put("july",6);
        monthCodes.put("august",2);
        monthCodes.put("september",5);
        monthCodes.put("october",0);
        monthCodes.put("november",3);
        monthCodes.put("december",5);
        int monthCode = monthCodes.get(month.toLowerCase());
        int centuryCode = 6;
        int leapYearCode;
        if (((yearWhole % 4 == 0) && (yearWhole % 100!= 0)) || (yearWhole%400 == 0)){
            leapYearCode = -1;
        } else {
            leapYearCode = 0;
        }
        int result = (yearCode + monthCode + centuryCode + day + leapYearCode)%7;
        return result;
    }

    public java.util.Date getCustomDate() {
        return date;
    }

    public void setDateToday() {
        setDayOfWeek();
        setDayOfMonth();
        setDayOfYear();
        setWeekOfMonth();
        setMonth();
        setYear();
    }

    public void setDayOfWeek() {
        this.dayOfWeek = today().get(Calendar.DAY_OF_WEEK);
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfMonth() {
        this.dayOfMonth = today().get(Calendar.DAY_OF_MONTH);
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfYear() {
        this.dayOfYear = today().get(Calendar.DAY_OF_YEAR);
    }

    public int getDayOfYear() {
        return dayOfYear;
    }

    public void setWeekOfMonth() {
        this.weekOfMonth = today().get(Calendar.WEEK_OF_MONTH);
    }

    public int getWeekOfMonth() {
        return weekOfMonth;
    }

    public void setMonth() {
        this.month = today().get(Calendar.MONTH);
    }

    public int getMonth() {
        return month;
    }

    public void setYear() {
        this.year = today().get(Calendar.YEAR);
    }

    public int getYear() {
        return year;
    }

    public void setCustomDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getCustomDayOfWeek() {
        return dayOfWeek;
    }

    public void setCustomDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getCustomDayOfMonth() {
        return dayOfMonth;
    }

    public void setCustomDayOfYear(int dayOfYear) {
        this.dayOfYear = dayOfYear;
    }

    public int getCustomDayOfYear() {
        return dayOfYear;
    }

    public void setCustomWeekOfMonth(int weekOfMonth) {
        this.weekOfMonth = weekOfMonth;
    }

    public int getCustomWeekOfMonth() {
        return weekOfMonth;
    }

    public void setCustomMonth(int month) {
        this.month = month;
    }

    public int getCustomMonth() {
        return month;
    }

    public void setCustomYear(int year) {
        this.year = year;
    }

    public int getCustomYear() {
        return year;
    }

}
