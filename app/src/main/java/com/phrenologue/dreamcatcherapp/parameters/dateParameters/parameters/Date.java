package com.phrenologue.dreamcatcherapp.parameters.dateParameters.parameters;

import java.util.Calendar;

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

    public void setCustomDay(int year, String month, int day) {
        this.dayOfMonth = day;
        this.month = monthStrToInt(month);
        this.year = year;
    }

    public int monthStrToInt(String month){
        int monthNumber = 0;
        switch (month.toLowerCase()){
            case "january":
                monthNumber = 1;
            case "february":
                monthNumber = 2;
            case "march":
                monthNumber = 3;
            case "april":
                monthNumber = 4;
            case "may":
                monthNumber = 5;
            case "june":
                monthNumber = 6;
            case "july":
                monthNumber = 7;
            case "august":
                monthNumber = 8;
            case "september":
                monthNumber = 9;
            case "october":
                monthNumber = 10;
            case "november":
                monthNumber = 11;
            case "december":
                monthNumber = 12;
        }
        return monthNumber;
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
