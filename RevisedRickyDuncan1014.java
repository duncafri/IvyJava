/* 
 Author: Ricky Duncan
SDEV140-11
09/11/2024
Assignment: Module 2 Programming Assignment 1
*/

import java.util.GregorianCalendar;

public class MyDate {
    // Data fields
    private int year;
    private int month;
    private int day;

    // No-arg constructor that creates a MyDate object for the current date
    public MyDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        this.year = calendar.get(GregorianCalendar.YEAR);
        this.month = calendar.get(GregorianCalendar.MONTH);  // month is 0-based
        this.day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
    }

    // Constructor that constructs a MyDate object with a specified elapsed time since 1/1/1970
    public MyDate(long elapsedTime) {
        setDate(elapsedTime);
    }

    // Constructor that constructs a MyDate object with the specified year, month, and day
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // Getter methods
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    // Method to set a new date based on elapsed time since 1/1/1970
    public void setDate(long elapsedTime) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(elapsedTime);
        this.year = calendar.get(GregorianCalendar.YEAR);
        this.month = calendar.get(GregorianCalendar.MONTH);  // month is 0-based
        this.day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
    }

    // Test program
    public static void main(String[] args) {
        // Create two MyDate objects
        MyDate date1 = new MyDate();
        MyDate date2 = new MyDate(34355555133101L);

        // Display the year, month, and day for each date
        System.out.println("Date 1: " + date1.getYear() + "-" + (date1.getMonth() + 1) + "-" + date1.getDay());
        System.out.println("Date 2: " + date2.getYear() + "-" + (date2.getMonth() + 1) + "-" + date2.getDay());
    }
}