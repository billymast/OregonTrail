// Time Class
// Keeps track and updates the date as the game progresses
// Author: Billy Mast

package com.example.oregontrail;

public class Time {

    private int year;
    private static int month;
    private int day;

    // Simple array of month names
    private final String[] months = {
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
    };

    // Array containing length of each month
    // In order 31 -> January, 28 -> February, 31 -> March, etc.
    private final int[] monthDays = {
            31,
            28,
            31,
            30,
            31,
            30,
            31,
            30,
            31,
            30,
            31,
            30
    };

    // Constructors
    // Need to update both years depending on when the game takes place

    public Time() {
        this.year = 1900;
        this.month = 1;
        this.day = 1;
    }


    // Will need to update depending on how we pick month at start of game
    public Time(int month) {
        this.year = 1900;
        this.month = month;
        this.day = 1;
    }



    // Getters and Setters

    // getYear - Returns the current year
    // @return year - Current year
    public int getYear() {
        return year;
    }

    // setYear - Sets year to entered year
    // @param year - year to change to
    public void setYear(int year) {
        this.year = year;
    }

    // getMonth - returns the current month
    // @return month - current month in game
    public int getMonth() {
        return month;
    }

    // setMonth - sets month to entered month
    // @param month - month to change to
    public void setMonth(int month) {
        this.month = month;
    }

    // getDay - returns the current day of the month
    // @return day - current day of the month in the game
    public int getDay() {
        return day;
    }

    // setDay - sets day to entered day
    // @param day - day to change to
    public void setDay(int day) {
        this.day = day;
    }

    // Other Methods

    // updateDay - progresses to the next day on the calendar
    public void updateDay(int numDays){

        for (int i = 0; i < numDays; i++) {
            if (this.day == monthDays[this.month - 1]) {
                this.day = 1;
                this.month++;
                if (this.month > 12) {
                    this.month = 1;
                    year++;
                }
            }
            else { this.day++; }
        }
    }

    // outputDate - outputs a string containing the current date in the game
    // @return - date in format month/day/year
    public String outputDate() {
        return (months[this.month - 1] + " " + this.day + " " + this.year);
    }

}
