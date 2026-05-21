package com.shen.chapter01;

public class YearMonth {
    private final int year;
    private final int month;

    public YearMonth(int year, int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
        this.year = year;
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public boolean isLeapYear() {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }

    public int getDaysInMonth() {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear() ? 29 : 28;
            default -> throw new IllegalArgumentException("Invalid month: " + month);
        };
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }

    public static int getDaysInMonth(int year, int month) {
        return new YearMonth(year, month).getDaysInMonth();
    }
}
