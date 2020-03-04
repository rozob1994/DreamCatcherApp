package com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters;

import java.util.Calendar;
import java.util.Date;

public class DreamDate {
    private static final DreamDate instance = new DreamDate();
    private int dayOfWeek;
    private int dayOfMonth;
    private int dayOfYear;
    private int weekOfMonth;
    private int month;
    private int year;
    private Date date;

    Calendar calendar = Calendar.getInstance();

    private DreamDate(){
        this.date = new Date();
    }

    private DreamDate(Date date) {
        this.date = date;
        calendar.setTime(date);
        setDayOfWeek(calendar.DAY_OF_WEEK);
        setDayOfMonth(calendar.DAY_OF_MONTH);
        setDayOfYear(calendar.DAY_OF_YEAR);
        setWeekOfMonth(calendar.WEEK_OF_MONTH);
        setMonth(calendar.MONTH);
        setYear(calendar.YEAR);
    }

    public static DreamDate getInstance(){
        return instance;
    }


    int today = calendar.DAY_OF_WEEK;

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getDayOfYear() {
        return dayOfYear;
    }

    public void setDayOfYear(int dayOfYear) {
        this.dayOfYear = dayOfYear;
    }

    public int getWeekOfMonth() {
        return weekOfMonth;
    }

    public void setWeekOfMonth(int weekOfMonth) {
        this.weekOfMonth = weekOfMonth;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getDate() {
        return date;
    }
}
